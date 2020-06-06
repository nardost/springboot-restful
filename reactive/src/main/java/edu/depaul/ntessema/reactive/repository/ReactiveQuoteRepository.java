package edu.depaul.ntessema.reactive.repository;

import edu.depaul.ntessema.reactive.model.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveQuoteRepository extends ReactiveMongoRepository<Quote, String> {
}
