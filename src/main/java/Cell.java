public class Cell {
    private boolean mine;
    private int neighbouringMines;

    private String contain;//M - mined; 0-8 - number of neighbouring mines   THIS IS WHAT WILL BE SHOWN TO PLAYER

    private boolean revealed;

    public Cell() {
        mine=false;
        neighbouringMines=0;
        contain="";
        revealed=false;

    }



//----------GETTERS AND SETTERS--------------

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public int getNeighbouringMines() {
        return neighbouringMines;
    }

    public void setNeighbouringMines(int neighbouringMines) {
        this.neighbouringMines = neighbouringMines;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
