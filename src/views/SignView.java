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

    public AppView app;
    public SignController sign;

    public Button next;
    public TextArea output;
    public GridLayout layout;
    public CheckboxGroup group;
    public Checkbox without, positive, negative;

    public SignView() {
        next = new Button();
        group = new CheckboxGroup();
        layout = new GridLayout(4, 1);
        without = new Checkbox("", group, true);
        positive = new Checkbox("", group, false);
        negative = new Checkbox("", group, false);
    }

    public void dependencies(SignController sign, AppView app) {
        this.sign = sign;
        this.app = app;
        output = app.output;
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
                sign.without();
            }
        });

        positive.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sign.positive();
            }
        });

        negative.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sign.negative();
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sign.next();
            }
        });
    }
    
}
