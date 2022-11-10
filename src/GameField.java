import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.ImageIcon;

public class GameField extends JFrame implements ActionListener {
    Timer timer = new Timer(1000, this);
    static int count = 0;
    static ImageIcon back = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("back.jpg")));
    static ImageIcon red = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("red.jpg")));
    static ImageIcon yellow = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("yellow.jpg")));
    static ImageIcon green = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("green.jpg")));
    static ImageIcon stop = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("wait.jpg")));
    static ImageIcon ready = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("ready.jpg")));
    static ImageIcon go = new ImageIcon(Objects.requireNonNull(GameField.class.getClassLoader().getResource("go.jpg")));
    static JLayeredPane layeredPane = new JLayeredPane();
    static JLabel background = new JLabel(back, JLabel.CENTER);
    static JLabel labelRed = new JLabel(red, JLabel.CENTER);
    static JLabel labelYellow = new JLabel(yellow, JLabel.CENTER);
    static JLabel labelGreen = new JLabel(green, JLabel.CENTER);
    static JLabel redStop = new JLabel(stop, JLabel.CENTER);
    static JLabel yellowReady = new JLabel(ready, JLabel.CENTER);
    static JLabel greenGo = new JLabel(go, JLabel.CENTER);

    static JFrame frame = new JFrame("Traffic Lights");

    GameField() {
        initComponent();
        timer.start();
    }

    void initComponent() {
        background.setOpaque(false);
        background.setBounds(0, 0, 1280, 720);
        background.setVisible(false);

        labelRed.setOpaque(false);
        labelRed.setBounds(0, 0, 1280, 720);
        labelRed.setVisible(false);

        labelYellow.setOpaque(false);
        labelYellow.setBounds(0, 0, 1280, 720);
        labelYellow.setVisible(false);

        labelGreen.setOpaque(false);
        labelGreen.setBounds(0, 0, 1280, 720);
        labelGreen.setVisible(false);

        greenGo.setBounds(200, 515, 300, 50);
        greenGo.setVisible(false);
        greenGo.setBackground(Color.DARK_GRAY);

        redStop.setBounds(200, 115, 300, 50);
        redStop.setVisible(false);
        redStop.setOpaque(true);

        yellowReady.setBounds(200, 330, 300, 50);
        yellowReady.setVisible(false);
        yellowReady.setBackground(Color.DARK_GRAY);

        layeredPane.setBounds(0, 0, 1280, 720);
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1280, 720));
        frame.setLayout(null);
        frame.setVisible(true);

        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(labelRed, Integer.valueOf(0));
        layeredPane.add(labelYellow, Integer.valueOf(0));
        layeredPane.add(labelGreen, Integer.valueOf(0));

        layeredPane.add(greenGo, Integer.valueOf(1));
        layeredPane.add(yellowReady, Integer.valueOf(1));
        layeredPane.add(redStop, Integer.valueOf(1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if (count >= 0 && count <= 10 && count != 7 && count != 9) {
            System.out.println("red");
            background.setVisible(false);
            labelRed.setVisible(true);
            labelGreen.setVisible(false);
            labelYellow.setVisible(false);
            greenGo.setVisible(false);
            yellowReady.setVisible(false);
            redStop.setVisible(true);
        } else if (count >= 11 && count < 14) {
            background.setVisible(false);
            labelRed.setVisible(false);
            labelGreen.setVisible(false);
            labelYellow.setVisible(true);
            greenGo.setVisible(false);
            yellowReady.setVisible(true);
            redStop.setVisible(false);
            System.out.println("yellow");
        } else if (count >= 14 && count < 25 && count != 21 && count != 23) {
            background.setVisible(false);
            labelRed.setVisible(false);
            labelGreen.setVisible(true);
            labelYellow.setVisible(false);
            greenGo.setVisible(true);
            yellowReady.setVisible(false);
            redStop.setVisible(false);
            System.out.println("green");
        } else if (count >= 25 && count < 28) {
            background.setVisible(false);
            labelRed.setVisible(false);
            labelGreen.setVisible(false);
            labelYellow.setVisible(true);
            greenGo.setVisible(false);
            yellowReady.setVisible(true);
            redStop.setVisible(false);
            System.out.println("yellow");
        } else if (count >= 28) {
            count = 0;
        } else if (count == 7 || count == 9) {
            background.setVisible(true);
            labelRed.setVisible(false);
            labelGreen.setVisible(false);
            labelYellow.setVisible(false);
            greenGo.setVisible(false);
            yellowReady.setVisible(false);
            redStop.setVisible(false);
            System.out.println("back");
        } else if (count == 21 || count == 23) {
            background.setVisible(true);
            labelRed.setVisible(false);
            labelGreen.setVisible(false);
            labelYellow.setVisible(false);
            greenGo.setVisible(false);
            yellowReady.setVisible(false);
            redStop.setVisible(false);
            System.out.println("back");
        }
    }
}


