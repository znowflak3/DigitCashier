package CashierSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.transform.stream.StreamResult;

import CashierSystem.Product.ProductType;

public class Receipt {
	
	public LocalTime time;
	public LocalDate date;
	
	public Product[] products;
	public int totalPrice;
	public int verificationNumber = 1001;
	public double moms12 = 12;
	public double moms25 = 25;
	
	public File file;
	public FileWriter fw;
	
	public Receipt(Product[] productCart)
	{
		file = new File("newTxt.txt");
//		verificationNumber = DigitCashier.storage.xmlTool.getVerificationNumber();
//		
//		DigitCashier.storage.xmlTool.WriteNode("VerificationNumber", 1, "hej");
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String streck;
		streck = "------------------------------------------------------------------------------------------";
		String pwi;
		pwi ="			"+"KVITTO";
		pw.println(pwi);
		
		pw.println(streck);
		pw.println();
		
		pwi ="DalboGatan 16";
		pw.println(pwi);
		pwi ="SE 5043 38 Bor�s";
		pw.println(pwi);
		pwi ="Org nr: 5555-5555";
		pw.println(pwi);
		pwi ="Telefon: 0722051923                                         Kass�r: 275 Nr: "+ String.valueOf(verificationNumber);
		pw.println(pwi);
		pw.println();
		pw.println(streck);
		pw.println();
		moms12 = 0;
		moms25 = 0;
		for(int i = 0; i < productCart.length; i++)
		{	
			String pString;
			pw.println(productCart[i].productName + "			" +  productCart[i].productType.toString());
			pString = "Antal: ";
			pString += String.valueOf(productCart[i].amountYouWantToBuy);
			pString += "                    ";
			double a = productCart[i].productPrice * productCart[i].amountYouWantToBuy;
			pString += String.valueOf(a) + "kr";
			totalPrice += a;
			pw.println(pString);
			pw.println();
			
			if(productCart[i].productType == ProductType.OVRIGT || productCart[i].productType == ProductType.HALSA_SKONHET)
			{
				moms25 += totalPrice;
			}
			else{
				moms12 += totalPrice;
			}
			
		}
		pw.println();
		pw.println(streck);
		pw.println();
		
		pw.println("Total:				" + totalPrice + "kr");
//		pw.print(totalPrice + "kr");
//		pw.println();
		
		moms12 = moms12 * 0.12;
		moms25 = moms25 * 0.25;
		
		pw.print("Moms 12%:			" + moms12 + "kr");
		pw.println();
		pw.print("Moms 25%:			" + moms25 +  "kr");
		pw.println();
	
		pw.println();
		pw.println(streck);
		pw.println();
		
		
		
		time = LocalTime.now();
		pw.println("Tid:  "+ time);
		date = LocalDate.now();
		pw.println("Datum:  " +date);
		System.out.println("Datum:"+ date);
		
		pw.flush();
		pw.close();
		
		verificationNumber++;
	}

	
	private void getVerificationNumber()
	{
		
	}
	

}
