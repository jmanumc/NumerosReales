package gui.components;

import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;

public class MyTextArea extends TextArea {
    private Font font;

    public MyTextArea(String text) {
        super(text);

        font = new Font("Medium Text", Font.ITALIC, 16);

        setFont(font);
        // setBackground(Color.WHITE);
    }
}
