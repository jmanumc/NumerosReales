package views;

import java.awt.Panel;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import controllers.DecimalsController;

public class DecimalsView extends PanelView {

    public Panel actions;
    public TextArea output;
    public TextField decimal;
    public GridLayout layout;
    public CheckboxGroup group;
    public Button reset, finalize;
    public Checkbox digit, digitDecimals;
    public DecimalsController controller;

    public DecimalsView() {
        finalize = new Button();
        decimal = new TextField();
        group = new CheckboxGroup();
        layout = new GridLayout(4, 2);
        digit = new Checkbox("", group, false);
        actions = new Panel(new GridLayout(1, 2));
        digitDecimals = new Checkbox("", group, true);
    }

    public void dependencies(DecimalsController controller, AppView appView, SidebarView sidebarView) {
        this.controller = controller;
        output = appView.output;
        reset = sidebarView.reset;
    }
    
    @Override
    public void components() {
        actions.add(finalize);
        actions.add(reset);

        setLayout(layout);
        add(digitDecimals);
        add(digit);
        add(decimal);
        add(actions);
    }

    @Override
    public void listeners() {
        digitDecimals.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                controller.digitDecimals();
            }
        });

        digit.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                controller.digit();
            }
        });

        decimal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.decimal();
            }
        });

        finalize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.finalize();
            }
        });
    }
    
}
