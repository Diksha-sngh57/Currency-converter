import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> fromBox;
    private JComboBox<String> toBox;
    private JTextField amountField;
    private JLabel resultLabel;
    private Map<String, String> symbols;

    public CurrencyConverter() {
        // Initialize currency symbols
        symbols = new HashMap<>();
        symbols.put("USD", "$");
        symbols.put("EUR", "€");
        symbols.put("GBP", "£");
        symbols.put("JPY", "¥");
        symbols.put("AUD", "A$");
        symbols.put("CAD", "C$");
        symbols.put("CHF", "CHF");
        symbols.put("CNY", "¥");
        symbols.put("INR", "₹");
        symbols.put("BRL", "R$");

        // List of currencies
        String[] currencies = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "INR", "BRL"};

        // UI Components
        fromBox = new JComboBox<>(currencies);
        toBox = new JComboBox<>(currencies);
        amountField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("From Currency:"), gbc);
        gbc.gridx = 1;
        panel.add(fromBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("To Currency:"), gbc);
        gbc.gridx = 1;
        panel.add(toBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Amount:"), gbc);
        gbc.gridx = 1;
        panel.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(convertButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(resultLabel, gbc);

        // Add action listener to button
        convertButton.addActionListener(e -> convert());

        // Frame settings
        add(panel);
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convert() {
        String from = (String) fromBox.getSelectedItem();
        String to = (String) toBox.getSelectedItem();
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount < 0) {
                throw new Exception("Amount must be positive");
            }
            double rate = getExchangeRate(from, to);
            double converted = amount * rate;
            String symbol = symbols.getOrDefault(to, to);
            resultLabel.setText(String.format("<html><div style='width: 200px; text-align: center;'>Result: %.2f %s</div></html>", converted, symbol));
        } catch (NumberFormatException ex) {
            resultLabel.setText("<html><div style='width: 200px; text-align: center;'>Error: Invalid amount</div></html>");
        } catch (Exception ex) {
            resultLabel.setText("<html><div style='width: 200px; text-align: center;'>Error: Exchange rate not found for " + to + "</div></html>");
        }
    }

    private double getExchangeRate(String from, String to) throws Exception {
        if (from.equals(to)) {
            return 1.0;
        }
        // Simulating API call with static rates due to error
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.85);
        rates.put("GBP", 0.73);
        rates.put("JPY", 110.0);
        rates.put("AUD", 1.35);
        rates.put("CAD", 1.25);
        rates.put("CHF", 0.91);
        rates.put("CNY", 6.45);
        rates.put("INR", 74.0);
        rates.put("BRL", 5.20);

        if (!rates.containsKey(to)) {
            throw new Exception("Exchange rate not found for " + to);
        }
        return rates.get(to) / rates.get(from);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrencyConverter::new);
    }
}