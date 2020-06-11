package edu.depaul.ntessema.reactive.controller;

import edu.depaul.ntessema.reactive.model.Quote;
import edu.depaul.ntessema.reactive.service.ReactiveQuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Objects;

@RestController
@Slf4j
public class ReactiveQuoteController {

    private final ReactiveQuoteService reactiveQuoteService;

    @Autowired
    public ReactiveQuoteController(ReactiveQuoteService service) {
        this.reactiveQuoteService = service;
    }

    @GetMapping(value = "/quote-flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Quote> getQuotes() {

        return reactiveQuoteService.getAllQuotes()
                .doFirst(() -> log.info("Start streaming."))
                .delayElements(Duration.ofMillis(500))
                .limitRequest(20)
                //.filter(q -> q.getQuote().length() < 50)
                .doOnEach(q -> log.info(Objects.requireNonNull(q.get()).getBy()))
                .doOnCancel(() -> log.info("Streaming cancelled"))
                .doOnComplete(() -> log.info("Streaming completed"))
                .onErrorReturn(new Quote());
    }

    @GetMapping(value = "/quote-mono/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Quote> getQuote(@PathVariable String id) {
        return reactiveQuoteService.getQuoteById(id).defaultIfEmpty(new Quote());
    }
}
