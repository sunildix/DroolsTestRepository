package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;


/**
 * This is a sample class to launch a rule.
 */
public class Verify_maximum_number_of_documents_for_display_request {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
           
            
            TravelportPSSDocumentDisplayRQType travelportPSSDocumentDisplayRQType = new TravelportPSSDocumentDisplayRQType();
            
            List<TicketDocumentType> ticketDocumentTypeList = new ArrayList<TicketDocumentType>();
            List<PassengerType> passengerList = new ArrayList<PassengerType>();
            
            TicketDocumentType ticketDocumenttype =  new TicketDocumentType();
        	ticketDocumenttype.setTicketDocumentNbr("1001");
        	ticketDocumentTypeList.add(ticketDocumenttype);
            
        	TicketDocumentType ticketDocumenttype2 =  new TicketDocumentType();
         	ticketDocumenttype2.setTicketDocumentNbr("1002");
         	ticketDocumentTypeList.add(ticketDocumenttype2);
        	
            PassengerType passengerType = new PassengerType();
            passengerType.setPhoneNumber("959595995");
            passengerType.setTicketDocument(ticketDocumentTypeList);
            passengerList.add(passengerType);
            
            travelportPSSDocumentDisplayRQType.setPassenger(passengerList);
            
            
            DisplayRequest displayRequest = new DisplayRequest();
            displayRequest.setTravelportPSSDocumentDisplayRQType(travelportPSSDocumentDisplayRQType);
            
            ksession.insert(displayRequest);
         
            ksession.fireAllRules();
            
            //Display response from DRL
            
            TravelportPSSDocumentDisplayRSType travelportPSSDocumentDisplayRSType;
            
            DisplayResponse displayResponse =null;
            QueryResults results = ksession.getQueryResults( "getResponse" );
            for ( QueryResultsRow row : results ) {
            	displayResponse = ( DisplayResponse ) row.get( "displayResponse" );
            }
            travelportPSSDocumentDisplayRSType=displayResponse.getDisplayResponse();
            
            
            DocumentHelper docHelper=travelportPSSDocumentDisplayRSType.getDocumentHelper();
            
            DrlMessage drlMessage = docHelper.getError();
            if(drlMessage!=null)
            System.out.println(drlMessage.toString());
            
          

            ksession.dispose();//Once rules are fired, Stateful Knowledge Session object must call the method dispose() to release the session and avoid memory leaks.
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/21000_Verify maximum number of documents for display request.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    
}
