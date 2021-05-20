import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener {
    int boardSize = 9;//9
    int mineCount = 10;//10
    int counterNotMine = boardSize*boardSize-mineCount;

    String level="Beginner";

    int rows = boardSize;//y;j
    int columns = boardSize;//x;i
    Cell[][] cellArray = new Cell[columns][rows];// From 0 to (boardSize-1)!!!




    public Board() {
        setMines();
        countNeighbouringMines();
        printArrayBoard();
        userInterface();


    }

    public void make2DArrayBoardFromCells() {
        //Didnt know how to return cellArray[i][j]

    }


    public void setMines() {
        int x;
        int y;
        boolean isMine = true;
        int currentMines = 0;


        //THIS MAKE 2D GRID (Array?)
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                cellArray[i][j] = new Cell();
            }
        }

        while (currentMines != mineCount) {
            x = (int) (Math.random() * columns);// returns a random integer from 0 to (boardSize-1)

            y = (int) Math.floor(Math.random() * rows);

            isMine = cellArray[x][y].isMine();
            cellArray[x][y].setContain("M");

            if (!isMine) {
                cellArray[x][y].setMine(true);
                currentMines++;
            }
        }
    }

    private void countNeighbouringMines() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (!cellArray[i][j].getContain().equals("M")) {
                    cellArray[i][j].setNeighbouringMines(counting(i,j));
                    cellArray[i][j].setContain(String.valueOf(cellArray[i][j].getNeighbouringMines()));
                }
            }
        }
    }

    private int counting(int x, int y) {
        int neighbours = 0;

        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){

                try {
                    if(cellArray[i][j].isMine())
                        neighbours++;
                } catch (Exception e) {
                    //I dont need lots of errors for not founding cells out of border
                }
            }
        }
        return neighbours;
    }

    public void printArrayBoard() {
        System.out.println("Contain");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(cellArray[i][j].getContain()+"\t");
            }
            System.out.println(" ");
        }
        /*System.out.println("MineCount");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(cellArray[i][j].getNeighbouringMines()+"\t");
            }
            System.out.println(" ");
        }
        System.out.println("IsItMine?");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(cellArray[i][j].isMine()+"\t");
            }
            System.out.println(" ");
        }*/

    }


    //----------GETTERS AND SETTERS--------------

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }


    //-------------USER INTERFACE---------------

    int cellSize = 50;

    JFrame frame = new JFrame("Minesweeper");
    JPanel cellPanel;
    JButton[][] cellButtons = new JButton[columns][boardSize];

    Font myFont = new Font("Arial", Font.PLAIN, 18);

    public void userInterface(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(cellSize *boardSize +20, cellSize * boardSize +50);
        frame.setLayout(null);
        frame.setResizable(false);


        cellPanel =new JPanel();
        cellPanel.setBounds(3,3,cellSize * boardSize, cellSize * boardSize);
        cellPanel.setBackground(Color.darkGray);
        cellPanel.setLayout(new GridLayout(boardSize,boardSize));

        for( int x=0 ; x<boardSize ; x++ ) {
            for( int y=0 ; y<boardSize ; y++ ) {

                cellButtons[x][y] = new JButton();
                cellButtons[x][y].setFont(myFont);
                cellButtons[x][y].setFocusable(false);
                cellButtons[x][y].setEnabled(true);
                cellButtons[x][y].addActionListener(this);
                cellPanel.add(cellButtons[x][y]);

            }
        }

        frame.add(cellPanel);
        frame.setVisible(true);

    }

    //-------------METHODS FOR CLICKING, WINNING, LOOSING----

    @Override
    public void actionPerformed(ActionEvent e) {
        for( int x=0 ; x<boardSize ; x++ ) {
            for( int y=0 ; y<boardSize ; y++ ) {

                if (e.getSource() == cellButtons[x][y]) {
                    showOneCellContain(x, y);
                    if (cellArray[x][y].isMine()){
                        showAllCellContain();
                        youLose();
                    } else
                        if (cellArray[x][y].getNeighbouringMines()==0){
                            showSafeField(x, y);
                        }
                        checkIfWon();


                }
            }
        }

    }

    private void showSafeField(int x, int y) {
        //flood fill algorithm
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){

                try {
                    if(!cellArray[i][j].isMine() && /* &&*/ !cellArray[i][j].isRevealed()){
                        showOneCellContain(i,j);
                        if (cellArray[i][j].getNeighbouringMines()==0){
                            showSafeField(i,j);

                        }

                    }
                                    } catch (Exception e) {
                    //I dont need lots of errors for not founding cells out of border

                }
            }
        }

    }

    private void checkIfWon() {

        if (counterNotMine==0){
            youWon();
        }
        System.out.println(counterNotMine);
    }

    public void showOneCellContain (int x, int y){
        cellButtons[x][y].setText(cellArray[x][y].getContain());
        cellButtons[x][y].setEnabled(false);
        cellArray[x][y].setRevealed(true);
        counterNotMine--;
    }
    public void showAllCellContain (){
        for( int x=0 ; x<boardSize ; x++ ) {
            for( int y=0 ; y<boardSize ; y++ ) {
                showOneCellContain(x, y);
            }
        }

    }
    public void youLose (){
        JOptionPane.showMessageDialog(frame, "BOOOM!!! \nYou lose!","You lose", JOptionPane.PLAIN_MESSAGE);

    }
    public void youWon (){
        JOptionPane.showMessageDialog(frame, "Congratulation!!! \nYou won!","You won", JOptionPane.PLAIN_MESSAGE);


    }


}
