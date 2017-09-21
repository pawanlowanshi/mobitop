package com.omniwyse.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {
    public static Map<String, Map<String, String>> xmlAttrDetails = new HashMap<String, Map<String, String>>();

    public static void main(String[] args) throws Exception {
	new XmlReader().getXmlElement();
    }

    public String getXmlElement() {
	try {
	    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document doc = dBuilder.parse(new File("C:\\Users\\pawanl\\Downloads\\99acres.xml"));
	    // doc.getDocumentElement().normalize();
	    System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getElementsByTagName("*");
	    System.out.println("----------------------------");
	    for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		Element element = (Element) nNode;
		listAllAttributes(element);
		System.out.println("\nCurrent Element : " + nNode.getNodeName());
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		    if (nNode instanceof Element) {
			System.out.println("this is my bounds parameter value::: " + (element).getAttribute("bounds"));
			System.out.println("this is my class parameter value::: " + (element).getAttribute("class"));
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static void listAllAttributes(Element element) {
	System.out.println();
	System.out.println("List attributes for node: " + element.getNodeName());
	// get a map containing the attributes of this node
	NamedNodeMap attributes = element.getAttributes();
	// get the number of nodes in this map
	int numAttrs = attributes.getLength();
	for (int i = 0; i < numAttrs; i++) {
	    Attr attr = (Attr) attributes.item(i);
	    String attrName = attr.getNodeName();
	    String attrValue = attr.getNodeValue();
	    System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
	}
    }
}
