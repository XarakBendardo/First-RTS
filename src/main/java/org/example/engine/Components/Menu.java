package org.example.engine.Components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private String[] optionsText;
    private JButton[] optionButtons;
    public Menu(final String[] optionsText, ActionListener[] optionListeners) {
        this.optionsText = optionsText;
        this.optionButtons = new JButton[this.optionsText.length];
        for(var i = 0; i < this.optionButtons.length; ++i) {
            this.optionButtons[i] = new JButton(this.optionsText[i]);
            this.optionButtons[i].addActionListener(optionListeners[i]);
            this.add(this.optionButtons[i]);
        }
    }
}
