package controllers;

import views.SignView;

import app.Valor;
import app.Numero;
import app.Gramatica;

public class SignController extends Controller {

    private String tag;
    private Numero numero;
    private SignView view;
    private Gramatica gramatica;
    private RealController realController;

    public SignController(Gramatica gramatica, Numero numero) {
        this.gramatica = gramatica;
        this.numero = numero;
        tag = Valor.sinSigno;
    }

    public void dependencies(SignView view, RealController realController) {
        this.view = view;
        this.realController = realController;
    }

    @Override
    public void initialize() {
        view.next.setLabel("Siguiente");
        view.without.setLabel("Sin signo");
        view.positive.setLabel("Con signo positivo");
        view.negative.setLabel("Con signo negativo");
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
        view.without.setState(true);
        enabled(true);
    }

    public void enabled(boolean enabled) {
        view.without.setEnabled(enabled);
        view.positive.setEnabled(enabled);
        view.negative.setEnabled(enabled);
        view.next.setEnabled(enabled);
    }

    public void next() {
        gramatica.agregarValorConClave(tag);

        if (! numero.getSigno().isEmpty()) {
            gramatica.agregarValorConClave(numero + Valor.sinSigno);
        }

        enabled(false);
        realController.setTag(tag);
        realController.enabled(true);
        view.output.setText(gramatica.toString());
    }

}
