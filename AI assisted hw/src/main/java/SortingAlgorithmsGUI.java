import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * The SortingAlgorithmsGUI class represents the graphical user interface for the sorting algorithms program.
 * It extends JFrame and implements the DiceObserver interface.
 */
public class SortingAlgorithmsGUI extends JFrame implements DiceObserver {

    private JTextField inputField;
    private JTextArea outputArea;
    private JButton rollAndSortButton;
    private SortingStrategy sortingStrategy;
    private SortingController controller;

    /**
     * Constructs a SortingAlgorithmsGUI object.
     * Initializes the GUI components, sets up the controller, and configures the window properties.
     */
    public SortingAlgorithmsGUI() {
        setTitle("Sorting Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        createUI();

        controller = new SortingController(this);
    }

    /**
     * Creates the user interface components and arranges them in the window.
     */
    private void createUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel instructionLabel = new JLabel("<html><h2>Instructions:</h2><br>" +
                "<ul>" +
                "<li>Enter an array of integers in the input field.</li>" +
                "<li>Click the 'Roll the Dice & Sort' button.</li>" +
                "<li>Based on the dice roll, a sorting algorithm will be selected.</li>" +
                "<li>The input array will be sorted using the selected algorithm.</li>" +
                "<li>The sorted array and additional information will be displayed in the output area.</li>" +
                "</ul></html>");
        panel.add(instructionLabel, BorderLayout.NORTH);

        JPanel inputPanel = createInputPanel();
        panel.add(inputPanel, BorderLayout.CENTER);

        rollAndSortButton = createRollAndSortButton();
        panel.add(rollAndSortButton, BorderLayout.SOUTH);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Creates the panel for the input field and label.
     *
     * @return The input panel.
     */
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JLabel inputLabel = new JLabel("Input Array:");
        inputField = new JTextField();
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        return inputPanel;
    }

    /**
     * Creates the "Roll the Dice & Sort" button and configures its action listener.
     *
     * @return The roll and sort button.
     */
    private JButton createRollAndSortButton() {
        JButton button = new JButton("Roll the Dice & Sort");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                controller.rollAndSortButtonClicked(input);
            }
        });
        return button;
    }

    /**
     * Displays an error message in the output area.
     *
     * @param message The error message to display.
     */
    public void displayErrorMessage(String message) {
        outputArea.setText(message);
    }

    /**
     * Displays the sorting result in the output area.
     *
     * @param sortMethod   The selected sorting algorithm.
     * @param sortedArray  The sorted array.
     */
    public void displaySortingResult(String sortMethod, int[] sortedArray) {
        outputArea.append("Sorting Algorithm: " + sortMethod + "\n");
        outputArea.append("Sorted Array: " + Arrays.toString(sortedArray));
    }

    /**
     * Enables or disables the roll and sort button.
     *
     * @param enable true to enable the button, false to disable.
     */
    public void enableRollAndSortButton(boolean enable) {
        rollAndSortButton.setEnabled(enable);
    }

    /**
     * Runs the GUI on the Event Dispatch Thread.
     */
    public void run() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    /**
     * Updates the GUI when the dice is rolled.
     * Retrieves the sorting algorithm based on the dice roll, sorts the input array,
     * and displays the sorting result in the output area.
     *
     * @param diceRoll The value rolled on the dice.
     */
    @Override
    public void update(int diceRoll) {
        outputArea.append("\n" + "Dice Number: " + diceRoll + "\n");

        String sortMethod = controller.getSortingAlgorithm(diceRoll);
        int[] arr = controller.parseInputArray(inputField.getText());

        if (sortMethod == null) {
            displayErrorMessage("Invalid sorting method.");
            return;
        }

        sortingStrategy = controller.getSortingStrategy(sortMethod);

        if (arr == null) {
            displayErrorMessage("Invalid input array!");
            return;
        }

        int[] sortedArray = controller.sortArray(arr, sortingStrategy);
        displaySortingResult(sortMethod, sortedArray);

        enableRollAndSortButton(true);
    }
}
