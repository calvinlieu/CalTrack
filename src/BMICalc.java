import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BMICalc {

    public Display display;
    private Shell shell;
    private Text weightText;
    private Text heightText;
    private Label resultLabel;

    public BMICalc(Display display) {
        shell = new Shell(display);
        shell.setMinimumSize(new Point(200, 200));
        shell.setMaximumSize(new Point(200, 200));
        shell.setModified(true);
    }

    /**
     * Launch the application.
     * 
     * @param args
     */
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

    /**
     * Open the window.
     */
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

    /**
     * Create contents of the window.
     */
    protected void createContents(Shell shell) {
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

    }

    private void calculateBMI() {
        double weight = Double.parseDouble(weightText.getText());
        double height = Double.parseDouble(heightText.getText());
        double bmi = (weight * 703) / (height * height);
        resultLabel.setText("Result (BMI): " + String.format("%.2f", bmi));
    }

}
