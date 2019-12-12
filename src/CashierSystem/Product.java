package CashierSystem;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Product  {
	
	 
	 public int productID;
	 public String productName;
	 public double productWeight;
	 public double productPrice;
	 public int productAmount;
	 public boolean productNeedToBeWeighed;
	 public ProductType productType = ProductType.OVRIGT;//public static enum ProductType
	 public int amountYouWantToBuy = 0;
	 //swt gui classes
	 public int putToStorage;
	 public String universalCompositeBox;
	 public Composite productComposite;
	 public Label lblFoodPrice;
	 public Label lblFoodName;
	 public Label lblFoodAmount;
	 public Button plusButton;
	 public Button minusButton;
	 public Button removeButton;
	 public Label lblFoodID;
	 public Label lblFoodCategory;
	 public Text text;
	 public Image removeTrashCan;
	 
	 public Product()
	 {

	 }
	 
	 public Product(String pName, double pPrice)
	 {
		 productName = pName;
		 productPrice = pPrice;
	 }
	 
	 public Product(int pID, String pName, double pWeight, double pPrice, int pAmount, boolean pntbw, ProductType pType, String compositeBox)
	 {
		 
		 productID = pID;
		 productName = pName;
		 productWeight = pWeight;
		 productPrice = pPrice;
		 productAmount = pAmount;
		 productNeedToBeWeighed = pntbw;
		 productType = pType;
		 
		 
		 if(compositeBox == "cart")
		 {
			 createGuiForCart(String.valueOf(productPrice), productName,  String.valueOf(productAmount), String.valueOf(productID), pType.toString());
		 }
		 else if(compositeBox == "storage")
		 {
			 createGuiForStorage(String.valueOf(productPrice), productName,  String.valueOf(productAmount), String.valueOf(productID), pType.toString());
		 }
		 
		 
	 }
	 
	 public enum ProductType
	 {
		 KOTT_FAGEL_FISK,
		 MEJERI_OST_AGG,
		 FRUKT_GRONT,
		 BROD_KAKOR,
		 FRYST,
		 SKAFFERI,
		 DRYCK,
		 GODIS_SNACKS,
		 HALSA_SKONHET,
		 OVRIGT,
	 }
	 
	 public void resetProductGUI()
	 {
		 productComposite = null;
		 lblFoodPrice = null;
	     lblFoodName = null;
		 lblFoodAmount = null;
		 plusButton = null;
		 minusButton = null;
		 removeButton = null;
		 lblFoodID = null;
		 lblFoodCategory = null;
		 text = null;
		 removeTrashCan = null;
		productAmount -= amountYouWantToBuy;
	 }
	
	 public void createGuiForCart(String foodPrice, String foodName, String foodAmount, String foodID, String foodCategory)
	 {
		 	productComposite = new Composite(LogInside.cmpInnerScroll, SWT.NONE);
		 	productComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		    productComposite.setLayoutData(new RowData(268, 83));
			
		    
			lblFoodPrice = new Label(productComposite, SWT.NONE);
			lblFoodPrice.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodPrice.setLocation(10, 31);
			lblFoodPrice.setSize(104, 21);
			
			lblFoodPrice.setText(foodPrice + " sek/st");
			
			lblFoodPrice.setAlignment(SWT.CENTER);
			
			lblFoodName = new Label(productComposite, SWT.NONE);
			lblFoodName.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodName.setBounds(10, 10, 104, 21);
			lblFoodName.setText(foodName);
			lblFoodName.setAlignment(SWT.CENTER);
			
			lblFoodAmount = new Label(productComposite, SWT.NONE);
			
			lblFoodAmount.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodAmount.setBounds(10, 52, 104, 21);
			lblFoodAmount.setText("Storage: " + foodAmount);
			lblFoodAmount.setAlignment(SWT.CENTER);
			
			removeButton = new Button(productComposite, SWT.NONE);
			removeButton.setBounds(228, 53, 30, 25);
			removeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					removeButtonUsage();
				}
			});
//			Image img1 = new Image(display, "./resources/ trash.png");
//			button.setImage(img1);
			
			plusButton = new Button(productComposite, SWT.NONE);
			plusButton.setText("+");
			plusButton.setBounds(192, 53, 30, 25);
			
			plusButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(productAmount > 0)
					{
						plusButtonUsage();
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Slut p� produkten");
					}
					
				}
			});
			
			
			minusButton = new Button(productComposite, SWT.NONE);
			minusButton.setText("-");
			//button_2.
			minusButton.setBounds(156, 53, 30, 25);
			minusButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					if(amountYouWantToBuy > 0)
					{
						minusButtonUsage();
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Vill du ta bort varan?");
					}
					
				
				}
			});

			
			text = new Text(productComposite, SWT.BORDER);
			text.setBounds(120, 55, 30, 21);
			text.setText(String.valueOf(amountYouWantToBuy));
			
			
			lblFoodID = new Label(productComposite, SWT.NONE);
			lblFoodID.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 8, SWT.NORMAL));
			lblFoodID.setBounds(120, 10, 138, 21);
			lblFoodID.setText("ProductID: " + foodID);	
			lblFoodID.setAlignment(SWT.CENTER);
			lblFoodCategory = new Label(productComposite, SWT.NONE);
			lblFoodCategory.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 8, SWT.NORMAL));
			lblFoodCategory.setBounds(120, 31, 138, 21);
			lblFoodCategory.setText(foodCategory);
			lblFoodCategory.setAlignment(SWT.CENTER);
			
			
			LogInside.cmpInnerScroll.setSize(LogInside.cmpInnerScroll.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			LogInside.cmpInnerScroll.layout();
			LogInside.compositeStatic.setMinSize(LogInside.cmpInnerScroll.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			LogInside.compositeStatic.layout();
			productComposite.layout();		
	 }
	 
	 public void createGuiForStorage(String foodPrice, String foodName, String foodAmount, String foodId, String foodCategory)
	 {
		 	productComposite = new Composite(LogInside.compInnerCart, SWT.NONE);
		 	productComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		    productComposite.setLayoutData(new RowData(268, 83));
			
		    
			lblFoodPrice = new Label(productComposite, SWT.NONE);
			lblFoodPrice.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodPrice.setLocation(10, 31);
			lblFoodPrice.setSize(104, 21);
			lblFoodPrice.setText(foodPrice + " sek/st");
			lblFoodPrice.setAlignment(SWT.CENTER);
			
			lblFoodName = new Label(productComposite, SWT.NONE);
			lblFoodName.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodName.setBounds(10, 10, 104, 21);
			lblFoodName.setText(foodName);
			lblFoodName.setAlignment(SWT.CENTER);
			
			lblFoodAmount = new Label(productComposite, SWT.NONE);
			lblFoodAmount.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 10, SWT.NORMAL));
			lblFoodAmount.setBounds(10, 52, 104, 21);
			lblFoodAmount.setText("Storage: " + foodAmount);
			lblFoodAmount.setAlignment(SWT.CENTER);
			
			removeButton = new Button(productComposite, SWT.NONE);
			removeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					removeButtonUsage();
					
				}
			});
			removeButton.setBounds(228, 53, 30, 25);
//			Image img1 = new Image(display, "./resources/ trash.png");
//			button.setImage(img1);
			
			plusButton = new Button(productComposite, SWT.NONE);
			plusButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					productAmount++;
					text.setText(String.valueOf(productAmount));
					Storage.productsInStorage.get((productID+1)).productAmount--;
					lblFoodAmount.setText("Storage: " + String.valueOf(Storage.productsInStorage.get((productID+1)).productAmount));
				}
			});
			
			
			plusButton.setText("+");
			plusButton.setBounds(192, 53, 30, 25);
			
			minusButton = new Button(productComposite, SWT.NONE);
			minusButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					productAmount--;
					text.setText(String.valueOf(productAmount));
					Storage.productsInStorage.get((productID+1)).productAmount++;
					lblFoodAmount.setText("Storage: " + String.valueOf(Storage.productsInStorage.get((productID+1)).productAmount));
				}
			});
			minusButton.setText("-");
			//button_2.
			minusButton.setBounds(156, 53, 30, 25);
			
			text = new Text(productComposite, SWT.BORDER);
			text.setBounds(120, 55, 30, 21);
			text.setTextLimit(productAmount);
			text.setText(String.valueOf(amountYouWantToBuy));
//			text.add
			
			lblFoodID = new Label(productComposite, SWT.NONE);
			lblFoodID.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 8, SWT.NORMAL));
			lblFoodID.setBounds(120, 10, 138, 21);
			lblFoodID.setText("ProductID: " + foodId);	
			lblFoodID.setAlignment(SWT.CENTER);
			lblFoodCategory = new Label(productComposite, SWT.NONE);
			lblFoodCategory.setFont(SWTResourceManager.getFont("Arial Rounded MT Bold", 8, SWT.NORMAL));
			lblFoodCategory.setBounds(120, 31, 138, 21);
			lblFoodCategory.setText(foodCategory);
			lblFoodCategory.setAlignment(SWT.CENTER);
			
			
			LogInside.compInnerCart.setSize(LogInside.compInnerCart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			LogInside.compInnerCart.layout();
			LogInside.scrolledCart.setMinSize(LogInside.compInnerCart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
			LogInside.scrolledCart.layout();
			productComposite.layout();
	 }
	 
	 public void plusButtonUsage()
	 {
			productAmount--;
			amountYouWantToBuy++;
			text.setText(String.valueOf(amountYouWantToBuy));
			lblFoodAmount.setText("Storage: " + String.valueOf(productAmount));
			System.out.println("buy " + String.valueOf(amountYouWantToBuy) + " " + productName + " and now there is " + String.valueOf(productAmount));
	 }
	 
	 public void minusButtonUsage()
	 {
		 	productAmount++;
		 	amountYouWantToBuy--;
			text.setText(String.valueOf(amountYouWantToBuy));
			lblFoodAmount.setText("Storage: " + String.valueOf(productAmount));
			System.out.println("buy " + String.valueOf(amountYouWantToBuy) + " " + productName + " and now there is " + String.valueOf(productAmount));
	 }
	 
	 public void removeButtonUsage()
	 {
		 productAmount += amountYouWantToBuy; 
		 productComposite.dispose();
		 
		 
		 LogInside.compInnerCart.setSize(LogInside.compInnerCart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		 LogInside.compInnerCart.layout();
		 LogInside.scrolledCart.setMinSize(LogInside.compInnerCart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		 LogInside.scrolledCart.layout();
	 }
	 
}