package edu.depaul.ntessema.reactive.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
public class RSVP {
    private String eventName;
    private Instant time;
    private String groupName;
    private String groupCountry;
    private String groupCity;
    private String topics;
    private String venue;
    private String eventUrl;
}
