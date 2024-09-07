package org.example.engine.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.System.exit;

public class ComponentInitializer {
    public static MainFrame MainFrame() {
        var frame = new MainFrame();
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                    exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        return frame;
    }
}
