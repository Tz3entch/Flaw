import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tutorial  extends JFrame implements MouseListener {

    private JLabel example1Label;
    private JLabel example2Label;
    private JLabel example3Label;
    private JButton next;
    private JButton back;
    private JTextArea text1;
    private JTextArea text2;
    private JTextArea text3;
    private ImageIcon example1;
    private ImageIcon example2;
    private ImageIcon example3;

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

//        label = new JLabel("Tutorial will be added soon!");
//        c.gridy = 1;
//        getContentPane().add(label, c);

        text1 = new JTextArea("    Flaw is a logic based figure placement game. Each level consists of blocks that combines"+
                " 2 or more figures (circle or star) into 1 figure. Correct figures have green color and incorrect have red. The goal of"+
                " the game is to find all ways to transform all red figures into green figures. Player can do that by"+
                " changing input figures "+ "on the left side of the screen. ", 3, 10);
        text1.setPreferredSize(new Dimension(750, 20));
        text1.setLineWrap(true);
        text1.setEditable(false);
        text1.setWrapStyleWord(true);
        text1.setBackground(getBackground());
        c.insets = new Insets(0, 0, 10, 0);
        c.gridy =1;
        getContentPane().add(text1, c);

        example1 = new ImageIcon(Level1.class.getResource("/images/example1.png"));
        example1Label = new JLabel(example1);
        c.insets = new Insets(20, 0, 10, 0);
        c.gridy = 2;
        getContentPane().add(example1Label, c);

        text3 = new JTextArea("    A cross on block's node means that star will change to circle and circle to star"+
                " when it pass through this node. Sometimes player can see black figures. Black figures are fixed and"+
                " player can't change it. Each time when player find a new way to make green all red figures, game saves" +
                " his inputs in the score screen as new correct combo and he gets a score depends on his previous combos."
                +" To complete a level, player need to find all possible correct combinations.", 4, 10);
        text3.setPreferredSize(new Dimension(850, 50));
        text3.setLineWrap(true);
        text3.setEditable(false);
        text3.setWrapStyleWord(true);
        text3.setBackground(getBackground());
        c.gridy =5;
        getContentPane().add(text3, c);

        example3 = new ImageIcon(Level1.class.getResource("/images/example3.png"));
        example3Label = new JLabel(example3);
        c.gridy = 6;
        getContentPane().add(example3Label, c);


        next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new Tutorial2(p);
                dispose();
            }
        });
        c.insets = new Insets(30, 300, 5, 300);
        c.gridy = 7;
        getContentPane().add(next, c);

        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new MainFrame(p);
                dispose();
            }
        });
        c.insets = new Insets(0, 300, 10, 300);
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
