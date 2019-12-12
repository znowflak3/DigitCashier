package CashierSystem;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

//import direkt.Login;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Point;

public class LogInside {
	protected Shell shlCashierSystem;
	private Text text;
	
	public ArrayList<Employee> employeeList = new ArrayList<Employee>();
//	public static ArrayList<Product> productsInCart = new ArrayList<Product>();
	public DigitCashier digitCashier;
	public static ScrolledComposite compositeStatic;
	public static Composite cmpInnerScroll;
	
	public static ScrolledComposite scrolledCart;
	public static Composite compInnerCart;
	
	public Employee loggedUser;
	
	private Label loggedUserID;
	private Label loggedUsername;
	
	private Button btnLogIn;
	private Text textField;
	
	//swt gui classes
		 public Composite productComposite;
		 public Label lblFoodPrice;
		 public Label lblFoodName;
		 public Label lblFoodAmount;
		 public Button plusButton;
		 public Button minusButton;
		 public Button removeButton;
		 public Label lblFoodID;
		 public Label lblFoodCategory;
		 public Text textAmount;
		 
	/**
	 * Launch the application.
	 * @param args
	 */
	Display display;
	private Button button;
	
	public String cashOrCard;
	private Label lblNewLabel;
	private Button btnNewButton;
	public LogInside()
	{
		Employee cashJohanna = new Employee(275, "Johanna", "Chen", "8201174045", "DalboGatan 16", "Borås", 50438);
		Employee cashJoakim = new Employee(375, "Joakim", "Znöflinga", "9102072932", "Dalbogatan 16", "Borås", 50438);
		employeeList.add(cashJohanna);
		employeeList.add(cashJoakim);
	}
	public static void main(String[] args) {
		
				try {
					TimeClass tc = new TimeClass();
					LogInside window = new LogInside();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlCashierSystem.open();
		shlCashierSystem.layout();
		while (!shlCashierSystem.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCashierSystem = new Shell();
		shlCashierSystem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		shlCashierSystem.setSize(900, 540);
		shlCashierSystem.setText("Cashier System");
		shlCashierSystem.setLayout(new FormLayout());
		
		btnNewButton = new Button(shlCashierSystem, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(cashOrCard == "CASH")
				{
					
					digitCashier.calculateChange();
				}
				else if(cashOrCard == "CARD")
				{
					digitCashier.payWithCard();
					JOptionPane.showMessageDialog(null, "Payment Recieved");
				}
				else{
					JOptionPane.showMessageDialog(null, "You need to choose payment method");
				}
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -13);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Pay");
		//Image img = new Image(null, "./resources/ trash.png");
		lblNewLabel = new Label(shlCashierSystem, SWT.NONE);
		fd_btnNewButton.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(0, 53);
		fd_lblNewLabel.top = new FormAttachment(0, 10);
		fd_lblNewLabel.left = new FormAttachment(0, 10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setFont(SWTResourceManager.getFont("Sakkal Majalla", 30, SWT.BOLD));
		lblNewLabel.setText("Cashier System");
		
		Menu menu = new Menu(shlCashierSystem, SWT.BAR);
		shlCashierSystem.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("New SubMenu");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmCashier = new MenuItem(menu_1, SWT.NONE);
		mntmCashier.setText("Cashier");
		
		textField = new Text(shlCashierSystem, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.bottom = new FormAttachment(0, 98);
		fd_text.right = new FormAttachment(0, 210);
		fd_text.top = new FormAttachment(0, 62);
		fd_text.left = new FormAttachment(0, 10);
		textField.setLayoutData(fd_text);
		//vreate gui for cart
		
		
		//decide button name wisch decides button functionality
		textFieldInput("Log In");
		createScrolledBar();
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(lblNewLabel, 0, SWT.TOP);
		fd_composite.right = new FormAttachment(lblNewLabel, 304, SWT.RIGHT);
		fd_composite.left = new FormAttachment(lblNewLabel, 6);
		compositeStatic.setLayoutData(fd_composite);
		//Create GUi for cart
//		createGuiForCart();
//		Storage.productsInStorage.get(1).createGuiForCart();
		//
		//profile label
		Composite compositeLoggedUser = new Composite(shlCashierSystem, SWT.NONE);
		fd_btnNewButton.top = new FormAttachment(compositeLoggedUser, 0, SWT.TOP);
		fd_btnNewButton.left = new FormAttachment(compositeLoggedUser, 6);
		fd_composite.bottom = new FormAttachment(compositeLoggedUser, 0, SWT.BOTTOM);
		FormData fd_compositeLoggedUser = new FormData();
		fd_compositeLoggedUser.bottom = new FormAttachment(100, -10);
		fd_compositeLoggedUser.left = new FormAttachment(0, 10);
		fd_compositeLoggedUser.top = new FormAttachment(100, -68);
		fd_compositeLoggedUser.right = new FormAttachment(0, 154);
		compositeLoggedUser.setLayoutData(fd_compositeLoggedUser);
		
		loggedUsername = new Label(compositeLoggedUser, SWT.NONE);
		loggedUsername.setBounds(10, 10, 55, 15);
		loggedUsername.setText("Log In");
		
		loggedUserID = new Label(compositeLoggedUser, SWT.NONE);
		loggedUserID.setBounds(10, 31, 55, 15);
		loggedUserID.setText("Please");
		
		Button btnRadioButton = new Button(shlCashierSystem, SWT.RADIO);
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cashOrCard = "CARD";
			}
		});
		FormData fd_btnRadioButton = new FormData();
		fd_btnRadioButton.bottom = new FormAttachment(btnNewButton, -8);
		fd_btnRadioButton.left = new FormAttachment(btnNewButton, 0, SWT.LEFT);
		btnRadioButton.setLayoutData(fd_btnRadioButton);
		btnRadioButton.setText("Card");
		
		Button btnRadioButton_1 = new Button(shlCashierSystem, SWT.RADIO);
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cashOrCard = "CASH";
			}
		});
		FormData fd_btnRadioButton_1 = new FormData();
		fd_btnRadioButton_1.right = new FormAttachment(btnRadioButton, 0, SWT.RIGHT);
		fd_btnRadioButton_1.bottom = new FormAttachment(btnRadioButton, -6);
		fd_btnRadioButton_1.left = new FormAttachment(btnNewButton, 0, SWT.LEFT);
		btnRadioButton_1.setLayoutData(fd_btnRadioButton_1);
		btnRadioButton_1.setText("Cash");
		/////
		//Label lblClock = new Label(shlCashierSystem, SWT.NONE);
		
		
		
		
		////////
		FormData fd_lblThisIsSupposed = new FormData();
		fd_lblThisIsSupposed.top = new FormAttachment(btnRadioButton_1, -135, SWT.TOP);
		fd_lblThisIsSupposed.bottom = new FormAttachment(btnRadioButton_1, -78);
		fd_lblThisIsSupposed.left = new FormAttachment(0, 10);
		fd_lblThisIsSupposed.right = new FormAttachment(0, 168);
//		lblThisIsSupposed.setLayoutData(fd_lblThisIsSupposed);
//		/lblThisIsSupposed.setText("this is supposed to be digital digit clock.. imagine ");
		
		//loginbutton
		btnLogIn.addSelectionListener(new SelectionListener()
		{
			public void widgetSelected(SelectionEvent event)
			{
			//	string 
			//	text.getText();
				//if(text.getText() == tempEmployee)
//				JOptionPane.showMessageDialog(null, textField.getText());
				if(textField.getText().matches("#2#") == true)
				{ 	
					// change t variable thats show totalsum
					JOptionPane.showMessageDialog(null, "Shows total sum");
				}
				else if(btnLogIn.getText() == "Log In")
				{
				for(int i = 0; i < employeeList.size(); i++)
				{
//					JOptionPane.showMessageDialog(null, Integer.toString(employeeList.get(i).employeeID));
					//if(employeeList[i].employeeID == text.getText().)
					//{}
					if(textField.getText().isEmpty())
						break;
						
					if(Integer.parseInt(textField.getText()) == employeeList.get(i).employeeID)
					{
//						JOptionPane.showMessageDialog(null, "FIRE");
						profileLabel(employeeList.get(i));
						int firstIntInID = firstDigit(employeeList.get(i).employeeID);
						if(firstIntInID == 2)
						{
//							JOptionPane.showMessageDialog(null, firstIntInID);
							btnLogIn.setText("Search?");
							
						}
						else if(firstIntInID == 3)
						{
							new ChangeProduct().open(Storage.productsInStorage.get(1));
							JOptionPane.showMessageDialog(null, "3" + firstIntInID);
						}
						else if(firstIntInID == 5)
						{
							JOptionPane.showMessageDialog(null, "5" +  firstIntInID);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You have to type your own damm fuckin code");
						}
					}
					
				}
				}
				else if(btnLogIn.getText() == "Search?")
				{
					digitCashier.scanProductID(textField.getText());
//					productsInCart.get(0).createGuiForCart();¨
//					JOptionPane.showMessageDialog(null, "size =" + Storage.productsInStorage.size());
//					createGuiForCart();		
					}
				
				textField.setText("");
				

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		
		digitCashier = new DigitCashier();
	}
	private void profileLabel(Employee emp)
	{
		loggedUserID.setBounds(10, 31, 55, 15);
		loggedUserID.setText(Integer.toString(emp.employeeID));
		
		loggedUsername.setBounds(10, 10, 55, 15);
		loggedUsername.setText(emp.firstName + " " + emp.surName);
		loggedUser = emp;
//		JOptionPane.showMessageDialog(null, loggedUser.firstName);
	}
	
	private void textFieldInput(String s)
	{		
		btnLogIn = new Button(shlCashierSystem, SWT.NONE);
		FormData fd_btnLogIn = new FormData();
		fd_btnLogIn.top = new FormAttachment(textField, 6);
		fd_btnLogIn.left = new FormAttachment(0, 10);
		btnLogIn.setLayoutData(fd_btnLogIn);
		btnLogIn.setText(s);
	}
	
	public int firstDigit(int num)
	{
		int sum = num/100;
		
		return sum;
	}
	
	public void createScrolledBar()
	{
		FormData fd_scrolledCart = new FormData();
		fd_scrolledCart.left = new FormAttachment(lblNewLabel, 373);
		fd_scrolledCart.right = new FormAttachment(100, -10);
		fd_scrolledCart.bottom = new FormAttachment(btnNewButton, 0, SWT.BOTTOM);
		fd_scrolledCart.top = new FormAttachment(0, 10);
		
		
		scrolledCart = new ScrolledComposite(shlCashierSystem, SWT.BORDER | SWT.V_SCROLL);
		scrolledCart.setLayoutData(fd_scrolledCart);
		compInnerCart = new Composite(scrolledCart, SWT.NONE);
		compInnerCart.setLayout(new RowLayout(SWT.VERTICAL));
		scrolledCart.setContent(compInnerCart);
		scrolledCart.setExpandVertical(true);
		scrolledCart.setAlwaysShowScrollBars(true);
		scrolledCart.setMinSize(new Point(6, 6));
		
		compositeStatic = new ScrolledComposite(shlCashierSystem, SWT.BORDER | SWT.V_SCROLL);
		cmpInnerScroll = new Composite(compositeStatic, SWT.NONE);
		cmpInnerScroll.setLayout(new RowLayout(SWT.VERTICAL));
		compositeStatic.setContent(cmpInnerScroll);
		compositeStatic.setMinSize(cmpInnerScroll.computeSize(SWT.DEFAULT, SWT.DEFAULT, true));
		compositeStatic.setExpandVertical(true);
		compositeStatic.setAlwaysShowScrollBars(true);
		
		
		
	}
}
