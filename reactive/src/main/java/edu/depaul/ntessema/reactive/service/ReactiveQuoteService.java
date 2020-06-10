package edu.depaul.ntessema.reactive.service;

import edu.depaul.ntessema.reactive.model.Quote;
import edu.depaul.ntessema.reactive.repository.ReactiveQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author nardos
 *
 * Internal service APIs
 */
@Service
public class ReactiveQuoteService {

    private final ReactiveQuoteRepository reactiveQuoteRepository;

    @Autowired
    public ReactiveQuoteService(ReactiveQuoteRepository reactiveQuoteRepository) {
        this.reactiveQuoteRepository = reactiveQuoteRepository;
    }

    public Flux<Quote> getAllQuotes() {
        return reactiveQuoteRepository.findAll();
    }

    public Mono<Quote> getQuoteById(String id) {
        return reactiveQuoteRepository.findById(id);
    }
}
