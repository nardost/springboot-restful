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
                .doFirst(() -> log.info("Done first"))
                .filter(q -> q.getQuote().length() < 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnComplete(() -> log.info("Completed"))
                .doOnCancel(() -> log.info("Cancelled"));
    }

    @GetMapping(value = "/quote-mono/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Quote> getQuote(@PathVariable String id) {
        return reactiveQuoteService.getQuoteById(id).defaultIfEmpty(new Quote()).log().metrics();
    }
}
