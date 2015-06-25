package com.sample;

import java.io.Serializable;


public class DisplayRequest implements Serializable{

    
	private static final long serialVersionUID = 4768652654863009327L;
	
    private TravelportPSSDocumentDisplayRQType travelportPSSDocumentDisplayRQType;
   
	public TravelportPSSDocumentDisplayRQType getTravelportPSSDocumentDisplayRQType() {
		return travelportPSSDocumentDisplayRQType;
	}

	public void setTravelportPSSDocumentDisplayRQType(
			TravelportPSSDocumentDisplayRQType travelportPSSDocumentDisplayRQType) {
		this.travelportPSSDocumentDisplayRQType = travelportPSSDocumentDisplayRQType;
	}

}
