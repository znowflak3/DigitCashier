package CashierSystem;

import java.util.*;
import javax.swing.*;

import org.eclipse.jface.action.Action;

public class DigitCashier {

	public static Storage storage = new Storage();
	public double totalSum;
	public Receipt receipt;
//	public String thisProduct;
//	public double productPrice;
//	public int amountOfProduct;
//	public double priceForWeight;
//	public double paymentRecived;
	
	public int cartID;
	public int cartAmount;
	public int storageID;
	public int storageAmount;
	public int prID;
	
	public static ArrayList<Product> productsInCart = new ArrayList<Product>();
	
	public DigitCashier()
	{}
	public void newSale()
	{
		//currentsale = new Sale();
	}
	public void setPriceManual() {}
	
	public void setPriceFromWeight()
	{
		
	}
	public void scanProductID(String pID)
	{
//		JOptionPane.showMessageDialog(null, "1");
		if(!pID.isEmpty())
		prID = Integer.parseInt(pID);
		
//		JOptionPane.showMessageDialog(null, "2");
		for(int i = 0; i < Storage.productsInStorage.size(); i++)
		{
//			JOptionPane.showMessageDialog(null, "3");
			if(prID == Storage.productsInStorage.get(i).productID)
			{
//				JOptionPane.showMessageDialog(null, "4");
				storageID = Storage.productsInStorage.get(i).productID;
				storageAmount = Storage.productsInStorage.get(storageID).productAmount;
//				JOptionPane.showMessageDialog(null, "4.5");
				break;
			}
//				JOptionPane.showMessageDialog(null, "5");
		}
		
//			JOptionPane.showMessageDialog(null, "8");
			
			Product proToCart = Storage.productsInStorage.get(storageID);
			
			
			boolean exists = false;
			for(int i = 0; i < productsInCart.size(); i++)
			{
				
				if(storageID == productsInCart.get(i).productID)
				{
					
						
						productsInCart.get(i).resetProductGUI();
//					    productsInCart.get(i).lblFoodAmount.setText(String.valueOf(productsInCart.get(i).productAmount));
						proToCart = productsInCart.get(i);
				     	productsInCart.get(i).createGuiForCart(String.valueOf(proToCart.productPrice), proToCart.productName,  String.valueOf(proToCart.productAmount), String.valueOf(proToCart.productID), proToCart.productType.toString());
				     	productsInCart.get(i).lblFoodAmount.setText("Storage: " + String.valueOf(productsInCart.get(i).productAmount));
				     	System.out.println(i);
					    exists = true;
				}
				
				
			}
			if(!exists)
			{
			productsInCart.add(proToCart);
			productsInCart.get(productsInCart.lastIndexOf(proToCart)).createGuiForCart(String.valueOf(proToCart.productPrice), proToCart.productName,  String.valueOf(proToCart.productAmount), String.valueOf(proToCart.productID), proToCart.productType.toString());
//			proToCart.createGuiForCart(String.valueOf(proToCart.productPrice), proToCart.productName,  String.valueOf(proToCart.productAmount), String.valueOf(proToCart.productID), proToCart.productType.toString());
			System.out.println(999);
			}
		}

		
	

	public int scannedProductAmountToBuy(int storageAmount)	
	{		
		String inputDialog;
		inputDialog = JOptionPane.showInputDialog("Decide amount:");
		int amountToBuy = Integer.parseInt(inputDialog);
		if (amountToBuy < storageAmount)
		{	
			int amountLeft = storageAmount - amountToBuy;
			return amountToBuy;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "not enough in storage");
		}
		return 0;
	}
	public static void finishShopping()
	{
		DigitCashier dc = new DigitCashier();
		Product[] p = new Product[productsInCart.size()];
		
		for(int i = 0; i < productsInCart.size(); i++)
		{
			storage.xmlTool.WriteNode("ProductName", productsInCart.get(i).productID, productsInCart.get(i).productName);
			storage.xmlTool.WriteNode("ProductAmount", productsInCart.get(i).productID, String.valueOf(productsInCart.get(i).productAmount));
			storage.xmlTool.updateDocument();
			p[i] = productsInCart.get(i);
//			p[i].pr
		}
		dc.receipt = new Receipt(p);
	}
	public void useCoupon(){}
	public void showProductInformationOnScreen(){}
	public void loginToSystem(int code){}// no code needed in demo
	public void calculateChange(){
		JOptionPane.showMessageDialog(null, String.valueOf(productsInCart.size()));
		for(int i = 0; i < productsInCart.size(); i++)
		{
			double cost;
			cost = productsInCart.get(i).amountYouWantToBuy * productsInCart.get(i).productPrice;
			totalSum += cost;
			System.out.println(productsInCart.get(i).productName);
			System.out.println(cost);
		}
		CashPayment cp = new CashPayment();
		cp.open(totalSum);
	}
	public void payWithCard(){
		JOptionPane.showMessageDialog(null, String.valueOf(productsInCart.size()));
		for(int i = 0; i < productsInCart.size(); i++)
		{
			double cost;
			cost = productsInCart.get(i).amountYouWantToBuy * productsInCart.get(i).productPrice;
			totalSum += cost;
			System.out.println(productsInCart.get(i).productName);
			System.out.println(cost);
		}
		finishShopping();
	}
	public void calculatePoints(double points){}
	public void switchfFrameState(){}

}