package edu.depaul.ntessema.reactive.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class RSVP {
    private String eventName;
    private String time;
    private String groupName;
    private String groupCountry;
    private String groupCity;
    private List<String> topics;
    private String venue;
    private String eventUrl;
}
