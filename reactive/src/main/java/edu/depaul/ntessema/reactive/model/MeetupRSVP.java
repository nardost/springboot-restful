package edu.depaul.ntessema.reactive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetupRSVP {
    private MeetupEvent event;
    private MeetupGroup group;
    private Integer guests;
    private MeetupMember member;
    private Long mtime;
    private String response;
    private String rsvpId;
    private MeetupVenue venue;
    private String visibility;

    public static RSVP toRSVP(MeetupRSVP meetupRSVP) {
        RSVP rsvp = new RSVP();
        rsvp.setEventName((meetupRSVP.getEvent() != null) ? meetupRSVP.getEvent().getEventName() : "");
        rsvp.setTime(Instant.ofEpochMilli((meetupRSVP.getEvent() != null) ? meetupRSVP.getEvent().getTime() : 0));
        rsvp.setGroupName((meetupRSVP.getGroup() != null) ? meetupRSVP.getGroup().getGroupName() : "");
        rsvp.setGroupCountry((meetupRSVP.getGroup() != null) ? meetupRSVP.getGroup().getGroupCountry() : "");
        rsvp.setGroupCity((meetupRSVP.getGroup() != null) ? meetupRSVP.getGroup().getGroupCity() : "");
        rsvp.setTopics("");
        rsvp.setVenue((meetupRSVP.getVenue() != null) ? meetupRSVP.getVenue().getVenueName() : "");
        rsvp.setEventUrl((meetupRSVP.getEvent() != null) ? meetupRSVP.getEvent().getEventUrl() : "");
        return rsvp;
    }

}

@Data
class MeetupEvent {
    @JsonProperty("event_id") private String evenId;
    @JsonProperty("event_name") private String eventName;
    @JsonProperty("event_url") private String eventUrl;
    private Long time;
}

@Data
class MeetupGroup {
    @JsonProperty("group_city") private String groupCity;
    @JsonProperty("group_country") private String groupCountry;
    @JsonProperty("group_id") private Long groupId;
    @JsonProperty("group_lat") private double groupLat;
    @JsonProperty("group_lon") private double groupLon;
    @JsonProperty("group_name") private String groupName;
    @JsonProperty("group_topics") private List<MeetupTopic> groupTopics;
    @JsonProperty("group_urlname") private String groupUrlName;
}

@Data
class MeetupTopic {
    @JsonProperty("topic_name") private String topicName;
    @JsonProperty("urlkey") private String urlKey;
}

@Data
class MeetupMember {
    @JsonProperty("member_id") private Long memberId;
    @JsonProperty("member_name") private String memberName;
    @JsonProperty("photo") private String photo;
}

@Data
class MeetupVenue {
    private String lat;
    private String lon;
    @JsonProperty("venue_id") private Long venueId;
    @JsonProperty("venue_name") private String venueName;
}
