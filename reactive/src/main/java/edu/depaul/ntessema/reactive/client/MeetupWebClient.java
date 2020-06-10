package edu.depaul.ntessema.reactive.client;

import edu.depaul.ntessema.reactive.model.MeetupRSVP;
import edu.depaul.ntessema.reactive.model.RSVP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Signal;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Consumer;

@Component
@Slf4j
public class MeetupWebClient {

    private Consumer<Signal<RSVP>> consumer = rsvpSignal -> {
        if(rsvpSignal.hasValue()) {
            log.info(rsvpSignal.get().getEventUrl());
        }
    };

    public Flux<RSVP> consumeDataStream() {

        final String HOST = "http://stream.meetup.com";
        final String ENDPOINT = "/2/rsvps";

        return  WebClient.create(HOST)
                .get()
                .uri(ENDPOINT)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(MeetupRSVP.class)
                .filter(Objects::nonNull)
                .map(MeetupRSVP::toRSVP)
                .doOnError(e -> log.info(e.getMessage()))
                .doOnEach(consumer)
                .take(20)
                .take(Duration.ofSeconds(5));
    }
}
