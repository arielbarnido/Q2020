package com.delivery.app.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaceOrderDto {

	@Size(min=2, max=2, message="Origin coordinates must be exactly two items.")
	private String[] origin;
	
	@Size(min=2, max=2, message="Destination coordinates must be exactly two items.")
	private String[] destination;
	public String[] getOrigin() {
		return origin;
	}
	public void setOrigin(String[] origin) {
		this.origin = origin;
	}
	public String[] getDestination() {
		return destination;
	}
	public void setDestination(String[] destination) {
		this.destination = destination;
	}
	
}
