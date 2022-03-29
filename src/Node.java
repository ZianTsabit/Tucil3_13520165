import java.io.FileNotFoundException;

public class Node implements Comparable<Node>{
    
    private Puzzle puzzle;
    private int cost;
    // buat ngitung cost

    public Node(){

        this.puzzle = new Puzzle();
        this.cost = 0;

    }

    public Node(String pathFile) throws FileNotFoundException{

        this.puzzle = new Puzzle(pathFile);
        this.cost = this.puzzle.hitungCost();

    }

    public Puzzle get_Puzzle(){
        return this.puzzle;
    }

    public int get_cost(){
        return this.cost;
    }

    public Node(Puzzle _puzzle){

        this.puzzle = _puzzle;
        this.cost = _puzzle.hitungCost();

    }

    public int compareTo(Node _node){

        if(this.get_cost() == _node.get_cost()){
            return 0;
        } else if(this.get_cost() > _node.get_cost()){
            return 1;
        } else {
            return -1;
        }

    }




}
