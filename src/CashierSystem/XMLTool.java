package CashierSystem;

import org.xml.sax.*;

import com.ibm.icu.impl.SimpleFilteredSentenceBreakIterator.Builder;

import CashierSystem.Product.ProductType;

import org.w3c.dom.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.spi.XmlWriter;
import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLTool {

	public Document xmlDoc;
	public ArrayList<String> storageProductId = new ArrayList<String>();
	public ArrayList<String> storageProductName = new ArrayList<String>();
	public ArrayList<String> storageProductWeight = new ArrayList<String>();
	public ArrayList<String> storageProductPrice = new ArrayList<String>();
	public ArrayList<String> storageProductAmount = new ArrayList<String>();
	public ArrayList<String> storageProductNeedToBeWeighed = new ArrayList<String>();
	public ArrayList<String> storageProductType = new ArrayList<String>();
	public ProductType pType;
	
	public XMLTool() {
		CreateXMLDoc();
		FindNode();
//		WriteNode("ProductName", 1, "testa ryggbiff");
//		updateDocument();
		
		
	}
	
	public void WriteNode(String tagname, int id, String newTextContent)
	{
//		Node node = new Node();
//		node.setTextContent("heeej");
		xmlDoc.getElementsByTagName(tagname).item(id).getFirstChild().setTextContent(newTextContent);
		System.out.println(xmlDoc.getElementsByTagName(tagname).item(id).getFirstChild().getTextContent());
		
//		xmlDoc.getElementsByTagName(tagname).item(0).getFirstChild().getNodeName().toString();
	}
	public void FindNode()
	{
		NodeList nodeList;
		String conditionText;
		nodeList = xmlDoc.getElementsByTagName("ProductId");
		for (int i = 0; i < nodeList.getLength(); i++)
		{		    
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductId.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		}
		nodeList = xmlDoc.getElementsByTagName("ProductName");
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductName.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		    
		}
		nodeList = xmlDoc.getElementsByTagName("ProductWeight");
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductWeight.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		    
		}
		nodeList = xmlDoc.getElementsByTagName("ProductPrice");
		for (int i = 0; i < nodeList.getLength(); i++)
		{
		    
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductPrice.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		}
		
		nodeList = xmlDoc.getElementsByTagName("ProductAmount");
		for (int i = 0; i < nodeList.getLength(); i++)
		{
		    
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductAmount.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		}
		nodeList = xmlDoc.getElementsByTagName("ProductNeedToBeWeighed");
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1)); 
		    storageProductNeedToBeWeighed.add(conditionText);
//		    JOptionPane.showMessageDialog(null, conditionText);
		}

		//add to storage
		
		nodeList = xmlDoc.getElementsByTagName("ProductType");
		for (int i = 0; i < nodeList.getLength(); i++)
		{	
			conditionText = nodeList.item(i).getFirstChild().toString();
			conditionText = nodeList.item(i).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		    storageProductType.add(conditionText);
		    
		    switch(conditionText){
		    case "KOTT_FAGEL_FISK":{
		    	pType = ProductType.KOTT_FAGEL_FISK;
		    	break;
		    }
		    case "MEJERI_OST_AGG":{
		    	pType = ProductType.MEJERI_OST_AGG;
		    	break;
		    }
		    case "FRUKT_OCH_GRONT":{
		    	pType = ProductType.FRUKT_GRONT;
		    	break;
		    }
		    case "BROD_KAKOR":{
		    	pType = ProductType.BROD_KAKOR;
		    	break;
		    }
		    case "FRYST":{
		    	pType = ProductType.FRYST;
		    	break;
		    }
		    case "SKAFFERI":{
		    	pType = ProductType.SKAFFERI;
		    	break;
		    }
		    case "DRYCK":{
		    	pType = ProductType.DRYCK;
		    	break;
		    }
		    case "GODIS_SNACKS":{
		    	pType = ProductType.GODIS_SNACKS;
		    	break;
		    }
		    case "HALSA_SKONHET":{
		    	pType = ProductType.HALSA_SKONHET;
		    	break;
		    }
		    case "OVRIGT":{
		    	pType = ProductType.OVRIGT;
		    	break;
		    }
		    }
			boolean isTrueOrNot;
			if(storageProductNeedToBeWeighed.get(i).matches("true"))
			{
				isTrueOrNot = true;
			}
			else
			{ 
				isTrueOrNot = false;
			}
			
//			DigitCashier.storage.productsInStorage.
			Storage.productsInStorage.add(new Product(
		    				Integer.parseInt(storageProductId.get(i).toString()), 
		    				storageProductName.get(i).toString(),
		    			    Double.parseDouble(storageProductWeight.get(i).toString()),
		    				Double.parseDouble(storageProductPrice.get(i).toString()),
		    				Integer.parseInt(storageProductAmount.get(i).toString()),
		    				isTrueOrNot,
		    				pType,
		    				"storage"));
			
//			JOptionPane.showMessageDialog(null, Storage.productsInStorage.get(i).productName);
			try
			{
			
			String prodInfo="";
			
			prodInfo ="productID: " + storageProductId.get(i).toString() +
					"productName: " + storageProductName.get(i).toString() +
    			    "productWeight: " + storageProductWeight.get(i).toString() +
    				"productPrice: " + storageProductPrice.get(i).toString() +
    				"productAmount: " + storageProductAmount.get(i).toString()+
    				"productNeedToBeWeighed: " + storageProductNeedToBeWeighed.get(i).toString();
		
//			JOptionPane.showMessageDialog(null, prodInfo);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "testing");
			}
			
		}		
		
	}
	
	public void CreateXMLDoc()
	{
		xmlDoc = getDocument("./src/CashierSystem/ProductList.xml");
	}

	private Document getDocument(String docString) {
		// TODO Auto-generated method stub
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			//factory.setValidating(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			return builder.parse(new InputSource(docString));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
	
	public void updateDocument()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File("./src/CashierSystem/output.xml");
		file.setWritable(true);
		try {
			file.createNewFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter fileWriter = null;
		file.setWritable(true);
		try {
			fileWriter = new FileWriter(file, file.createNewFile());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StreamResult output = new StreamResult(fileWriter);
		
		DOMSource input = new DOMSource(xmlDoc);
		
		Transformer transformer;
		
		try {
			TransformerFactory transformerfactory = TransformerFactory.newInstance();
			
			transformer = transformerfactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.transform(input, output);
			
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getVerificationNumber()
	{
		NodeList nodeList;
		String conditionText;
		nodeList = xmlDoc.getElementsByTagName("VerificationNumber");
		System.out.println(nodeList.item(0).getFirstChild().getTextContent());
		conditionText = nodeList.item(1).getFirstChild().toString();
		conditionText = nodeList.item(1).getFirstChild().toString().substring(8, (conditionText.length() - 1));
		int a;
		a = Integer.parseInt(conditionText);
		return a;
	}

	
}
