import javax.swing.*;
import java.awt.*;

public class Main extends JOptionPane{
    public static void main(String[] args) {

        startGame();

    }

    private static void startGame() {
        /*Level selectedLevel =new Level();
        Object[] options = {"Beginner", "Intermediate", "Advanced"};
        int n = JOptionPane.showOptionDialog(null, "Choose your difficulty:", "Difficulty",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        if (n==0){
            selectedLevel.level = "Beginner";
            selectedLevel.boardSize = 9;
            selectedLevel.mineCount = 10;
        }
        if (n==1){
            selectedLevel.level = "Intermediate";
            selectedLevel.boardSize = 16;
            selectedLevel.mineCount = 40;
        }
        if (n==2){
            selectedLevel.level = "Advanced";
            selectedLevel.boardSize = 24;
            selectedLevel.mineCount = 99;
        }
        System.out.println("Selected difficulty:" + selectedLevel.getLevel() + "  size:" + selectedLevel.getBoardSize() + "  mines:" + selectedLevel.getMineCount());
*/

        Board board = new Board();
    }
}
