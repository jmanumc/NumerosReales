package views;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import controllers.RealController;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class RealView extends PanelView {

    public Button next;
    public TextField real;
    public AppView appView;
    public TextArea output;
    public GridLayout layout;
    public CheckboxGroup group;
    public RealController controller;
    public Checkbox digit, digitPoint;

    public RealView() {
        real = new TextField();
        group = new CheckboxGroup();
        next = new Button();
        layout = new GridLayout(4, 1);
        digit = new Checkbox("", group, true);
        digitPoint = new Checkbox("", group, false);
    }

    public void dependencies(RealController controller, AppView appView) {
        this.controller = controller;
        this.appView = appView;
        output = appView.output;
    }
    
    @Override
    public void components() {
        setLayout(layout);
        add(digit);
        add(digitPoint);
        add(real);
        add(next);
    }

    @Override
    public void listeners() {
        digit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                controller.digit();
            }
        });

        digitPoint.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                controller.digitPoint();
            }
        });

        real.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.real();
            }
        });

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.next();
            }
        });
    }
    
}
