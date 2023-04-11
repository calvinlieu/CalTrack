package BMICalc;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BMICalc {

    public Display display;
    Shell shell;
    Text weightText;
    Text heightText;
    Label resultLabel;
    Image bmiImage;
	

    public BMICalc(Display display) {
        shell = new Shell(display);
    }

    public static void main(String[] args) {
        Display display = new Display();
        try {
            BMICalc window = new BMICalc(display);
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            display.dispose();
        }
    }

    public void open() {
        createContents(shell);
        shell.open();
        shell.layout();
        Display display = Display.getDefault();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public void createContents(Shell shell) {
        shell.setText("BMI Calculator");
        GridLayout layout = new GridLayout(2, false);
        shell.setLayout(layout);
        
        
        bmiImage = new Image(display, "src/bmi-chart.jpg");
        int newWidth = 800;
        int newHeight = 400;
        Image scaledImage = new Image(display, bmiImage.getImageData().scaledTo(newWidth, newHeight));
        Label imageLabel = new Label(shell, SWT.NONE);
        imageLabel.setImage(scaledImage);
        GridData imageGridData = new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1);
        imageLabel.setLayoutData(imageGridData);
        

        Label weightLabel = new Label(shell, SWT.NONE);
        weightLabel.setText("Weight (lbs):");

        weightText = new Text(shell, SWT.BORDER);

        Label heightLabel = new Label(shell, SWT.NONE);
        heightLabel.setText("Height (inches):");

        heightText = new Text(shell, SWT.BORDER);

        resultLabel = new Label(shell, SWT.NONE);
        resultLabel.setText("Result (BMI): ");
        GridData resultGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        resultLabel.setLayoutData(resultGridData);

        Button calculateButton = new Button(shell, SWT.NONE);
        calculateButton.setText("Calculate BMI");
        GridData calculateGridData = new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1);
        calculateButton.setLayoutData(calculateGridData);
        calculateButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                calculateBMI();
            }
        });
        
        new Label(shell, SWT.NONE);
        Label disclaimerLabel = new Label(shell, SWT.NONE);
        disclaimerLabel.setText("Disclaimer: This BMI calculator is intended for educational purposes only and should not be used as a substitute for professional medical advice. "
        		+ "Please consult your doctor before making any health or fitness decisions.");
        GridData disclaimerGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        disclaimerLabel.setLayoutData(disclaimerGridData);
        new Label(shell, SWT.NONE);
        
  
        shell.pack();
        shell.open();
    }

    	void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightText.getText());
            double height = Double.parseDouble(heightText.getText());
            
            if (weight < 1 || height < 1) {
            	throw new ArithmeticException();
            	
            }
            double bmi = (weight * 703) / (height * height);
            resultLabel.setText("Result (BMI): " + String.format("%.2f", bmi));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter valid weight and height values.");
        } catch (ArithmeticException e) {
            resultLabel.setText("Invalid input. Height and weight value should not be less than 1.");
        }
    }
}
