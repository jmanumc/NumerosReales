package views;

import java.awt.Panel;
import controllers.Controller;

public abstract class PanelView extends Panel implements View {

    public void launch() {
        components();
        listeners();
    }

}
