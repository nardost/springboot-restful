package edu.depaul.ntessema.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quote {
    @Id
    private String id;
    private String quote;
    private String by;
}
