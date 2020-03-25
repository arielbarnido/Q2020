package com.delivery.app.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"duration",
"distance"
})
public class Element {

@JsonProperty("status")
private String status;
@JsonProperty("duration")
private Duration duration;
@JsonProperty("distance")
private Distance distance;

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("duration")
public Duration getDuration() {
return duration;
}

@JsonProperty("duration")
public void setDuration(Duration duration) {
this.duration = duration;
}

@JsonProperty("distance")
public Distance getDistance() {
return distance;
}

@JsonProperty("distance")
public void setDistance(Distance distance) {
this.distance = distance;
}

}