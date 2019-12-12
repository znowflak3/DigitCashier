package CashierSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class LoginClass extends Shell {
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			LoginClass shell = new LoginClass(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public LoginClass(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(85, 32, 218, 15);
		lblNewLabel.setText("Hejsan och v\u00E4lkommen att logga in");
		
		Button btnNewBlutton = new Button(this, SWT.NONE);
		btnNewBlutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				removeButtonUsage();
				
			}
		});	
		btnNewBlutton.setBounds(139, 119, 75, 34);
		btnNewBlutton.setText("LOGGA IN");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(138, 79, 76, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(382, 264);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
