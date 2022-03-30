import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.util.PriorityQueue;

public class Main {
    
    private static int [][] buatCorrectPuzzle(int xsize, int ysize){

        int [][] correctPuzzle = new int [xsize][ysize];

        int counter = 1;

        for(int i = 0; i < xsize; i++){
            for(int j = 0; j < ysize; j++){

                correctPuzzle[i][j] = counter;
                counter++;

            }
        }

        return correctPuzzle;

    }
    public static void main(String args[]) throws FileNotFoundException{

        PuzzleLoader puzzleloader = new PuzzleLoader();
        Puzzle puzzle;

        int [][] correctPuzzle;
        int [][] puzzleToSolve;

        puzzleToSolve = puzzleloader.load("../test/test_01.txt");
        
        correctPuzzle = buatCorrectPuzzle(puzzleToSolve.length, puzzleToSolve[0].length);

        puzzle = new Puzzle(puzzleToSolve, correctPuzzle);

        System.out.println("----------------- BEFORE ------------------");

        puzzle.printPuzzle();

        

        System.out.println("----------------- AFTER ------------------");

        BnBSolver solver = new BnBSolver();
        Puzzle.DIRECTION[] gerakan = {Puzzle.DIRECTION.RIGHT, Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP};

        Puzzle solvedPuzzle = solver.solve(puzzle, gerakan);

        solvedPuzzle.printPuzzle();
        


    }


}
