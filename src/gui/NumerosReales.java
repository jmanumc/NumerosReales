package gui;

import app.Valor;
import app.Numero;
import app.Gramatica;
import java.awt.Frame;
import java.awt.GridLayout;
import gui.panels.ActionsPanel;
import gui.components.MyTextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class NumerosReales extends Frame {
    private final String title = "Numeros Reales";
    private final int width = 800;
    private final int heigth = 600;

    private Gramatica gramatica;
    private Numero numero;

    private MyTextArea output;
    private ActionsPanel actions;
    private GridLayout layout;

    public NumerosReales() {
        numero = new Numero();
        gramatica = new Gramatica(Valor.numeroReal);
        output = new MyTextArea(gramatica.toString());
        actions = new ActionsPanel(gramatica, numero, output);
        layout = new GridLayout(1, 2);
    }

    private void components() {
        output.setEditable(false);
        setLayout(layout);

        add(actions);
        add(output);
    }

    private void listeners() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void launch() {
        components();
        listeners();

        setTitle(title);
        setSize(width, heigth);
        setLocationRelativeTo(null);
        setResizable(false);;
        setVisible(true);
    }

    public static void main(String[] args) {
        NumerosReales app = new NumerosReales();
        app.launch();
    }
}
