public class Game {
    int boardSize = 9;//9
    int mineCount = 10;//10

    int rows = boardSize;//y;j
    int columns = boardSize;//x;i
    Cell[][] cellArray = new Cell[columns][rows];// From 0 to 2(boardSize-1)!!!

    public Game() {
        setMines();
        countNeighbouringMines();
        printArrayBoard();


    }

    public void make2DArrayBoardFromCells() {

    }


    public void setMines() {
        int x;
        int y;
        boolean isMine = true;
        int currentMines = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                cellArray[i][j] = new Cell();
            }
        }

        while (currentMines != mineCount) {
            x = (int) (Math.random() * columns);// returns a random integer from 0 to 2 (boardSize-1)

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
                if (cellArray[i][j].getContain().equals(".")) {
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

                }

                /* }*/


            }
        }
        //System.out.println(neighbours);
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
        System.out.println("MineCount");
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
        }

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




}
