package views;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.SidebarController;

public class SidebarView extends PanelView {

    public Button reset;
    public TextArea output;
    public GridLayout layout;
    public RealView realView;
    public SignView signView;
    public DecimalsView decimalsView;
    public SidebarController controller;

    public SidebarView() {
        reset = new Button();
        layout = new GridLayout(3, 1);
    }

    public void dependencies(SidebarController controller, AppView appView,
    SignView signView, RealView realView, DecimalsView decimalsView) {
        this.controller = controller;
        this.signView = signView;
        this.realView = realView;
        this.decimalsView = decimalsView;
        output = appView.output;
    }

    @Override
    public void components() {
        setLayout(layout);
        add(signView);
        add(realView);
        add(decimalsView);
    }

    @Override
    public void listeners() {
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.reset();
            }
        });
    }

}
