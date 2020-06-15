package edu.depaul.ntessema.se457.research.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
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
