package edu.depaul.ntessema.se457.research.hateoas.service;

import edu.depaul.ntessema.se457.research.hateoas.model.Quote;
import edu.depaul.ntessema.se457.research.hateoas.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository repository) {
        this.quoteRepository = repository;
    }

    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    public Quote findById(String id) {
        return quoteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
