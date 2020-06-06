package edu.depaul.ntessema.se457.research.hateoas.controller;

import edu.depaul.ntessema.se457.research.hateoas.model.Quote;
import edu.depaul.ntessema.se457.research.hateoas.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author nardos
 *
 * Adapted from https://spring.io/guides/gs/rest-hateoas/
 */
@RestController
public class HateoasQuoteController {

    private final QuoteService quoteService;

    @Autowired
    public HateoasQuoteController(QuoteService service) {
        this.quoteService = service;
    }

    @GetMapping("/hateoas-quotes")
    public List<HttpEntity<Quote>> getQuotes() {
        List<HttpEntity<Quote>> entities = new ArrayList<>();
        List<Quote> quotes = quoteService.findAll();
        quotes.forEach(q -> {
            q.add(linkTo(methodOn(HateoasQuoteController.class)
                            .getQuoteById(q.getId()))
                            .withRel("quote-details"));
            entities.add(new ResponseEntity<>(q, HttpStatus.OK));
        });
        return entities;
    }

    @GetMapping("/hateoas-quote/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable(required = true) String id) {
        Quote quote = quoteService.findById(id);
        quote.add(linkTo(methodOn(HateoasQuoteController.class)
                        .getQuoteById(id))
                        .withSelfRel())
                .add(linkTo(methodOn(HateoasSageController.class)
                        .getSageByName(quote.getBy()))
                        .withRel("sayer-details"));
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }
}
