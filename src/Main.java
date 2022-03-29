import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Main {
    
    static int [] finalState = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    public static void main(String args[]) throws FileNotFoundException{

        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node puzzle1 = new Node("../test/test_01.txt");

        pq.add(puzzle1);

        Node first = new Node();
        first = pq.remove();

        first.get_Puzzle().printPuzzle();
        
        

    }


}
