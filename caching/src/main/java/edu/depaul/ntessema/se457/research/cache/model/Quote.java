package edu.depaul.ntessema.se457.research.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quotes")
@AllArgsConstructor
public class Quote {
    @Id
    private String id;
    private String quote;
    private String by;
}
