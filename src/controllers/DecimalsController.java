package controllers;

import app.Valor;
import app.Numero;
import app.Gramatica;
import java.awt.Color;
import views.DecimalsView;

public class DecimalsController extends Controller {

    private int decimal;
    private Numero numero;
    private boolean isDigit;
    private DecimalsView view;
    private Gramatica gramatica;

    public DecimalsController(Gramatica gramatica, Numero numero) {
        this.gramatica = gramatica;
        this.numero = numero;
        isDigit = false;
    }

    public void dependencies(DecimalsView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        view.digit.setLabel("Digito");
        view.finalize.setLabel("Agregar");
        view.digitDecimals.setLabel("Digito con decimal");
    }

    public void reset() {
        enabled(false);
        isDigit = false;
        view.decimal.setText("");
        view.digitDecimals.setState(true);
        view.finalize.setLabel("Agregar");
        view.decimal.setBackground(Color.WHITE);
    }

    public void enabled(boolean enabled) {
        view.digitDecimals.setEnabled(enabled);
        view.digit.setEnabled(enabled);
        view.decimal.setEnabled(enabled);
        view.finalize.setEnabled(enabled);
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

    public void digitDecimals() {
        isDigit = false;
        view.finalize.setLabel("Agregar");
    }

    public void digit() {
        isDigit = true;
        view.finalize.setLabel("Finalizar");
    }

    public void decimal() {
        try {
            decimal = validate(view.decimal.getText().trim());
            view.decimal.setBackground(Color.WHITE);

            if (isDigit) {
                view.finalize.setLabel("Finalizar");
            } else {
                view.finalize.setLabel("Agregar");
            }
        } catch (Exception e) {
            view.decimal.setBackground(Color.RED);
            view.finalize.setLabel(e.getMessage());
        }
    }

    public void finalize() {
        try {
            decimal = validate(view.decimal.getText().trim());

            if (isDigit) {
                view.decimal.setText("");
                view.finalize.setLabel("Finalizar");
                gramatica.agregarValorConClave(numero + Valor.digito);
                numero.addDecimal(decimal + "");
                gramatica.agregarValorConClave(numero.toString());
                enabled(false);
            } else {
                view.decimal.setText("");
                view.finalize.setLabel("Agregar");
                gramatica.agregarValorConClave(numero + Valor.digito + Valor.decimales);
                numero.addDecimal(decimal + "");
                gramatica.agregarValorConClave(numero + Valor.decimales);
            }

            view.decimal.setBackground(Color.WHITE);
            view.output.setText(gramatica.toString());
        } catch (Exception e) {
            view.decimal.setBackground(Color.RED);
            view.finalize.setLabel(e.getMessage());
        }
    }

}
