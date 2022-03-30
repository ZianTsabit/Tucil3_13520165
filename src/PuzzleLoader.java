import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PuzzleLoader {

    public int[][] load(String pathFile) throws FileNotFoundException{

        int [][] puzzle;

        puzzle = new int[4][4];

        Scanner sc = new Scanner(new BufferedReader(new FileReader(pathFile)));
    
        while(sc.hasNextLine()) {
            for (int i=0; i<puzzle.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    puzzle[i][j] = Integer.parseInt(line[j]);
                }
            }
        }

        return puzzle;
    }
}
