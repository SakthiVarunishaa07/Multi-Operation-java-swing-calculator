import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorSwing extends JFrame {
    private JTextField countField;
    private JTextArea numbersArea;
    private JComboBox<String> operationCombo;
    private JLabel resultLabel;
    private JTextArea outputArea;
    
    public CalculatorSwing() {
        setTitle("Calculator");
        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        
        // Title
        JLabel title = new JLabel("===== CALCULATOR =====");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(160, 10, 250, 30);
        add(title);
        
        // Input for count
        JLabel countLabel = new JLabel("Enter total numbers to calculate:");
        countLabel.setBounds(50, 60, 200, 25);
        add(countLabel);
        
        countField = new JTextField();
        countField.setBounds(280, 60, 100, 25);
        add(countField);
        
        // Area for numbers
        JLabel numbersLabel = new JLabel("Enter numbers (one per line):");
        numbersLabel.setBounds(50, 100, 200, 25);
        add(numbersLabel);
        
        numbersArea = new JTextArea();
        numbersArea.setBounds(50, 130, 400, 120);
        numbersArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(numbersArea);
        scrollPane.setBounds(50, 130, 400, 120);
        add(scrollPane);
        
        // Operations
        JLabel opLabel = new JLabel("Select Operation:");
        opLabel.setBounds(50, 270, 120, 25);
        add(opLabel);
        
        String[] operations = {
            "1. Addition", "2. Subtraction", "3. Multiplication", 
            "4. Division", "5. Modulus", "6. Percentage", 
            "7. Average", "8. Find Minimum", "9. Find Maximum"
        };
        operationCombo = new JComboBox<>(operations);
        operationCombo.setBounds(180, 270, 200, 25);
        add(operationCombo);
        
        // Buttons
        JButton calculateBtn = new JButton("CALCULATE");
        calculateBtn.setBounds(100, 320, 150, 40);
        calculateBtn.setBackground(new Color(34, 139, 34));
        calculateBtn.setForeground(Color.WHITE);
        calculateBtn.addActionListener(e -> calculate());
        add(calculateBtn);
        
        JButton clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(280, 320, 150, 40);
        clearBtn.setBackground(new Color(220, 20, 60));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.addActionListener(e -> clearAll());
        add(clearBtn);
        
        // Result display
        resultLabel = new JLabel("Result will appear here");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(new Color(255, 69, 0));
        resultLabel.setBounds(50, 380, 450, 30);
        add(resultLabel);
        
        outputArea = new JTextArea();
        outputArea.setBounds(50, 420, 450, 130);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.WHITE);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBounds(50, 420, 450, 130);
        add(outputScroll);
        
        setVisible(true);
    }
    
    private void calculate() {
        try {
            int count = Integer.parseInt(countField.getText());
            String[] lines = numbersArea.getText().trim().split("\n");
            
            if(lines.length != count) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter exactly " + count + " numbers (one per line)");
                return;
            }
            
            double[] numbers = new double[count];
            for(int i = 0; i < count; i++) {
                numbers[i] = Double.parseDouble(lines[i].trim());
            }
            
            int choice = operationCombo.getSelectedIndex() + 1;
            double result = 0;
            boolean validOperation = true;
            String operationName = "";
            
            // YOUR EXACT LOGIC HERE
            switch(choice) {
                case 1: // Addition
                    result = 0;
                    for(int i = 0; i < numbers.length; i++) {
                        result += numbers[i];
                    }
                    operationName = "Addition";
                    break;
                    
                case 2: // Subtraction
                    result = numbers[0];
                    for(int i = 1; i < numbers.length; i++) {
                        result -= numbers[i];
                    }
                    operationName = "Subtraction";
                    break;
                    
                case 3: // Multiplication
                    result = 1;
                    for(int i = 0; i < numbers.length; i++) {
                        result *= numbers[i];
                    }
                    operationName = "Multiplication";
                    break;
                    
                case 4: // Division
                    result = numbers[0];
                    for(int i = 1; i < numbers.length; i++) {
                        if(numbers[i] != 0) {
                            result /= numbers[i];
                        } else {
                            JOptionPane.showMessageDialog(this, "Division is impossible with zero");
                            validOperation = false;
                        }
                    }
                    operationName = "Division";
                    break;
                    
                case 5: // Modulus
                    result = numbers[0];
                    for(int i = 1; i < numbers.length; i++) {
                        if(numbers[i] != 0) {
                            result %= numbers[i];
                        } else {
                            JOptionPane.showMessageDialog(this, "Modulus is impossible with zero");
                            validOperation = false;
                        }
                    }
                    operationName = "Modulus";
                    break;
                    
                case 6: // Percentage
                    double total = 0;
                    for(int i = 0; i < numbers.length; i++) {
                        total += numbers[i];
                    }
                    double maxPossible = numbers.length * 100;
                    result = (total / maxPossible) * 100;
                    operationName = "Percentage";
                    break;
                    
                case 7: // Average
                    double sum = 0;
                    for(int i = 0; i < numbers.length; i++) {
                        sum += numbers[i];
                    }
                    result = sum / numbers.length;
                    operationName = "Average";
                    break;
                    
                case 8: // Find Minimum
                    result = numbers[0];
                    for(int i = 1; i < numbers.length; i++) {
                        if(numbers[i] < result) {
                            result = numbers[i];
                        }
                    }
                    operationName = "Minimum";
                    break;
                    
                case 9: // Find Maximum
                    result = numbers[0];
                    for(int i = 1; i < numbers.length; i++) {
                        if(numbers[i] > result) {
                            result = numbers[i];
                        }
                    }
                    operationName = "Maximum";
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, "Invalid Operator!!");
                    validOperation = false;
                    break;
            }
            
            if(validOperation) {
                resultLabel.setText(String.format("Result: %.2f", result));
                
                StringBuilder detailed = new StringBuilder();
                detailed.append("Operation: ").append(operationName).append("\n");
                detailed.append("Numbers: ");
                for(int i = 0; i < numbers.length; i++) {
                    detailed.append(numbers[i]);
                    if(i < numbers.length - 1) detailed.append(", ");
                }
                detailed.append("\nResult: ").append(String.format("%.2f", result));
                
                outputArea.setText(detailed.toString());
            }
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }
    
    private void clearAll() {
        countField.setText("");
        numbersArea.setText("");
        operationCombo.setSelectedIndex(0);
        resultLabel.setText("Result will appear here");
        outputArea.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorSwing());
    }
}