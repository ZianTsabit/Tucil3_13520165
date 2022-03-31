import java.util.PriorityQueue;

public class BnBSolver {
    
    private final PriorityQueue<Puzzle> frontiers = new PriorityQueue<Puzzle>(new PuzzleComparator());

    public Puzzle solve(Puzzle puzzleToSolve, Puzzle.DIRECTION[] gerakan){

        frontiers.add(puzzleToSolve);

        while(!frontiers.isEmpty()){

            Puzzle puzzle = frontiers.poll();
            puzzle.printPuzzle();
            System.out.println(puzzle.get_cost());
            System.out.println();

            if(puzzle.isSolved()){
                return puzzle;
            }

            for(int i = 0; i < gerakan.length; i++){

                if(puzzle.canMove(gerakan[i])) {
                    Puzzle newPuzzle = new Puzzle(puzzle);

                    newPuzzle.move(gerakan[i]);
                    frontiers.add(newPuzzle);

                }
            }
        }
        return null;
    }  


    



}
