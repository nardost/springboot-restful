package edu.depaul.ntessema.se457.research.hateoas.repository;

import edu.depaul.ntessema.se457.research.hateoas.model.Sage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SageRepository extends MongoRepository<Sage, String> {
    Sage findFirstByName(final String name);
}
