package GUI.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGame extends JFrame implements ActionListener {

    private final JLabel jResult;
    private final JLabel jLastSoccer;
    private final JLabel jWinner;
    private final String acMilan = "AC Milan";
    private final String realMadrid = "Real Madrid";
    private int scoreMilan = 0;
    private int scoreMadrid = 0;

    private SwingGame() {

        // создаётся новая рамка
        super("Game");

        // установливается диспетчер компоновки
        setLayout(new FlowLayout());

        // задаётся исходный размер рамки
        setSize(250, 150);

        // установливается правила завершения работы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // создание двух кнопок
        JButton jbtnMilan = new JButton(acMilan);
        JButton jbtnMadrid = new JButton(realMadrid);

        // добавление приемников событий от кнопок
        jbtnMilan.addActionListener(this);
        jbtnMadrid.addActionListener(this);

        // создаётся метка
        jResult = new JLabel("Result: 0 X 0");
        jLastSoccer = new JLabel("Last Scorer: N/A");
        jWinner = new JLabel("Winner: DRAW");

        // добавление кнопок на окно
        add(jbtnMilan);
        add(jbtnMadrid);

        // добавление меток на окно
        add(jResult);
        add(jLastSoccer);
        add(jWinner);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(acMilan)) {
            scoreMilan++;
            jLastSoccer.setText("Last Scorer: " + acMilan);
        }
        else {
            scoreMadrid++;
            jLastSoccer.setText("Last Scorer: " + realMadrid);
        }
        if (scoreMilan > scoreMadrid) {
            jWinner.setText("Winner: " + acMilan);
            jResult.setText("Result: " + scoreMilan + " X " + scoreMadrid);
        }
        else if (scoreMilan < scoreMadrid) {
            jWinner.setText("Winner: " + realMadrid);
            jResult.setText("Result: " + scoreMilan + " X " + scoreMadrid);
        }
        else {
            jWinner.setText("Winner: N/A");
            jResult.setText("Result: " + scoreMilan + " X " + scoreMadrid);
        }
    }

    public static  void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SwingGame frame = new SwingGame();
            frame.setVisible(true);
        });
    }
}
