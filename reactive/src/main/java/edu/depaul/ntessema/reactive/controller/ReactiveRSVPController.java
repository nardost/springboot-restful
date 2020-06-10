package edu.depaul.ntessema.reactive.controller;

import edu.depaul.ntessema.reactive.client.MeetupWebClient;
import edu.depaul.ntessema.reactive.model.RSVP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ReactiveRSVPController {

    private final MeetupWebClient webClient;

    @Autowired
    public ReactiveRSVPController(MeetupWebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping(value = "/rsvp-flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<RSVP> getMeetupRSVPs() {
        return webClient.consumeDataStream();
    }
}
