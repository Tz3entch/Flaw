import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tutorial  extends JFrame implements MouseListener {

    private JButton back;
    private JTextArea text1;
    private JLabel blueLabel;
    private JLabel greenLabel;
    private JLabel redLabel;
    private JLabel yellowLabel;
    private JLabel orangeLabel;

    public static void main(String[] args) {
        new Tutorial(new Point());
    }

    public Tutorial(Point p) {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        setLocation(p);

        text1 = new JTextArea("    This game is used to find the test vectors of the complicated circuits with the"+
                " help of the path sensitization algorithm. This game contains three levels.\n" +
                " Before going starting, player should know function of the each block. ", 3, 10);
        text1.setPreferredSize(new Dimension(750, 20));
        text1.setLineWrap(true);
        text1.setEditable(false);
        text1.setWrapStyleWord(true);
        text1.setBackground(getBackground());
        c.insets = new Insets(0, 50, 30, 0);
        c.gridy =1;
        getContentPane().add(text1, c);

        blueLabel = new JLabel("Blue Block: The output is star only when all inputs is star.");
        blueLabel.setForeground(Color.blue);
        c.insets = new Insets(0, 300, 20, 300);
        c.gridy = 3;
        getContentPane().add(blueLabel, c);

        greenLabel = new JLabel("Green Block: Output is circle only when all inputs are circle.");
        greenLabel.setForeground(new Color(20, 128, 20));
        c.gridy = 4;
        getContentPane().add(greenLabel, c);

        redLabel = new JLabel("Red Block: The output is circle only when all inputs are star.");
        redLabel.setForeground(Color.red);
        c.gridy = 5;
        getContentPane().add(redLabel, c);

        yellowLabel = new JLabel("Yellow Block: When all inputs are same the output is circle.");
        yellowLabel.setForeground(new Color(198, 166, 25));
        c.gridy = 6;
        getContentPane().add(yellowLabel, c);

        orangeLabel = new JLabel("Orange Block: The output is star only when all inputs are circle.");
        orangeLabel.setForeground(new Color(198, 95, 34, 254));
        c.gridy = 7;
        getContentPane().add(orangeLabel, c);


        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new MainFrame(p);
                dispose();
            }
        });
        c.insets = new Insets(10, 300, 10, 300);
        c.gridy = 8;
        getContentPane().add(back, c);

        setVisible(true);

    }


    public void mouseClicked(MouseEvent me) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
