import logic.*;

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
public class Level3 extends JFrame implements MouseListener {


    private GreenBlock greenBlock = new GreenBlock();
    private BlueBlock blueBlock = new BlueBlock();
    private YellowBlock yellowBlock = new YellowBlock();
    private RedBlock redBlock = new RedBlock();
    private OrangeBlock orangeBlock = new OrangeBlock();

    private ImageIcon circle;
    private ImageIcon starGreen;
    private ImageIcon starRed;
    private ImageIcon circleGreen;
    private ImageIcon circleRed;
    private ImageIcon star;

    private boolean in11 = false;
    private boolean in12 = true;
    private boolean out1 = true;
    private boolean in22 = true;
    private boolean in32 = false;
    private boolean out2 = false;
    private boolean out3 = true;
    private boolean outFinal = true;
    private boolean outFinal2 = true;

    private JLabel in11Label;
    private JLabel in12Label;
    private JLabel out1Label;
    private JLabel in22Label;
    private JLabel in32Label;
    private JLabel out2Label;
    private JLabel out3Label;
    private JLabel outFinalLabel;
    private JLabel outFinalLabel2;
    private JLabel scoreLabel;

    private DefaultListModel listModel;
    private JList <String> comboList;
    private JScrollPane scrollPane;

    private int comboNum = 0;
    private int totalScore = 0;
    private int failNum;
    private List<boolean[]> validCombinations = new ArrayList<>();
    private boolean[] currentCombo = new boolean[4];

    public static void main(String[] args) {
        new Level3(new Point(), 0);
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

    public ImageIcon returnFinalIcon2 (boolean b) {
        if (b) {
            return circleGreen;
        }
        return starRed;
    }

    private void setOutputIcons () {
        if (!in12 && !in22) {
            in11Label.setVisible(true);
            in32Label.setVisible(true);
            out1Label.setVisible(true);
            out3Label.setVisible(true);
        }
        out1 = redBlock.combine(in11, in12);
        out1Label.setIcon(returnIcon(out1));
        //out2 = redBlock.combine(in12, in22);
        //out2Label.setIcon(returnFinalIcon(!out2));
        out3 = blueBlock.combine(in22, in32);
        out3Label.setIcon(returnIcon(out3));
        outFinal = greenBlock.combine(out1, out2);
        outFinalLabel.setIcon(returnFinalIcon(outFinal));
        outFinal2 = orangeBlock.combine(out2, out3);
        outFinalLabel2.setIcon(returnFinalIcon2(outFinal2));
        currentCombo[0] = in11;
        currentCombo[1] = in12;
        currentCombo[2] = in22;
        currentCombo[3] = in32;
        if ((!in12) && (!in22) && (!outFinal) && outFinal2 ) {
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
                comboNum++;
                if (failNum!=0) {
                    totalScore+= 100;
                } else {
                    totalScore+= 300;
                }
                failNum = 0;
                scoreLabel.setText("Total score: " + totalScore);
                listModel.addElement(comboNum +". "+comboToString(currentCombo.clone()));

                if(comboNum ==4) {
                    JOptionPane.showMessageDialog(null,"       Level 3 completed!","Congratulations!", 1);
                    JOptionPane.showMessageDialog(null,"       Total score: "+totalScore,"Game completed!", 1);
                    Point p = this.getLocation();
                    new MainFrame(p);
                    this.dispose();
                }
            }
        } else {
            failNum++;
            if (failNum>0) {
                if (totalScore>50) {
                    totalScore= totalScore - 50;
                } else {
                    totalScore = 0;
                }
                scoreLabel.setText("Total score: " + totalScore);
            }
        }
    }

    Level3(Point p, int totalScore) {
        super("Flaw");
        this.totalScore = totalScore;
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(p);

        setContentPane(new JLabel(new ImageIcon(Level3.class.getResource("/images/level3.png"))));

        circle = new ImageIcon(Level3.class.getResource("/images/circle.png"));
        starGreen = new ImageIcon(Level3.class.getResource("/images/star_green.png"));
        starRed = new ImageIcon(Level3.class.getResource("/images/star_red.png"));
        circleGreen = new ImageIcon(Level3.class.getResource("/images/circle_green.png"));
        circleRed = new ImageIcon(Level3.class.getResource("/images/circle_red.png"));
        star = new ImageIcon(Level3.class.getResource("/images/star.png"));

        in11Label = new JLabel(returnIcon(in11));
        in11Label.setBounds(80, 75, 30, 30);
        in11Label.addMouseListener(this);
        getContentPane().add(in11Label);
        in11Label.setVisible(false);

        in12Label = new JLabel(returnFinalIcon(in12));
        in12Label.setBounds(80, 145, 30, 30);
        in12Label.addMouseListener(this);
        getContentPane().add(in12Label);

        in22Label = new JLabel(returnFinalIcon(in22));
        in22Label.setBounds(80, 315, 30, 30);
        in22Label.addMouseListener(this);
        getContentPane().add(in22Label);

        in32Label = new JLabel(returnIcon(in32));
        in32Label.setBounds(80, 480, 30, 30);
        in32Label.addMouseListener(this);
        getContentPane().add(in32Label);
        in32Label.setVisible(false);

        out1 = redBlock.combine(in11, in12);
        out1Label = new JLabel(returnIcon(out1));
        out1Label.setBounds(425, 85, 30, 30);
        getContentPane().add(out1Label);
        out1Label.setVisible(false);

        //out2 = redBlock.combine(in12, in22);
        out2 = false;
        out2Label = new JLabel(new ImageIcon(Level3.class.getResource("/images/star_black.png")));
        out2Label.setBounds(425, 250, 30, 30);
        getContentPane().add(out2Label);

        out3 = blueBlock.combine(in22, in32);
        out3Label = new JLabel(returnIcon(out3));
        out3Label.setBounds(425, 420, 30, 30);
        getContentPane().add(out3Label);
        out3Label.setVisible(false);


        outFinal = greenBlock.combine(out1, out2);
        outFinalLabel = new JLabel(returnFinalIcon(outFinal));
        outFinalLabel.setBounds(790, 190, 30, 30);
        getContentPane().add(outFinalLabel);

        outFinal2 = orangeBlock.combine(out2, out3);
        outFinalLabel2 = new JLabel(returnFinalIcon2(outFinal2));
        outFinalLabel2.setBounds(790, 351, 30, 30);
        getContentPane().add(outFinalLabel2);

        scoreLabel = new JLabel("Total score: "+ totalScore);
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

        JOptionPane.showMessageDialog(null,"<html><body><p style='width: 400px;'>"+"Level 3 is similar to the level 2."
                +" Here the error is fixed to star or circle at the output of the gate. The player need to place the"+
                " suitable inputs to make corresponding to the errored output and the other inputs green and then play"
                +" with the other inputs to fix the output as green. The success of immediate attempt will double the"+
                " score and the failure will reduce the 10% of the score." +
                "</p></body></html>","Instructions for Level 3", 1);
    }



    public void mouseClicked(MouseEvent me) {
        // TODO Auto-generated method stub
        Object obj = me.getSource();
        if ( obj == in11Label){
            in11 = !in11;
            in11Label.setIcon(returnIcon(in11));
            setOutputIcons();
        }

        if ( obj == in12Label){
            in12 = !in12;
            in12Label.setIcon(returnFinalIcon(in12));
            setOutputIcons ();
        }

        if ( obj == in22Label){
            in22 = !in22;
            in22Label.setIcon(returnFinalIcon(in22));
            setOutputIcons ();
        }

        if ( obj == in32Label){
            in32 = !in32;
            in32Label.setIcon(returnIcon(in32));
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
