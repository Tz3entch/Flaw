import logic.BlueBlock;
import logic.GreenBlock;
import logic.YellowBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Level1 extends JFrame implements MouseListener {


    private GreenBlock greenBlock = new GreenBlock();
    private BlueBlock blueBlock = new BlueBlock();
    private YellowBlock yellowBlock = new YellowBlock();

    private ImageIcon circle;
    private ImageIcon circleGreen;
    private ImageIcon starRed;
    private ImageIcon star;

    private boolean in11 = false;
    private boolean in12 = true;
    private boolean out1 = true;
    private boolean in21 = false;
    private boolean in22 = true;
    private boolean out2 = false;
    private boolean out3 = true;

    private JLabel in11Label;
    private JLabel in12Label;
    private JLabel out1Label;
    private JLabel in21Label;
    private JLabel in22Label;
    private JLabel out2Label;
    private JLabel out3Label;
    private JLabel scoreLabel;

    private DefaultListModel listModel;
    private JList <String> comboList;
    private JScrollPane scrollPane;

    private int comboNum = 0;
    private int totalScore = 0;
    private int failNum = 0;
    private List<boolean[]> validCombinations = new ArrayList<>();
    private boolean[] currentCombo = new boolean[4];

    public static void main(String[] args) {
        new Level1(new Point());
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
            return circleGreen;
        }
        return starRed;
    }

    private void updateGameScreen() {
        out1 = blueBlock.combine(!in11, in12);
        out1Label.setIcon(returnIcon(out1));
        out2 = greenBlock.combine(in21, in22);
        out2Label.setIcon(returnIcon(out2));
        out3 = yellowBlock.combine(out1, out2);
        out3Label.setIcon(returnFinalIcon(out3));
        currentCombo[0] = in11;
        currentCombo[1] = in12;
        currentCombo[2] = in21;
        currentCombo[3] = in22;
        if (out3) {
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

                if(comboNum ==6) {
                    JOptionPane.showMessageDialog(null,"       Level 1 completed!","Congratulations!", 1);
                    Point p = this.getLocation();
                    new Level2(p, totalScore);
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

    Level1(Point p) {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(p);

        setContentPane(new JLabel(new ImageIcon(Level1.class.getResource("/images/level1.png"))));

        circle = new ImageIcon(Level1.class.getResource("/images/circle.png"));
        circleGreen = new ImageIcon(Level1.class.getResource("/images/circle_green.png"));
        starRed = new ImageIcon(Level1.class.getResource("/images/star_red.png"));
        star = new ImageIcon(Level1.class.getResource("/images/star.png"));

        in11Label = new JLabel(returnIcon(in11));
        in11Label.setBounds(80, 130, 30, 30);
        in11Label.addMouseListener(this);
        getContentPane().add(in11Label);

        in12Label = new JLabel(returnIcon(in12));
        in12Label.setBounds(80, 200, 30, 30);
        in12Label.addMouseListener(this);
        getContentPane().add(in12Label);

        in21Label = new JLabel(returnIcon(in21));
        in21Label.setBounds(80, 340, 30, 30);
        in21Label.addMouseListener(this);
        getContentPane().add(in21Label);

        in22Label = new JLabel(returnIcon(in22));
        in22Label.setBounds(80, 415, 30, 30);
        in22Label.addMouseListener(this);
        getContentPane().add(in22Label);

        out1 = blueBlock.combine(!in11, in12);
        out1Label = new JLabel(returnIcon(out1));
        out1Label.setBounds(420, 140, 30, 30);
        getContentPane().add(out1Label);

        out2 = greenBlock.combine(in11, in12);
        out2Label = new JLabel(returnIcon(out2));
        out2Label.setBounds(420, 350, 30, 30);
        getContentPane().add(out2Label);


        out3 = yellowBlock.combine(out1, out2);
        out3Label = new JLabel(returnFinalIcon(out3));
        out3Label.setBounds(780, 274, 30, 30);
        getContentPane().add(out3Label);

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

        JOptionPane.showMessageDialog(null,"<html><body><p style='width: 400px;'>"+"In this level the error is fixed and the output is fixed. The error "+
                "here is, when we give star it considers as circle and when we give circle it will consider as star."+
                " The player need to change the inputs  based on the block function. When the output is green the" +
                " combination is counted and if it is red  the player need to choose the other combination."+"" +
                "</p></body></html>","Instructions for Level 1", 1);


    }



    public void mouseClicked(MouseEvent me) {
        // TODO Auto-generated method stub
        Object obj = me.getSource();
        if ( obj == in11Label){
            in11 = !in11;
            in11Label.setIcon(returnIcon(in11));
            updateGameScreen();
        }

        if ( obj == in12Label){
            in12 = !in12;
            in12Label.setIcon(returnIcon(in12));
            updateGameScreen();
        }

        if ( obj == in21Label){
            in21 = !in21;
            in21Label.setIcon(returnIcon(in21));
            updateGameScreen();
        }

        if ( obj == in22Label){
            in22 = !in22;
            in22Label.setIcon(returnIcon(in22));
            updateGameScreen();

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
