package gui;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mnemosyne");
        setMinimumSize(new Dimension(800, 600));
    }
}
