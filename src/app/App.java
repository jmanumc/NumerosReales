package app;

import views.AppView;
import views.SignView;
import views.RealView;
import views.SidebarView;
import views.DecimalsView;
import controllers.AppController;
import controllers.SignController;
import controllers.RealController;
import controllers.SidebarController;
import controllers.DecimalsController;

public class App {
    public static void main(String[] args) {

        // Objects
        Gramatica gramatica = new Gramatica(Valor.numeroReal);
        Numero numero = new Numero();

        // Views
        AppView appView = new AppView();
        SidebarView sidebarView = new SidebarView();
        SignView signView = new SignView();
        RealView realView = new RealView();
        DecimalsView decimalsView = new DecimalsView();

        // Controllers
        AppController appController = new AppController(gramatica);
        SidebarController sidebarController = new SidebarController(gramatica, numero);
        SignController signController = new SignController(gramatica, numero);
        RealController realController = new RealController(gramatica, numero);
        DecimalsController decimalsController = new DecimalsController(gramatica, numero);

        // Controllers's dependencies
        appController.dependencies(appView);
        sidebarController.dependencies(sidebarView, signController, realController, decimalsController);
        signController.dependencies(signView, realController);
        realController.dependencies(realView, decimalsController);
        decimalsController.dependencies(decimalsView);

        // Views's dependencies
        appView.dependencies(appController, sidebarView);
        sidebarView.dependencies(sidebarController, appView, signView, realView, decimalsView);
        signView.dependencies(signController, appView);
        realView.dependencies(realController, appView);
        decimalsView.dependencies(decimalsController, appView, sidebarView);

        // Initialize
        appController.initialize();
        sidebarController.initialize();
        signController.initialize();
        realController.initialize();
        decimalsController.initialize();

        // Launchers
        sidebarView.launch();
        signView.launch();
        realView.launch();
        decimalsView.launch();
        appView.launch();

    }
}
