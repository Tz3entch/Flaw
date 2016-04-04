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
    private JLabel title;


    public MainFrame () {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;




        play = new JButton("Play");
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setVerticalAlignment(SwingConstants.CENTER);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new Level1(p);
                dispose();
            }
        });
        c.insets = new Insets(0, 5, 0, 5);

        getContentPane().add(play, c);

        tutorial = new JButton("Tutorial");
        tutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.gridx = 50;
        c.gridy = 0;
        getContentPane().add(tutorial, c);


        //pack();

        setVisible(true);
    }

    public static void main(String [] args) {
        new MainFrame();
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
