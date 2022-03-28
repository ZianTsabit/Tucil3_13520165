import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String args[]) throws FileNotFoundException{

        Puzzle puzzle1 = new Puzzle("../test/test_01.txt");

        puzzle1.printPuzzle();

        int kurangI = puzzle1.kurangI();
        System.out.println("Kurang(i) dari puzzle ini adalah : " + kurangI);

    }


}
