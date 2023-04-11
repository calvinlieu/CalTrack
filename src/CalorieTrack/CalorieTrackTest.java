package CalorieTrack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

public class CalorieTrackTest {
    private Display display;
    private Shell shell;
    private CalorieTrack calorieTrack;
    private Text foodText;
    private Text calorieText;
    private Table table;
    private Button addButton;
    private Button removeButton;
    private int initialTableItemCount;

    @BeforeEach
    public void setUp() {
        display = new Display();
        shell = new Shell(display);
        calorieTrack = new CalorieTrack(display);
        calorieTrack.shell = shell;

        calorieTrack.createContents();

        foodText = (Text) shell.getChildren()[1];
        calorieText = (Text) shell.getChildren()[3];
        addButton = (Button) shell.getChildren()[4];
        table = (Table) shell.getChildren()[5];
        removeButton = (Button) shell.getChildren()[6];

        initialTableItemCount = table.getItemCount();
    }

    @AfterEach
    public void tearDown() {
        shell.dispose();
        display.dispose();
    }

    @Test
    public void testAddButton() {
        foodText.setText("Apple");
        calorieText.setText("95");
        addButton.notifyListeners(SWT.Selection, null);

        TableItem item = table.getItem(initialTableItemCount);
        assertEquals("Apple", item.getText(0));
        assertEquals("95", item.getText(1));
    }

    @Test
    public void testAddButtonInvalidCalories() {
        foodText.setText("Apple");
        calorieText.setText("invalid");
        addButton.notifyListeners(SWT.Selection, null);

        assertEquals(initialTableItemCount, table.getItemCount());
    }

    @Test
    public void testRemoveButton() {
        table.select(0);
        int selectedIndices[] = table.getSelectionIndices();
        int removedCalories = 0;
        
        for (int i = 0; i < selectedIndices.length; i++) {
            TableItem item = table.getItem(i);
            removedCalories += Integer.parseInt(item.getText(1));
        }

        removeButton.notifyListeners(SWT.Selection, null);

        assertEquals(initialTableItemCount - selectedIndices.length, table.getItemCount());
        assertEquals("0", calorieTrack.totalValue.getText());
    }
}
