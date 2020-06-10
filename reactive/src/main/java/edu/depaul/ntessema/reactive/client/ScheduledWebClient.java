package edu.depaul.ntessema.reactive.client;

import edu.depaul.ntessema.reactive.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Signal;

import java.time.Duration;
import java.util.function.Consumer;

@Component
@Slf4j
public class ScheduledWebClient {

    private final Consumer<Signal<Quote>> consumer = quoteSignal -> {
        if(quoteSignal.hasValue()) {
            Quote quote = quoteSignal.get();
            if(quote != null) {
                log.info(quote.getQuote());
            }
        }
    };

    @Scheduled(fixedDelay = 86400)
    public void consumeReactiveService() {
        WebClient webClient = WebClient.create("http://localhost:8082/");
        webClient
                .get()
                .uri("/quote-flux")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Quote.class)
                .doOnEach(consumer)
                .take(Duration.ofSeconds(13))
                .subscribe();
    }
}
