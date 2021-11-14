package com.pace.xml.akku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class domParserDTD {

	public static void main(String[] args) {
		boolean flag = true;
		try {
			validate("books_dtd.xml");
		} catch (ParserConfigurationException e) {

			flag = false;

		} catch (FileNotFoundException e) {

			flag = false;

		} catch (SAXException e) {

			flag = false;

		} catch (IOException e) {

			flag = false;

		}

		System.out.println("DTD xml file is valid :" + flag);
	}

	public static void validate(String xmlFile)
			throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new org.xml.sax.ErrorHandler() {

			public void error(SAXParseException exception) throws SAXException {
				System.out.println("ERROR : " + exception.getMessage());
				throw exception;
			}

			public void warning(SAXParseException exception) throws SAXException {
				System.out.println("WARNING : " + exception.getMessage());
				throw exception;
			}

			public void fatalError(SAXParseException exception) throws SAXException {
				System.out.println("FATAL : " + exception.getMessage());
				throw exception;
			}
		});
		builder.parse(new FileInputStream(xmlFile));
	}
}
