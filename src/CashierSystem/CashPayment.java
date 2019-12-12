package CashierSystem;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

import java.util.Scanner;

import javax.swing.JOptionPane;
public class CashPayment {
	
	Scanner scan = new Scanner(System.in);

	protected Shell shlCashPayment;
	private Text text;
	private Text text_1;
	private Label label;
	private Button btnCancel;

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			CashPayment window = new CashPayment();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Open the window.
	 */
	public void open(double amountToPay) {
		Display display = Display.getDefault();
		createContents(amountToPay);
		shlCashPayment.open();
		shlCashPayment.layout();
		while (!shlCashPayment.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(double amountToPay) {
		shlCashPayment = new Shell();
		shlCashPayment.setSize(233, 182);
		shlCashPayment.setText("Cash Payment");
		
		text = new Text(shlCashPayment, SWT.BORDER);
		text.setBounds(93, 10, 76, 21);
		text.setText(String.valueOf(amountToPay));
		
		
		text_1 = new Text(shlCashPayment, SWT.BORDER);
		text_1.setBounds(93, 37, 76, 21);
		
		Label lblTotal = new Label(shlCashPayment, SWT.NONE);
		lblTotal.setBounds(32, 16, 55, 15);
		lblTotal.setText("Total:");
		
		Label lblRecieved = new Label(shlCashPayment, SWT.NONE);
		lblRecieved.setBounds(32, 37, 55, 15);
		lblRecieved.setText("Recieved:");
		
		Button btnOk = new Button(shlCashPayment, SWT.NONE);
		btnOk.setBounds(32, 64, 75, 25);
		btnOk.setText("OK");
		
		label = new Label(shlCashPayment, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setBounds(32, 95, 156, 21);
		
		btnCancel = new Button(shlCashPayment, SWT.NONE);
		btnCancel.setBounds(113, 64, 75, 25);
		btnCancel.setText("Cancel");

		
		btnOk.addSelectionListener(new SelectionListener()
		{
			
			public void widgetSelected(SelectionEvent event)
			{
			//	string 
			//	text.getText();
				//if(text.getText() == tempEmployee)
				double total;
				total = Double.parseDouble(text.getText());
				
				double recieved;
				recieved = Double.parseDouble(text_1.getText());
				
				double change = recieved - total;
				
				if (change < 0){
					label.setText("Sale failed.");
				}
				
				else{
				label.setText("Change: " + change);
				DigitCashier.finishShopping();
//				shlCashPayment.dispose();
				shlCashPayment.close();
				}

				

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
	}
}
