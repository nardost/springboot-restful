package edu.depaul.ntessema.reactive.handler;

import edu.depaul.ntessema.reactive.model.Quote;
import edu.depaul.ntessema.reactive.repository.ReactiveQuoteRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;

@Component
public class QuoteHandler {

    private final ReactiveQuoteRepository quoteRepository;

    public QuoteHandler(ReactiveQuoteRepository repository) {
        this.quoteRepository = repository;
    }

    public Flux<Quote> getAllQuotes(ServerRequest request) {
        return quoteRepository.findAll();
    }
}
