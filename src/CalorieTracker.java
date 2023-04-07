import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

public class CalorieTracker {
	
	static Label totalValue;
	
	
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Calorie Tracker");
        shell.setSize(500, 400);
        shell.setLayout(new GridLayout(2, false));

       
        Label foodLabel = new Label(shell, SWT.NONE);
        foodLabel.setText("Food:");
        Text foodText = new Text(shell, SWT.BORDER);
        foodText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label calorieLabel = new Label(shell, SWT.NONE);
        calorieLabel.setText("Calories:");
        Text calorieText = new Text(shell, SWT.BORDER);
        calorieText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Button addButton = new Button(shell, SWT.PUSH);
        addButton.setText("Add");
        addButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        TableColumn foodColumn = new TableColumn(table, SWT.LEFT);
        foodColumn.setText("Food");
        foodColumn.setWidth(250);
        TableColumn calorieColumn = new TableColumn(table, SWT.LEFT);
        calorieColumn.setText("Calories");
        calorieColumn.setWidth(100);

        Button removeButton = new Button(shell, SWT.PUSH);
        removeButton.setText("Remove");
        removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Label totalLabel = new Label(shell, SWT.NONE);
        totalLabel.setText("Total Calories:");
       
        
        addButton.addListener(SWT.Selection, event -> {
            String food = foodText.getText();
            int calories = Integer.parseInt(calorieText.getText().trim());

            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(new String[] {food, String.valueOf(calories)});
            
            Label totalValue = new Label(shell, SWT.NONE);
            totalValue.setText("0".trim());

            int currentTotalCalories = Integer.parseInt(totalValue.getText());
            totalValue.setText(String.valueOf(currentTotalCalories + calories));
            System.out.println(totalValue.getText());

            foodText.setText("");
            calorieText.setText("");
        });
        
        
        removeButton.addListener(SWT.Selection, event -> {
            int[] selectedIndices = table.getSelectionIndices();
            int removedCalories = 0;

            for (int i = 0; i < selectedIndices.length; i++) {
                TableItem item = table.getItem(i);
                removedCalories += Integer.parseInt(item.getText(1).trim());
            }

            table.remove(selectedIndices);

            int currentTotalCalories = Integer.parseInt(totalValue.getText());
            totalValue.setText(String.valueOf(currentTotalCalories - removedCalories));
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
