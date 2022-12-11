package GUI.image;

import javax.swing.*;
import java.awt.*;

public class SwingImage extends JFrame {

    private SwingImage(String path) {

        // создаётся новая рамка
        super("Image");

        // установливается диспетчер компоновки
        setLayout(new FlowLayout());

        // задаётся исходный размер рамки
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        // установливается правила завершения работы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlb = new JLabel();
        jlb.setIcon(new ImageIcon(path));

        add(jlb);
    }

    public static  void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SwingImage frame = new SwingImage("src\\GUI\\image\\resources\\foto.jpg");
            frame.setVisible(true);
        });
    }
}
