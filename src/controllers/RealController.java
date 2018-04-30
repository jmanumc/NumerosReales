package controllers;

import app.Valor;
import app.Numero;
import app.Gramatica;
import views.RealView;
import java.awt.Color;

public class RealController extends Controller {

    private int real;
    private String tag;
    private RealView view;
    private Numero numero;
    private Boolean isDigit;
    private Gramatica gramatica;
    private DecimalsController decimalsController;

    public RealController(Gramatica gramatica, Numero numero) {
        this.gramatica = gramatica;
        this.numero = numero;
        isDigit = true;
    }

    public void dependencies(RealView view, DecimalsController decimalsController) {
        this.view = view;
        this.decimalsController = decimalsController;
    }

    @Override
    public void initialize() {
        view.next.setLabel("Agregar");
        view.digit.setLabel("Digito");
        view.digitPoint.setLabel("Digito con punto");
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void reset() {
        tag = null;
        isDigit = true;
        enabled(false);
        view.real.setText("");
        view.digit.setState(true);
        view.next.setLabel("Agregar");
        view.real.setBackground(Color.WHITE);
    }

    public void enabled(boolean enabled) {
        view.digit.setEnabled(enabled);
        view.digitPoint.setEnabled(enabled);
        view.real.setEnabled(enabled);
        view.next.setEnabled(enabled);
    }

    public int validate(String text) throws Exception {
        if (text.isEmpty()) {
            throw new Exception("Valor vacio");
        }

        if (text.length() != 1) {
            throw new Exception("Longitud superada");
        }

        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new Exception("No es numero");
        }
    }

    public void digit() {
        isDigit = true;
        view.next.setLabel("Agregar");
    }

    public void digitPoint() {
        isDigit = false;
        view.next.setLabel("Siguiente");
    }

    public void real() {
        try {
            real = validate(view.real.getText().trim());
            view.real.setBackground(Color.WHITE);

            if (isDigit) {
                view.next.setLabel("Agregar");
            } else {
                view.next.setLabel("Siguiente");
            }
        } catch (Exception e) {
            view.real.setBackground(Color.RED);
            view.next.setLabel(e.getMessage());
        }
    }

    public void next() {
        try {
            real = validate(view.real.getText().trim());

            if (isDigit) {
                view.real.setText("");
                view.next.setLabel("Agregar");
                numero.setConPunto(false);
                gramatica.agregarValorConClave(Valor.digito + tag);
                numero.addReal(real + "");
                gramatica.agregarValorConClave(numero + tag);
            } else {
                view.real.setText("");
                view.next.setLabel("Siguiente");
                numero.setConPunto(true);
                gramatica.agregarValorConClave(numero + Valor.digito + Valor.punto);
                numero.addReal(real + "");
                gramatica.agregarValorConClave(numero + Valor.decimales);
                decimalsController.enabled(true);
                enabled(false);
            }

            view.real.setBackground(Color.WHITE);
            view.output.setText(gramatica.toString());
        } catch (Exception e) {
            view.real.setBackground(Color.RED);
            view.next.setLabel(e.getMessage());
        }
    }

}
