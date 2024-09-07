package org.example.engine.Graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainFrame() {
        GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .setFullScreenWindow(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
