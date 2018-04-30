package controllers;

import app.Numero;
import app.Gramatica;
import views.SidebarView;

public class SidebarController extends Controller {

    private Numero numero;
    private SidebarView view;
    private Gramatica gramatica;
    private SignController signController;
    private RealController realController;
    private DecimalsController decimalsController;

    public SidebarController(Gramatica gramatica, Numero numero) {
        this.gramatica = gramatica;
        this.numero = numero;
    }

    public void dependencies(SidebarView view, SignController signController,
    RealController realController, DecimalsController decimalsController) {
        this.view = view;
        this.signController = signController;
        this.realController = realController;
        this.decimalsController = decimalsController;
    }

    @Override
    public void initialize() {
        signController.enabled(true);
        realController.enabled(false);
        view.reset.setLabel("Reiniciar");
        decimalsController.enabled(false);
    }

    public void reset() {
        numero.setSigno("");
        numero.setReales("");
        numero.setDecimales("");
        numero.setConPunto(true);
        gramatica.setValor("");
        signController.reset();
        realController.reset();
        decimalsController.reset();
        view.output.setText(gramatica.toString());
    }

}
