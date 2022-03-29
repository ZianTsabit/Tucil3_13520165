public class Node {
    
    private Puzzle puzzle;
    private int cost;
    // buat ngitung cost

    public Node(){

        this.puzzle = new Puzzle();
        this.cost = 0;

    }

    public Node(Puzzle _puzzle){

        this.puzzle = _puzzle;
        this.cost = _puzzle.hitungCost();

    }


}
