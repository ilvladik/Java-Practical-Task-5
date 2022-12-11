package GUI.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class SwingPaint extends JFrame {

    private final int width = 500;
    private final int height = 500;

    private SwingPaint() {

        super("Paint");

        setSize(width, height);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        for (int i = 0; i < 20; i++) {
            int x = (int)(Math.random() * 3);
            g.setColor(new Color((int)(Math.random() * 0x1000000)));
            switch (x) {
                case 0 -> {
                    Line2D line2D = new Line2D.Float(randomCoord(), randomCoord(),
                            randomCoord(), randomCoord());
                    g.fill(line2D);
                }
                case 1 -> {
                    Rectangle2D rectangle2D = new Rectangle2D.Float(randomCoord(), randomCoord(),
                            randomCoord(), randomCoord());
                    g.fill(rectangle2D);
                }
                case 2 -> {
                    Ellipse2D ellipse2D = new Ellipse2D.Float(randomCoord(), randomCoord(),
                            randomCoord(), randomCoord());
                    g.fill(ellipse2D);
                }
            }
        }
    }

    private float randomCoord() {
        return (float)Math.random() * width / 2;
    }

    public static  void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SwingPaint frame = new SwingPaint();
            frame.setVisible(true);
        });
    }
}
