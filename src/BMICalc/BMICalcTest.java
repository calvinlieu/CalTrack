package BMICalc;
import static org.junit.Assert.*;

import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BMICalcTest {

    private Display display;
    private BMICalc bmiCalc;

    @Before
    public void setUp() {
        display = new Display();
        bmiCalc = new BMICalc(display);
        bmiCalc.createContents(bmiCalc.shell);
    }

    @Test
    public void testInvalidWeightInput() {
        bmiCalc.weightText.setText("abc");
        bmiCalc.heightText.setText("70");
        bmiCalc.calculateBMI();
        assertEquals("Invalid input. Please enter valid weight and height values.", bmiCalc.resultLabel.getText());
    }
    
    @Test
    public void testInvalidHeightInput() {
        bmiCalc.weightText.setText("126");
        bmiCalc.heightText.setText("-1");
        bmiCalc.calculateBMI();
        assertEquals("Invalid input. Height and weight value should not be less than 1.", bmiCalc.resultLabel.getText());
    }

    @Test
    public void testCalculateBMI() {
        bmiCalc.weightText.setText("150");
        bmiCalc.heightText.setText("70");
        bmiCalc.calculateBMI();
        assertEquals("Result (BMI): 21.52", bmiCalc.resultLabel.getText());
    }

    @After
    public void tearDown() {
        bmiCalc.shell.dispose();
        display.dispose();
    }
}
