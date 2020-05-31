package edu.depaul.ntessema.se457.research.cache.service;

import edu.depaul.ntessema.se457.research.cache.model.Quote;
import edu.depaul.ntessema.se457.research.cache.repository.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nardos
 *
 * A Cacheable RESTful Web Service
 */
@Service
@Slf4j
public class QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository repository) {
        this.quoteRepository = repository;
    }

    @Cacheable("quotes")
    public List<Quote> findAll() {
        List<Quote> quotes;
        try {
            /*
             * Simulate a costly/time-consuming operation.
             */
            log.info("A slow service...");
            Thread.sleep(5000L);
            quotes = quoteRepository.findAll();
        } catch (InterruptedException ie) {
            quotes = new ArrayList<>();
        }
        return quotes;
    }
}
