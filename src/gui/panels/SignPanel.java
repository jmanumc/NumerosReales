package gui.panels;

import app.Valor;
import app.Numero;
import app.Gramatica;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class SignPanel extends Panel {
    private String tag;
    private Numero numero;
    private Gramatica gramatica;

    private Button next;
    private TextArea output;
    private Checkbox without;
    private Checkbox positive;
    private Checkbox negative;
    private CheckboxGroup options;
    private RealPanel nextPanel;
    private GridLayout layout;

    public SignPanel(Gramatica gramatica, Numero numero, TextArea output) {
        this.gramatica = gramatica;
        this.numero = numero;
        this.output = output;
        this.nextPanel = nextPanel;
        tag = Valor.sinSigno;
        options = new CheckboxGroup();
        without = new Checkbox("Sin signo", options, true);
        positive = new Checkbox("Con signo positivo", options, false);
        negative = new Checkbox("Con signo negativo", options, false);
        next = new Button("Siguiente");
        layout = new GridLayout(4, 1);

        setLayout(layout);
        add(without);
        add(positive);
        add(negative);
        add(next);

        without.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                without();
            }
        });

        positive.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                positive();
            }
        });

        negative.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                negative();
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
    }

    public void setPanels(RealPanel next) {
        this.nextPanel = next;
    }

    public void without() {
        tag = Valor.sinSigno;
    }

    public void positive() {
        tag = Valor.conSigno;

        numero.setSigno("+");
    }

    public void negative() {
        tag = Valor.conSigno;

        numero.setSigno("-");
    }

    public void reset() {
        tag = Valor.sinSigno;
        without.setState(true);

        enabled(true);
    }

    public void enabled(boolean enabled) {
        without.setEnabled(enabled);
        positive.setEnabled(enabled);
        negative.setEnabled(enabled);
        next.setEnabled(enabled);
    }

    public void next() {
        gramatica.agregarValorConClave(tag);

        if (! numero.getSigno().isEmpty()) {
            gramatica.agregarValorConClave(numero + Valor.sinSigno);
        }

        output.setText(gramatica.toString());
        enabled(false);
        nextPanel.enabled(true);
        nextPanel.setTag(tag);
    }
}
