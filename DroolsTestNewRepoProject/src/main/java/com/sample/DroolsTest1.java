package com.sample;

import org.kie.api.conf.Option;
import org.kie.api.KieBase;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	

	Options xjcOpts = new Options();
	xjcOpts.setSchemaLanguage(Language.XMLSCHEMA);
	JaxbConfiguration jaxbConfiguration =
	KnowledgeBuilderFactory.newJaxbConfiguration( xjcOpts, "xsd" );
	kbuilder.add(ResourceFactory.newClassPathResource("person.xsd",
	getClass()), ResourceType.XSD, jaxbConfiguration);
	KieBase kbase = kbuilder.newKnowledgeBase();
	List<String> classesName = new ArrayList<String>();
	classesName.add("org.drools.compiler.test.Person");
	JAXBContext jaxbContext =
	KnowledgeBuilderHelper.newJAXBContext(classesName.toArray(new
	String[classesName.size()]), kbase);


}
