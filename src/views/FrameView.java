package views;

import java.awt.Frame;
import controllers.Controller;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public abstract class FrameView extends Frame implements View {

    public void launch() {
        components();
        listeners();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
