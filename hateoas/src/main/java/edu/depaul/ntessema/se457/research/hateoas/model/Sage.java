package edu.depaul.ntessema.se457.research.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sages")
public class Sage {
    @Id
    private String id;
    private String name;
    private String saidOn;
    private String language;

    @JsonCreator
    public Sage() {
    }

    @JsonCreator
    public Sage(@JsonProperty("name") String name,
                @JsonProperty("date") String date,
                @JsonProperty("language") String language) {
        this.name = name;
        this.saidOn = date;
        this.language = language;
    }
}
