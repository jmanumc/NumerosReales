package views;

import java.awt.Panel;
import java.awt.GridLayout;
import controllers.AppController;
import views.components.MyTextArea;

public class AppView extends FrameView {

    public AppController app;
    public SidebarView sidebar;

    public MyTextArea output;
    public GridLayout layout;

    public AppView() {
        output = new MyTextArea();
        layout = new GridLayout(1, 2);
    }

    public void dependencies(AppController app, SidebarView sidebar) {
        this.app = app;
        this.sidebar = sidebar;
    }

    @Override
    public void components() {
        output.setEditable(false);
        setLayout(layout);
        add(sidebar);
        add(output);
        setVisible(true);
    }

    @Override
    public void listeners() {
        // ...
    }

}
