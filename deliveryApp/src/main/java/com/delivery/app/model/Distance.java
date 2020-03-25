package com.delivery.app.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"value",
"text"
})
public class Distance {

@JsonProperty("value")
private Long value;
@JsonProperty("text")
private String text;

@JsonProperty("value")
public Long getValue() {
return value;
}

@JsonProperty("value")
public void setValue(Long value) {
this.value = value;
}

@JsonProperty("text")
public String getText() {
return text;
}

@JsonProperty("text")
public void setText(String text) {
this.text = text;
}

}