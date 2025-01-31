 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[4];
    JButton equalsButton, clearButton, eraseButton; // Added eraseButton
    double operand1 = 0;
    String operator = "";

    Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField();
        display.setBounds(50, 50, 250, 40);
        display.setEditable(false);
        add(display);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(50 + (i % 3) * 70, 100 + (i / 3) * 70, 60, 60);
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[4];
    JButton equalsButton, clearButton, eraseButton; // Added eraseButton
    double operand1 = 0;
    String operator = "";

    Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField();
        display.setBounds(50, 50, 250, 40);
        display.setEditable(false);
        add(display);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(50 + (i % 3) * 70, 100 + (i / 3) * 70, 60, 60);
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }

        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setBounds(280, 100 + i * 70, 60, 60);
            operatorButtons[i].addActionListener(this);
            add(operatorButtons[i]);
        }

        equalsButton = new JButton("=");
        equalsButton.setBounds(210, 310, 60, 60);
        equalsButton.addActionListener(this);
        add(equalsButton);

        clearButton = new JButton("C");
        clearButton.setBounds(50, 310, 60, 60);
        clearButton.addActionListener(this);
        add(clearButton);

        eraseButton = new JButton("<-"); // Erase button
        eraseButton.setBounds(125, 310, 60, 60); // Positioned next to clear
        eraseButton.addActionListener(this);
        add(eraseButton);


        setSize(400, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
            display.setText(display.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            operand1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        } else if (command.equals("=")) {
            double operand2 = Double.parseDouble(display.getText());
            double result = calculate(operand1, operand2, operator);
            display.setText(String.valueOf(result));
            operand1 = 0;
            operator = "";
        } else if (command.equals("C")) {
            display.setText("");operand1 = 0;
            operator = "";
        } else if (command.equals("<-")) { // Erase functionality
            String currentText = display.getText();
            if (currentText.length() > 0) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand1 / operand2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

 
  
