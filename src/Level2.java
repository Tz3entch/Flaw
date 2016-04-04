import logic.BlueBlock;
import logic.GreenBlock;
import logic.RedBlock;
import logic.YellowBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ������ on 22.03.2016.
 */
public class Level2 extends JFrame implements MouseListener {


    private GreenBlock greenBlock = new GreenBlock();
    private BlueBlock blueBlock = new BlueBlock();
    private YellowBlock yellowBlock = new YellowBlock();
    private RedBlock redBlock = new RedBlock();

    private ImageIcon circle;
    private ImageIcon starGreen;
    private ImageIcon starRed;
    private ImageIcon circleGreen;
    private ImageIcon circleRed;
    private ImageIcon star;

    private boolean in11 = false;
    private boolean in12 = true;
    private boolean out1 = true;
    private boolean in21 = true;
    private boolean in22 = false;
    private boolean out2 = true;
    private boolean out3 = true;
    private boolean outFinal = true;

    private JLabel in11Label;
    private JLabel in12Label;
    private JLabel out1Label;
    private JLabel in21Label;
    private JLabel in22Label;
    private JLabel out2Label;
    private JLabel out3Label;
    private JLabel outFinalLabel;
    private JLabel scoreLabel;

    private DefaultListModel listModel;
    private JList <String> comboList;
    private JScrollPane scrollPane;

    private int score = 0;
    private List<boolean[]> validCombinations = new ArrayList<>();
    private boolean[] currentCombo = new boolean[4];

    public static void main(String[] args) {
        new Level2(new Point());
    }

    public String comboToString (boolean[] combo) {
        String result = "";
        for (int i = 0; i < combo.length ; i++) {
            if (combo[i]) {
                result+="o";
            } else {
                result+="*";
            }
        }
        return result;
    }

    public ImageIcon returnIcon (boolean b) {
        if (b) {
            return circle;
        }
        return star;
    }

    public ImageIcon returnFinalIcon (boolean b) {
        if (b) {
            return circleRed;
        }
        return starGreen;
    }

    private void setOutputIcons () {
        out1 = blueBlock.combine(!in11, in12);
        out1Label.setIcon(returnIcon(out1));
        out2 = blueBlock.combine(in21, in22);
        out2Label.setIcon(returnIcon(out2));
        out3 = redBlock.combine(in22, in12);
        out3Label.setIcon(returnIcon(out3));
        outFinal = greenBlock.combine(out1, out2, out3);
        outFinalLabel.setIcon(returnFinalIcon(outFinal));
        currentCombo[0] = in11;
        currentCombo[1] = in12;
        currentCombo[2] = in21;
        currentCombo[3] = in22;
        if (!outFinal&&!in12) {
            boolean flag = true;
            if (!validCombinations.isEmpty()) {
                for (boolean[] validCombination : validCombinations) {
                    if (Arrays.equals(currentCombo, validCombination)) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                validCombinations.add(currentCombo.clone());
                score++;
                scoreLabel.setText("Total score: " + score*100);
                listModel.addElement(score+". "+comboToString(currentCombo.clone()));

                if(score==3) {
                    JOptionPane.showMessageDialog(null,"       Level 2 completed!","Congratulations!", 1);
                    Point p = this.getLocation();
                    new Level3(p);
                    this.dispose();
                }
            }
        }
    }

    Level2(Point p) {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(p);

        setContentPane(new JLabel(new ImageIcon(Level2.class.getResource("/images/level2.png"))));

        circle = new ImageIcon(Level3.class.getResource("/images/circle.png"));
        starGreen = new ImageIcon(Level3.class.getResource("/images/star_green.png"));
        starRed = new ImageIcon(Level3.class.getResource("/images/star_red.png"));
        circleGreen = new ImageIcon(Level3.class.getResource("/images/circle_green.png"));
        circleRed = new ImageIcon(Level3.class.getResource("/images/circle_red.png"));
        star = new ImageIcon(Level3.class.getResource("/images/star.png"));

        in11Label = new JLabel(new ImageIcon(Level2.class.getResource("/images/star_black.png")));
        in11Label.setBounds(80, 75, 30, 30);
        in11Label.addMouseListener(this);
        getContentPane().add(in11Label);

        in12Label = new JLabel(returnFinalIcon(in12));
        in12Label.setBounds(80, 145, 30, 30);
        in12Label.addMouseListener(this);
        getContentPane().add(in12Label);

        in21Label = new JLabel(returnIcon(in21));
        in21Label.setBounds(80, 240, 30, 30);
        in21Label.addMouseListener(this);
        getContentPane().add(in21Label);

        in22Label = new JLabel(returnIcon(in22));
        in22Label.setBounds(80, 315, 30, 30);
        in22Label.addMouseListener(this);
        getContentPane().add(in22Label);

        out1 = blueBlock.combine(!in11, in12);
        out1Label = new JLabel(returnIcon(out1));
        out1Label.setBounds(420, 85, 30, 30);
        getContentPane().add(out1Label);

        out2 = blueBlock.combine(in21, in22);
        out2Label = new JLabel(returnIcon(out2));
        out2Label.setBounds(420, 250, 30, 30);
        getContentPane().add(out2Label);

        out3 = redBlock.combine(in22, in12);
        out3Label = new JLabel(returnIcon(out3));
        out3Label.setBounds(420, 420, 30, 30);
        getContentPane().add(out3Label);


        outFinal = greenBlock.combine(out1, out2, out3);
        outFinalLabel = new JLabel(returnFinalIcon(outFinal));
        outFinalLabel.setBounds(780, 274, 30, 30);
        getContentPane().add(outFinalLabel);

        scoreLabel = new JLabel("Total score: "+ score*100);
        scoreLabel.setBounds(720, 30, 100, 30);
        getContentPane().add(scoreLabel);

        listModel = new DefaultListModel();
        comboList = new JList<>(listModel);
        comboList.setBounds(720, 60, 100, 100);
        scrollPane = new JScrollPane(comboList);
        scrollPane.setBounds(720, 60, 100, 100);
       // listModel.addElement("**oo");
        getContentPane().add(scrollPane);



        setVisible(true);
    }



    public void mouseClicked(MouseEvent me) {
        // TODO Auto-generated method stub
        Object obj = me.getSource();
//        if ( obj == in11Label){
//            in11 = !in11;
//            in11Label.setIcon(returnIcon(in11));
//            setOutputIcons();
//        }

        if ( obj == in12Label){
            in12 = !in12;
            in12Label.setIcon(returnFinalIcon(in12));
            setOutputIcons ();
        }

        if ( obj == in21Label){
            in21 = !in21;
            in21Label.setIcon(returnIcon(in21));
            setOutputIcons ();
        }

        if ( obj == in22Label){
            in22 = !in22;
            in22Label.setIcon(returnIcon(in22));
            setOutputIcons ();

        }



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
