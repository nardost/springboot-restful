package edu.depaul.ntessema.se457.research.cache.controller;

import edu.depaul.ntessema.se457.research.cache.model.Quote;
import edu.depaul.ntessema.se457.research.cache.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService service) {
        this.quoteService = service;
    }

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return quoteService.findAll();
    }

}
