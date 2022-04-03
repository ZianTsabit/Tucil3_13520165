import java.util.PriorityQueue;

public class BnBSolver {
    
    private final PriorityQueue<Puzzle> frontiers = new PriorityQueue<Puzzle>(new PuzzleComparator());

    public Puzzle solve(Puzzle puzzleToSolve, Puzzle.DIRECTION[] gerakan){

        frontiers.add(puzzleToSolve);

        int r_to_root = 0;
        int size = 1;
        
        while(!frontiers.isEmpty()){

            Puzzle puzzle = frontiers.poll();
            r_to_root++;
            puzzle.printPuzzle();
            System.out.println("Cost simpul saat ini : " + puzzle.get_cost());
            System.out.println();



            if(puzzle.isSolved()){
                System.out.println("Jumlah simpul yang dibangkitkan : " + size);
                return puzzle;
            }

            for(int i = 0; i < gerakan.length; i++){

                if(puzzle.canMove(gerakan[i])) {
                    Puzzle newPuzzle = new Puzzle(puzzle);

                    newPuzzle.move(gerakan[i]);
                    newPuzzle.add_cost(r_to_root);
                    frontiers.add(newPuzzle);
                    size++;

                }
            }
        }
        return null;
    }  


    



}
