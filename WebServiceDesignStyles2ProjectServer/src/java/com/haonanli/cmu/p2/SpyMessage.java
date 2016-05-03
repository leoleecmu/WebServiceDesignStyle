/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haonanli.cmu.p2;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/**
 *
 * @author haonan
 */
public class SpyMessage {
    String xmlString;
    public SpyMessage(String xml){
        this.xmlString = xml;
    }
    /**
     * Get operation name and spy's information with input XML-style String
     * @param s
     * @return 
     */
    public String[] Parser(){
        String[] result=new String[5];
        Document spyDoc = getDocument(xmlString);
        spyDoc.getDocumentElement().normalize();
        
        NodeList nl0 = spyDoc.getElementsByTagName("operation");
        Node n0 = nl0.item(0);
        result[0]= n0.getTextContent();
        
        NodeList nl = spyDoc.getElementsByTagName("name");
        Node n = nl.item(0);
        result[1]= n.getTextContent();
        NodeList nl2 = spyDoc.getElementsByTagName("spyTitle");
        Node n2 = nl2.item(0);
        result[2]= n2.getTextContent();
        NodeList nl3 = spyDoc.getElementsByTagName("location");
        Node n3 = nl3.item(0);
        result[3]= n3.getTextContent();
        NodeList nl4 = spyDoc.getElementsByTagName("password");
        Node n4 = nl4.item(0);
        result[4]= n4.getTextContent();
        return result;
       	 
    }
    private static Document getDocument(String xmlString) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document spyDoc = null;
        try {
        builder = factory.newDocumentBuilder();
        spyDoc = (Document) builder.parse( new InputSource( new StringReader( xmlString ) ) );

        } catch (Exception e) {
        e.printStackTrace();
        }
        return spyDoc;
    }

}
