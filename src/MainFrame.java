import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
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
        setLayout(new SpringLayout());
        play = new JButton("Play");
        play.setPreferredSize(new Dimension(100, 50));
        getContentPane().add(play);
        tutorial = new JButton("Tutorial");
        tutorial.setPreferredSize(new Dimension(100, 50));
        getContentPane().add(tutorial);

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
