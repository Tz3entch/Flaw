import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Сережа on 03.04.2016.
 */
public class MainFrame extends JFrame implements MouseListener {

    private JButton play;
    private JButton tutorial;
    private JButton exit;
    private JLabel title;


    public MainFrame (Point p) {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(p);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;


        title = new JLabel("FLAW");
        title.setFont(new Font("helevtica",Font.ROMAN_BASELINE,80));
        title.setForeground(Color.BLUE);
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(0, 0, 30, 0);
        c.gridy = 1;
        getContentPane().add(title, c );

        play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new Level1(p);
                dispose();
            }
        });
        c.insets = new Insets(0, 0, 10, 0);
        c.gridy = 2;
        getContentPane().add(play, c);

        tutorial = new JButton("Tutorial");
        tutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new Tutorial(p);
                dispose();
            }
        });
        c.insets = new Insets(0, 0, 10, 0);
        c.gridy = 3;
        getContentPane().add(tutorial, c);

        exit = new JButton("Exit");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        c.insets = new Insets(0, 0, 50, 0);
        c.gridy = 4;
        getContentPane().add(exit, c);



        //pack();

        setVisible(true);
    }

    public static void main(String [] args) {
        new MainFrame(new Point());
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
