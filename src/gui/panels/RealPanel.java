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

public class RealPanel extends Panel {
    private Numero numero;
    private Gramatica gramatica;
    private Boolean isDigit;
    private String tag;

    private Button next;
    private TextField real;
    private Checkbox digit;
    private TextArea output;
    private SignPanel prevPanel;
    private Checkbox digitPoint;
    private CheckboxGroup options;
    private DecimalsPanel nextPanel;

    public RealPanel(Gramatica gramatica, Numero numero, TextArea output) {
        this.gramatica = gramatica;
        this.numero = numero;
        this.output = output;
        isDigit = true;

        options = new CheckboxGroup();
        digit = new Checkbox("Digito", options, true);
        digitPoint = new Checkbox("Digito con punto", options, false);
        real = new TextField();
        next = new Button("Agregar");

        setLayout(new GridLayout(4, 1));
        add(digit);
        add(digitPoint);
        add(real);
        add(next);

        digit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                isDigit = true;
                next.setLabel("Agregar");
            }
        });

        digitPoint.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                isDigit = false;
                next.setLabel("Siguiente");
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPanels(SignPanel prev, DecimalsPanel next) {
        this.prevPanel = prev;
        this.nextPanel = next;
    }

    public void reset() {
        tag = null;
        isDigit = true;

        digit.setState(true);
        next.setLabel("Agregar");

        enabled(false);
    }

    public void enabled(boolean enabled) {
        digit.setEnabled(enabled);
        digitPoint.setEnabled(enabled);
        real.setEnabled(enabled);
        next.setEnabled(enabled);
    }

    public void next() {
        String value = real.getText().trim();
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
                real.setText("");
                numero.setConPunto(false);
                gramatica.agregarValorConClave(Valor.digito + tag);
                numero.addReal(number + "");
                gramatica.agregarValorConClave(numero + tag);
            } else {
                real.setText("");
                numero.setConPunto(true);
                gramatica.agregarValorConClave(numero + Valor.digito + Valor.punto);
                numero.addReal(number + "");
                gramatica.agregarValorConClave(numero + Valor.decimales);
                nextPanel.enabled(true);
                enabled(false);
            }

            real.setBackground(Color.WHITE);
            output.setText(gramatica.toString());
        } catch (NumberFormatException e) {
            real.setBackground(Color.RED);
        } catch (Exception e) {
            real.setBackground(Color.RED);
        }
    }
}
