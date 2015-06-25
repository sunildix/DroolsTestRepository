
package com.sample;

import java.util.List;


/**
 * This message requests the display of an electronic miscellaneous document.
 * 
 * 
 */
 
public class TravelportPSSDocumentDisplayRQType
{
    protected List<PassengerType> passenger;

	/**
	 * @return the passenger
	 */
	public List<PassengerType> getPassenger() {
		return passenger;
	}

	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(List<PassengerType> passenger) {
		this.passenger = passenger;
	}

}
