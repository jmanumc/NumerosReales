package views;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.SidebarController;

public class SidebarView extends PanelView {

    public Button reset;
    public RealView real;
    public SignView sign;
    public TextArea output;
    public GridLayout layout;
    public DecimalsView decimals;
    public SidebarController controller;

    public SidebarView() {
        reset = new Button();
        layout = new GridLayout(3, 1);
    }

    public void dependencies(SidebarController controller, AppView appView,
    SignView sign, RealView real, DecimalsView decimals) {
        this.controller = controller;
        this.sign = sign;
        this.real = real;
        this.decimals = decimals;
        output = appView.output;
    }

    @Override
    public void components() {
        setLayout(layout);
        add(sign);
        add(real);
        add(decimals);
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
