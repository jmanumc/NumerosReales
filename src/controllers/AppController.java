package controllers;

import app.Gramatica;
import views.AppView;

public class AppController extends Controller {

    private AppView view;
    private Gramatica gramatica;

    public AppController(Gramatica gramatica) {
        this.gramatica = gramatica;
    }

    public void dependencies(AppView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        view.output.setText(gramatica.toString());
        view.setTitle("Gramatica: Numeros Reales");
    }

}
