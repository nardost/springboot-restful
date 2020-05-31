package edu.depaul.ntessema.se457.research.hateoas.service;

import edu.depaul.ntessema.se457.research.hateoas.model.Sage;
import edu.depaul.ntessema.se457.research.hateoas.repository.SageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SageService {

    private final SageRepository sageRepository;

    @Autowired
    public SageService(SageRepository repository) {
        this.sageRepository = repository;
    }

    public List<Sage> findAll() {
        return sageRepository.findAll();
    }

    public Sage findById(final String id) {
        return sageRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Sage findByName(final String name) {
        return sageRepository.findFirstByName(name);
    }
}
