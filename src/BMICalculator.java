

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class BMICalculator {
	private Display display;
	private Shell shell;
	private Text weightText;
	private Text heightText;
	private Label resultLabel;

	public static void main(String[] args) {
		BMICalculator bmiCalculator = new BMICalculator();
		bmiCalculator.open();
	}

	public void open() {
		display = new Display();
		shell = new Shell(display);
		shell.setSize(379, 231);
		shell.setText("BMI Calculator");
		shell.setLayout(new GridLayout(2, false));

		Label weightLabel = new Label(shell, SWT.NONE);
		weightLabel.setText("Weight (lbs):");
		weightText = new Text(shell, SWT.BORDER);

		Label heightLabel = new Label(shell, SWT.NONE);
		heightLabel.setText("Height (inches):");
		heightText = new Text(shell, SWT.BORDER);
		
		resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		resultLabel.setText("Result (BMI): ");
		
		
		Button calculateButton = new Button(shell, SWT.NONE);
		calculateButton.setText("Calculate BMI");
		calculateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calculateBMI();
			}
		});
		new Label(shell, SWT.NONE);

//        shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private void calculateBMI() {
		double weight = Double.parseDouble(weightText.getText());
		double height = Double.parseDouble(heightText.getText());
		double bmi = (weight * 703) / (height * height);
		resultLabel.setText("Result (BMI): " + String.format("%.2f", bmi));
	}
}
