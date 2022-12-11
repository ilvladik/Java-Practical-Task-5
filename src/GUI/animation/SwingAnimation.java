package GUI.animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SwingAnimation extends JFrame implements ActionListener {

    Timer timer;
    Image currentImage;
    int indexImage;
    File[] images;

    private SwingAnimation() {

        super("Animation");
        setSize(800, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        indexImage = 0;
        images = new File("src\\GUI\\animation\\resources\\").listFiles();

        timer = new Timer(30, this);
        timer.start();

        try {
            currentImage = ImageIO.read(images[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        g.drawImage(currentImage, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        indexImage++;
        if (indexImage == images.length) {
            indexImage = 0;
        }
        try {
            currentImage = ImageIO.read(images[indexImage]);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        repaint();
    }

    public static  void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SwingAnimation frame = new SwingAnimation();
            frame.setVisible(true);
        });
    }
}

