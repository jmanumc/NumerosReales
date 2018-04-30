package views;

import java.awt.Panel;
import java.awt.GridLayout;
import controllers.AppController;
import views.components.MyTextArea;

public class AppView extends FrameView {

    public MyTextArea output;
    public GridLayout layout;
    public SidebarView sidebarView;
    public AppController controller;

    public AppView() {
        output = new MyTextArea();
        layout = new GridLayout(1, 2);
    }

    public void dependencies(AppController controller, SidebarView sidebarView) {
        this.controller = controller;
        this.sidebarView = sidebarView;
    }

    @Override
    public void components() {
        output.setEditable(false);
        setLayout(layout);
        add(sidebarView);
        add(output);
        setVisible(true);
    }

    @Override
    public void listeners() {
        // ...
    }

}
