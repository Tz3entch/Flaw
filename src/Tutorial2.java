import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tutorial2 extends JFrame implements MouseListener {


    private JLabel exampleLabel;
    private JButton previous;
    private JButton back;
    private JTextArea text;
    private ImageIcon example;

    private JTable table;

    private String c = "Circle";
    private String s = "Star";

    public class MyRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(null);
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setText(String.valueOf(value));
            setHorizontalAlignment(JLabel.CENTER);
            if (row < 4) {
                setBackground(Color.cyan);
            }
            if (row >=4 && row < 8) {
                setBackground(Color.GREEN);
            }
            if (row >=8 && row < 12) {
                setBackground(Color.YELLOW);
            }
            if (row >=12 && row < 16) {
                setBackground(new Color(255, 21, 21, 196));
            }
            if (row >=16 && row < 20) {
                setBackground(Color.ORANGE);
            }

            return this;
        }

    }

    public static void main(String[] args) {
        new Tutorial2(new Point());
    }

    public Tutorial2 (Point p) {
        super("Flaw");
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        setLocation(p);

        text = new JTextArea("    There is 5 types of blocks: blue, green, yellow, red and orange. Each block with"+
                " different color combine figures in a different way.", 1, 10);
        text.setPreferredSize(new Dimension(850, 20));
        text.setLineWrap(true);
        text.setEditable(false);
        text.setWrapStyleWord(true);
        text.setBackground(getBackground());
        con.gridy =3;
        getContentPane().add(text, con);

        example = new ImageIcon(Level1.class.getResource("/images/example2.png"));
        exampleLabel = new JLabel(example);
        con.insets = new Insets(10, 0, 10, 0);
        con.gridy = 4;
        getContentPane().add(exampleLabel, con);

        String rowData[][] = {{c,c,c},{c,s,c},{s,c,c},{s,s,s}, {c,c,c},{c,s,s},{s,c,s},{s,s,s},
                {c,c,c},{c,s,s},{s,c,s},{s,s,c}, {c,c,s},{c,s,s},{s,c,s},{s,s,c}, {c,c,s},{c,s,c},{s,c,c},{s,s,c} };
        Object columnNames[] = {"Node 1", "Node 2", "Out node"};
        table = new JTable(rowData, columnNames);
        table.setFont(new Font("helvetica", Font.PLAIN, 12));
        for (int i = 0; i <3 ; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new MyRenderer());
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(600, 250));
        //con.insets = new Insets(0, 100, 0, 100);
        con.gridy =5;
        getContentPane().add(jsp, con);

        previous = new JButton("Previous");
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new Tutorial(p);
                dispose();
            }
        });
        con.insets = new Insets(30, 300, 5, 300);
        con.gridy = 6;
        getContentPane().add(previous, con);

        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = getLocation();
                new MainFrame(p);
                dispose();
            }
        });
        con.insets = new Insets(0, 300, 10, 300);
        con.gridy = 7;
        getContentPane().add(back, con);

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
