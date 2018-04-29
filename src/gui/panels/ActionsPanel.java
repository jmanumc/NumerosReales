package gui.panels;

import app.Numero;
import app.Gramatica;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsPanel extends Panel {
    Numero numero;
    Gramatica gramatica;

    private Button reset;
    private TextArea output;

    private SignPanel sign;
    private RealPanel real;
    private DecimalsPanel decimals;

    public ActionsPanel(Gramatica gramatica, Numero numero, TextArea output) {
        this.gramatica = gramatica;
        this.numero = numero;
        this.output = output;

        reset = new Button("Reiniciar");
        sign = new SignPanel(gramatica, numero, output);
        real = new RealPanel(gramatica, numero, output);
        decimals = new DecimalsPanel(gramatica, numero, output, reset);

        sign.setPanels(real);
        real.setPanels(sign, decimals);
        decimals.setPanels(real);

        real.enabled(false);
        decimals.enabled(false);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        setLayout(new GridLayout(3, 1));
        add(sign);
        add(real);
        add(decimals);
    }

    private void reset() {
        numero.setSigno("");
        numero.setReales("");
        numero.setDecimales("");
        numero.setConPunto(true);
        gramatica.setValor("");
        output.setText(gramatica.toString());

        sign.reset();
        real.reset();
        decimals.reset();
    }
}
