package edu.depaul.ntessema.se457.research.cache.repository;

import edu.depaul.ntessema.se457.research.cache.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuoteRepository extends MongoRepository<Quote, String> {
}
