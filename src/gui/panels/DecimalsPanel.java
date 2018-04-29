package gui.panels;

import app.Valor;
import app.Numero;
import app.Gramatica;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class DecimalsPanel extends Panel {
    private Numero numero;
    private Gramatica gramatica;
    private boolean isDigit;

    private Button reset;
    private Panel actions;
    private Checkbox digit;
    private TextArea output;
    private Panel prevPanel;
    private Button finalize;
    private TextField decimal;
    private GridLayout layout;
    private CheckboxGroup options;
    private Checkbox digitDecimals;

    public DecimalsPanel(Gramatica gramatica, Numero numero, TextArea output, Button reset) {
        this.gramatica = gramatica;
        this.numero = numero;
        this.output = output;
        isDigit = false;

        layout = new GridLayout(4, 1);
        options = new CheckboxGroup();
        digitDecimals = new Checkbox("Digito con decimal", options, true);
        digit = new Checkbox("Digito", options, false);
        decimal = new TextField();
        actions = new Panel(new GridLayout(1, 2));
        finalize = new Button("Agregar");
        this.reset = reset;

        digitDecimals.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                isDigit = false;
                finalize.setLabel("Agregar");
            }
        });

        digit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                isDigit = true;
                finalize.setLabel("Finalizar");
            }
        });

        finalize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalized();
            }
        });

        setLayout(layout);
        add(digitDecimals);
        add(digit);
        add(decimal);

        actions.add(finalize);
        actions.add(reset);

        add(actions);
    }

    public void setPanels(Panel prev) {
        this.prevPanel = prev;
    }

    public void enabled(boolean enabled) {
        digitDecimals.setEnabled(enabled);
        digit.setEnabled(enabled);
        decimal.setEnabled(enabled);
        finalize.setEnabled(enabled);
    }

    public void reset() {
        isDigit = false;

        digitDecimals.setState(true);
        finalize.setLabel("Agregar");

        enabled(false);
    }

    private void finalized() {
        String value = decimal.getText().trim();
        int number;

        try {
            if (value.isEmpty()) {
                throw new Exception();
            }

            if (value.length() != 1) {
                throw new Exception();
            }

            number = Integer.parseInt(value);

            if (isDigit) {
                decimal.setText("");
                gramatica.agregarValorConClave(numero + Valor.digito);
                numero.addDecimal(number + "");
                gramatica.agregarValorConClave(numero.toString());

                enabled(false);
            } else {
                decimal.setText("");
                gramatica.agregarValorConClave(numero + Valor.digito + Valor.decimales);
                numero.addDecimal(number + "");
                gramatica.agregarValorConClave(numero + Valor.decimales);
            }

            decimal.setBackground(Color.WHITE);
            output.setText(gramatica.toString());
        } catch (NumberFormatException e) {
            decimal.setBackground(Color.RED);
        } catch (Exception e) {
            decimal.setBackground(Color.RED);
        }
    }
}
