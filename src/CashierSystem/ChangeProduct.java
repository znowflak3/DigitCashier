package CashierSystem;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class ChangeProduct {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Label lblProductname;
	private Label label;
	
	public Product product;
	public int ID;
	private Label lblProductID;
	private Text text_ID;
	private Text text_Name;
	
	public int vlInt = 0;

	public ArrayList<Integer> arrayID;
	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 */
	public void open(Product p) {
		Display display = Display.getDefault();
		createContents(p);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	public void createInteger()
	{
		arrayID = new ArrayList<Integer>();
		for(int i = 0; i < Storage.productsInStorage.size(); i++)
		{
			Integer integer = new Integer(i);
			arrayID.add(integer);
		}
	}
	protected void createContents(Product p) {
		createInteger();
		product = p;
		ID = p.productID;
		
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		text_Name = new Text(shell, SWT.BORDER);
		text_Name.setBounds(293, 40, 131, 27);
		
		
		text_ID = new Text(shell, SWT.BORDER);
		text_ID.setBounds(293, 10, 131, 27);
		text_ID.addKeyListener(new KeyListener() {


			public void keyPressed(KeyEvent event) {
				// TODO Auto-generated method stub
				switch (event.keyCode) {
				case SWT.OK:
					System.out.println(event.keyCode);
					break;

				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
			
			
		
		text_ID.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent ve) {
				// TODO Auto-generated method stub
				ve.doit = false;
				
				if(text_ID.getText().isEmpty())
					{
					
					}
				else
				{ID = Integer.parseInt(text_ID.getText());}
					
				
				System.out.print(ID);
				
				
				char myChar = ve.character;
				String tex = ((Text) ve.widget).getText();
				System.out.println(tex);
				
				
						
				if(myChar == '-' && tex.length() == 0)
						ve.doit= true;
				
				if(Character.isDigit(myChar))
					ve.doit = true;
				
				if(myChar == '\b')	
				{
					ID = Integer.parseInt(text_ID.getText());
					System.out.println(tex);
					ve.doit = true;
				}
				
				if(!text_ID.getText().isEmpty())
				{
				ID = Integer.parseInt(text_ID.getText());
				}	
					for(int i = 0; i < Storage.productsInStorage.size(); i++)
					{
						if(ID == Storage.productsInStorage.get(i).productID)
						{
							System.out.println("verify");
//							vlInt = 1;
							product = Storage.productsInStorage.get(i);
							text_Name.setText(product.productName);
							
						}
					}
				}
			
			}
		);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(293, 70, 131, 27);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(293, 100, 131, 27);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(293, 130, 131, 27);
		
		lblProductID = new Label(shell, SWT.NONE);
		lblProductID.setBounds(10, 10, 178, 24);
		lblProductID.setText("Product ID:");
		
		label = new Label(shell, SWT.NONE);
		label.setText("Product Name:");
		label.setBounds(10, 40, 178, 24);
		
		label = new Label(shell, SWT.NONE);
		label.setText("Product Price");
		label.setBounds(10, 70, 178, 24);
		
		label = new Label(shell, SWT.NONE);
		label.setText("Storage Amount:");
		label.setBounds(10, 100, 178, 24);
		
		label = new Label(shell, SWT.NONE);
		label.setText("ProductName");
		label.setBounds(10, 130, 178, 24);
		
		Button btnApply = new Button(shell, SWT.NONE);
		btnApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; i < Storage.productsInStorage.size(); i++)
				{
					
				}
			}
		});
		btnApply.setBounds(10, 227, 75, 25);
		btnApply.setText("Apply");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(349, 227, 75, 25);
		btnCancel.setText("Cancel");

	}
	
	
}
