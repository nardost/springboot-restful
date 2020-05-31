package edu.depaul.ntessema.se457.research.hateoas.controller;

import edu.depaul.ntessema.se457.research.hateoas.model.Sage;
import edu.depaul.ntessema.se457.research.hateoas.service.SageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HateoasSageController {

    private final SageService sageService;

    @Autowired
    public HateoasSageController(SageService service) {
        this.sageService = service;
    }

    @GetMapping("/hateoas-sages")
    public List<Sage> findAll() {
        return sageService.findAll();
    }

    @GetMapping("/hateoas-sage/{name}")
    public Sage getSageByName(@PathVariable(required = true) String name) {
        return sageService.findByName(name);
    }
}
