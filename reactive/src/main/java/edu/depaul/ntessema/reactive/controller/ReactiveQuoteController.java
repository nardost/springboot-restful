package edu.depaul.ntessema.reactive.controller;

import edu.depaul.ntessema.reactive.model.Quote;
import edu.depaul.ntessema.reactive.repository.ReactiveQuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Consumer;

@RestController
@Slf4j
public class ReactiveQuoteController {

    private final ReactiveQuoteRepository reactiveQuoteRepository;

    @Autowired
    public ReactiveQuoteController(ReactiveQuoteRepository repository) {
        this.reactiveQuoteRepository = repository;
    }

    @GetMapping(value = "/quote-flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Quote> getQuotes() {
        Consumer<Quote> consumer = quote -> log.info(quote.getQuote());
        return reactiveQuoteRepository.findAll()
                .doFirst(() -> log.info("Done first"))
                .delayElements(Duration.ofSeconds(1))
                .doOnEach(e -> consumer.accept(e.get()))
                .limitRequest(10)
                .doOnComplete(() -> log.info("Completed"))
                .doOnCancel(() -> log.info("Cancelled"));
    }
}
