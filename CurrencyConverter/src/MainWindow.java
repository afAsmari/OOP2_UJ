import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainWindow extends JFrame {
    JPanel mainPanel, topPanel, bottomPanel;
    JComboBox currencyConvertingFrom;
    JComboBox currencyConvertingTo;
    JButton conversionButton;
    JTextField inputCurrency;
    JTextField outputCurrency;

    MainWindow(){
        // main configurations
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Currency Converter");

        mainPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        currencyConvertingFrom = new JComboBox<>(Currencies.currencies);
        currencyConvertingTo = new JComboBox<>(Currencies.currencies);
        conversionButton = new JButton("Convert");
        inputCurrency = new JTextField(8);
        outputCurrency = new JTextField(8);

        conversionButton.addActionListener(new ConvertAction());

        topPanel.add(currencyConvertingFrom);
        topPanel.add(currencyConvertingTo);
        bottomPanel.add(inputCurrency);
        bottomPanel.add(conversionButton);
        bottomPanel.add(outputCurrency);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);


        this.add(mainPanel);

        this.setVisible(true);
    }

    private class ConvertAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ExchangeRatesApiConfiguration config = new ExchangeRatesApiConfiguration();
            config.setENDPOINT("convert");
            Map<String, String> parameters = new LinkedHashMap<>();
            parameters.put("access_key", ""/*API_KEY*/);
            parameters.put("from", (String) currencyConvertingFrom.getSelectedItem());
            parameters.put("to", (String) currencyConvertingTo.getSelectedItem());
            parameters.put("amount", inputCurrency.getText());
            config.setParameters(parameters);
            ApiGateway gateway = new ApiGateway(config);
            outputCurrency.setText(Double.toString(gateway.result));
        }
    }
}
