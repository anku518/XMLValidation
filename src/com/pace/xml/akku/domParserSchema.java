package com.pace.xml.akku;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class domParserSchema {

	public static void main(String[] args) {
		boolean flag = true;
		try {
			validate("books.xml","books.xsd");
		} catch (SAXException e) {
		
			flag = false;
			
			  System.err.println("The file is invalid! Reason:");
			  System.err.println(e.getMessage());
			 

	} catch (IOException e) {
		
		flag = false;
		
		  System.err.println("The file is invalid! Reason:");
		  System.err.println(e.getMessage());
		 
	}

		System.out.println("XML Schema file is valid :" + flag);
	}
	private static void validate(String xmlFile, String validationFile) throws SAXException, IOException {
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		((factory.newSchema(new File(validationFile))).newValidator()).validate( new StreamSource(new File(xmlFile)));
        
		
	}


}
