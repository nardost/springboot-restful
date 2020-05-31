package edu.depaul.ntessema.se457.research.hateoas.repository;

import edu.depaul.ntessema.se457.research.hateoas.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuoteRepository extends MongoRepository<Quote, String> {
}
