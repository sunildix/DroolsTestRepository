
package com.sample;

import java.util.List;
 
public class PassengerType
{
    protected List<TicketDocumentType> ticketDocument;
    protected String phoneNumber;
	/**
	 * @return the ticketDocument
	 */
	public List<TicketDocumentType> getTicketDocument() {
		return ticketDocument;
	}
	/**
	 * @param ticketDocument the ticketDocument to set
	 */
	public void setTicketDocument(List<TicketDocumentType> ticketDocument) {
		this.ticketDocument = ticketDocument;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
