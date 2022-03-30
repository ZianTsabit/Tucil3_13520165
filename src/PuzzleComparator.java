import java.util.Comparator;

public class PuzzleComparator implements Comparator<Puzzle>{

    @Override
    public int compare(Puzzle p1, Puzzle p2) {
        if(p1.get_cost() < p2.get_cost()){
            return 1;
        } else if(p1.get_cost() > p2.get_cost()){
            return -1;
        } else {
            return 0;
        }
    }
}
