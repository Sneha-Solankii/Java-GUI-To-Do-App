import javax.swing.*;
import java.awt.*;

public class To_Do_App { // Class name

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public To_Do_App() { // Constructor name same as class
        // Frame setup
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Task list model
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input field + Add button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // Delete button
        JButton deleteButton = new JButton("Delete Task");

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(To_Do_App::new); // Call same class
    }
}
