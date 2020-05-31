package edu.depaul.ntessema.se457.research.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

@Data
@Document(collection = "quotes")
public class Quote extends RepresentationModel<Quote> {

    @Id
    private String id;
    private String quote;
    private String by;

    @JsonCreator
    public Quote() {
    }

    @JsonCreator
    public Quote(@JsonProperty("quote") String quote) {
        this.quote = quote;
    }
}
