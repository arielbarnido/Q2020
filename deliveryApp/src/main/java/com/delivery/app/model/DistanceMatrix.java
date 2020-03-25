package com.delivery.app.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"origin_addresses",
"destination_addresses",
"rows"
})
public class DistanceMatrix {

@JsonProperty("status")
private String status;
@JsonProperty("origin_addresses")
private List<String> originAddresses = null;
@JsonProperty("destination_addresses")
private List<String> destinationAddresses = null;
@JsonProperty("rows")
private List<Row> rows = null;

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("origin_addresses")
public List<String> getOriginAddresses() {
return originAddresses;
}

@JsonProperty("origin_addresses")
public void setOriginAddresses(List<String> originAddresses) {
this.originAddresses = originAddresses;
}

@JsonProperty("destination_addresses")
public List<String> getDestinationAddresses() {
return destinationAddresses;
}

@JsonProperty("destination_addresses")
public void setDestinationAddresses(List<String> destinationAddresses) {
this.destinationAddresses = destinationAddresses;
}

@JsonProperty("rows")
public List<Row> getRows() {
return rows;
}

@JsonProperty("rows")
public void setRows(List<Row> rows) {
this.rows = rows;
}

}