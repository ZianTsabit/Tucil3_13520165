import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    private static int [][] buatRandomPuzzle(int xsize, int ysize){

        int [][] randomPuzzle = new int [xsize][ysize];

        Random rand = new Random();

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 16; ++i){
            list.add(i);
        }

        Collections.shuffle(list, rand);

        int counter = 0;

        for(int i = 0; i < xsize; i++){
            for(int j = 0; j < ysize; j++){

                randomPuzzle[i][j] = list.get(counter);
                counter++;

            }
        }

        return randomPuzzle;


    }
    public static void main(String args[]) throws FileNotFoundException{
        
        // banner
        System.out.println("##################################################################");
        System.out.println("#                                                                #");
        System.out.println("#      ____   ______                               __            #");
        System.out.println("#     |_   | |    __|    .-----.--.--.-----.-----.|  |.-----.    #");     
        System.out.println("#      _|  |_|__    |    |  _  |  |  |-- __|-- __||  ||  -__|    #");
        System.out.println("#     |______|______|    |   __|_____|_____|_____||__||_____|    #");
        System.out.println("#                        |__|                                    #");
        System.out.println("#                         __                                     #");
        System.out.println("#           .-----.-----.|  |.--.--.-----.----.                  #");     
        System.out.println("#           |__ --|  _  ||  ||  |  |  -__|   _|                  #");
        System.out.println("#           |_____|_____||__| \\___/|_____|__|                    #");
        System.out.println("#                                                                #");
        System.out.println("#          oleh : Ghazian Tsabit Alkamil / 13520165              #");
        System.out.println("#                                                                #");
        System.out.println("##################################################################");
        System.out.println();
        
        System.out.println("Selamat datang di 15 puzzle solver");
        System.out.println("Terdapat dua mode input puzzle : ");
        System.out.println("1. Input puzzle dari file");
        System.out.println("2. Gunakan random puzzle");
        System.out.println();
        System.out.print("Input mode pilihan Anda (1/2): ");
        Scanner sc = new Scanner(System.in);
        int opsi = sc.nextInt();

        String filename;

        if(opsi == 1){
            System.out.println("Mode input puzzle dari file dipilih !!!");
            System.out.print("Input filename: ");
            Scanner str = new Scanner(System.in);
            filename = str.nextLine();

            PuzzleLoader puzzleloader = new PuzzleLoader();
            Puzzle puzzle;

            int [][] correctPuzzle;
            int [][] puzzleToSolve;

            String testPath = "../test/";

            puzzleToSolve = puzzleloader.load(testPath+filename);
            correctPuzzle = buatCorrectPuzzle(puzzleToSolve.length, puzzleToSolve[0].length);

            puzzle = new Puzzle(puzzleToSolve, correctPuzzle);

            System.out.println("----------------- Puzzle To Solve ------------------");

            puzzle.printPuzzle();
            System.out.println();
            puzzle.kurang();
            System.out.println("Nilai dari KURANG(i) + X : " + puzzle.kurangI());
            System.out.println();

            if(!puzzle.isReachable()){
             
                System.out.println("Puzzle tidak dapat dipecahkan !!!");

            } else {

                System.out.println("----------------- Puzzle Movement ------------------");

                BnBSolver solver = new BnBSolver();
                Puzzle.DIRECTION[] gerakan = {Puzzle.DIRECTION.RIGHT, Puzzle.DIRECTION.LEFT, 
                Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP};
                long startTime = System.nanoTime();
                Puzzle solvedPuzzle = solver.solve(puzzle, gerakan);
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Waktu eksekusi program : " + totalTime/1000000 + " ms");

            }

        } else if(opsi == 2){
            
            System.out.println("Mode input random puzzle dipilih !!!");

            Puzzle puzzle;
            int [][] correctPuzzle;
            int [][] puzzleToSolve;

            puzzleToSolve = buatRandomPuzzle(4, 4);
            correctPuzzle = buatCorrectPuzzle(puzzleToSolve.length, puzzleToSolve[0].length);
            puzzle = new Puzzle(puzzleToSolve, correctPuzzle);

            System.out.println("----------------- Puzzle To Solve ------------------");

            puzzle.printPuzzle();
            System.out.println();
            System.out.println("Nilai dari KURANG(i) + X : " + puzzle.kurangI());

            if(!puzzle.isReachable()){
             
                System.out.println("Puzzle tidak dapat dipecahkan !!!");

            } else {

                System.out.println("----------------- Puzzle Movement ------------------");

                BnBSolver solver = new BnBSolver();
                Puzzle.DIRECTION[] gerakan = {Puzzle.DIRECTION.RIGHT, Puzzle.DIRECTION.LEFT, 
                Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP};
                long startTime = System.nanoTime();
                Puzzle solvedPuzzle = solver.solve(puzzle, gerakan);
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Waktu eksekusi program : " + totalTime/1000000 + " ms");
            }

        } else {
            System.out.print("Mode yang dipilih tidak valid !!!");
        }
    }
}
