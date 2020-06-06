package edu.depaul.ntessema.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quotes")
public class Quote {
    @Id
    private String id;
    private String quote;
    private String by;
}
