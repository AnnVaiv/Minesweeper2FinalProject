import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener {
    /*int cellSize = 30;

    JFrame frame = new JFrame("Minesweeper");
    JPanel cellPanel;
    JButton[][] cellButtons = new JButton[3][3];

    Font myFont = new Font("Ink Free", Font.PLAIN, 30);

    public void userInterface(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(cellSize * 3 +20, cellSize * 3 +20+7);
        frame.setLayout(null);
        frame.setResizable(false);


        cellPanel =new JPanel();
        cellPanel.setBounds(0,20,cellSize * 3 +5, cellSize * 3 +7);
        cellPanel.setBackground(Color.pink);
        cellPanel.setLayout(new GridLayout(3,3));

        cellButtons[1][1] = new JButton("");
        cellButtons[1][1].setFocusable(false);
        cellButtons[1][1].setEnabled(true);
        cellButtons[1][1].addActionListener(this);
        cellPanel.add(cellButtons[1][1]);

        frame.add(cellPanel);
        frame.setVisible(true);




    }*/




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
