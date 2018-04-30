package views;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import controllers.SignController;
import java.awt.event.ActionEvent;
import controllers.SignController;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class SignView extends PanelView {

    public Button next;
    public AppView appView;
    public TextArea output;
    public GridLayout layout;
    public CheckboxGroup group;
    public SignController controller;
    public Checkbox without, positive, negative;

    public SignView() {
        next = new Button();
        group = new CheckboxGroup();
        layout = new GridLayout(4, 1);
        without = new Checkbox("", group, true);
        positive = new Checkbox("", group, false);
        negative = new Checkbox("", group, false);
    }

    public void dependencies(SignController controller, AppView appView) {
        this.controller = controller;
        this.appView = appView;
        output = appView.output;
    }
    
    @Override
    public void components() {
        setLayout(layout);
        add(without);
        add(positive);
        add(negative);
        add(next);
    }

    @Override
    public void listeners() {
        without.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                controller.without();
            }
        });

        positive.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                controller.positive();
            }
        });

        negative.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                controller.negative();
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.next();
            }
        });
    }
    
}
