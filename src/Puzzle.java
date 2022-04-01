import java.util.Arrays;

public class Puzzle {
    
    public enum DIRECTION {UP, DOWN, LEFT, RIGHT}

    private final int [][] puzzle;
    private int [][] correctPuzzle;
    private int cost;
    private int blankX, blankY;
    // private Node elements;
    
    public Puzzle(){

        this.puzzle = new int[4][4];
        
    }

    public Puzzle(int[][] puzzle, int[][] correctPuzzle) {
        this.puzzle = puzzle;
        this.correctPuzzle = correctPuzzle;
        
        this.cost = hitung_cost(puzzle);

        this.get_x_blank();
        this.get_y_blank();
    }

    public Puzzle(Puzzle newPuzzle) {
        puzzle = new int[newPuzzle.puzzle.length][newPuzzle.puzzle[0].length];
        
        for (int i = 0; i < puzzle.length; i++) {
            puzzle[i] = Arrays.copyOf(newPuzzle.puzzle[i], puzzle[i].length);
        }
        correctPuzzle = newPuzzle.correctPuzzle;
        blankX = newPuzzle.blankX;
        blankY = newPuzzle.blankY;

        this.cost = hitung_cost(newPuzzle);
    }

    public void printPuzzle() { 

        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4; j++){

                if(this.puzzle[i][j] == 16){
                    System.out.print("-" + " ");
                } else {
                    System.out.print(this.puzzle[i][j] + " ");
                }
                
            }
            System.out.println();
        }

    }

    public void setTile(int x, int y, int tile){
        this.puzzle[x][y] = tile;
    }

    public int getTile(int x, int y){
        return this.puzzle[x][y];
    }

    public void swap(int x1, int y1, int x2, int y2){

        int previous = getTile(x1, y1);

        setTile(x1, y1, getTile(x2, y2));

        setTile(x2, y2, previous);
        blankY = y2;
        blankX = x2;
    }

    public void move(DIRECTION direction) {
        
        switch (direction) {
            case UP:
                swap(blankX, blankY, (blankX - 1), blankY);
                
                break;
            case DOWN:
                swap(blankX, blankY, (blankX + 1), blankY);
                
                break;
            case LEFT:
                swap(blankX, blankY, blankX, (blankY - 1));
                
                break;
            case RIGHT:
                swap(blankX, blankY, blankX, (blankY + 1));
                
                break;
        }
        this.set_cost(hitung_cost(this.puzzle));
    }

    public boolean canMove(DIRECTION direction) {
        switch (direction) {
            case UP:
                if (blankX != 0) {
                    return true;
                }
                break;
            case DOWN:
                if (blankX != puzzle.length - 1) {
                    return true;
                }
                break;
            case LEFT:
                if (blankY != 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (blankY != puzzle[blankX].length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean isSolved() {
        for (int y = 0; y < puzzle.length; ++y) {
            for (int x = 0; x < puzzle[y].length; ++x) {
                if (puzzle[y][x] != correctPuzzle[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
    // Udah bener
    public int kurangI(){
        
        int kurangi = 0;
        int [] content = new int[16];
        int k = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                content[k] = this.puzzle[i][j]; 
                k++;   
            }
        }

        for(int i = 0; i < content.length; i++){
            for(int j = 0; j < i ; j++){
                if(content[j] > content[i]){
                    kurangi++;
                }
            }
        }

        int X = 0;

        if(content[1] == 16 || content[3] == 16 || content[4] == 16 || content[6] == 16 
        || content[9] == 16 || content[11] == 16 || content[12] == 16|| content[14] == 16){
            X = 1;
        }
        
        return kurangi + X;
    }

    public Boolean isReachable(){

        if(this.kurangI() % 2 == 0){
            return true;
        } else {
            return false;
        }

    }

    public int hitung_cost(int [][] puzzle){

        int gP = 0;

        int [][] final_state = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                if(puzzle[i][j] != 16){
                    if(puzzle[i][j] != final_state[i][j]){
                        gP++;
                    }
                }
                
            }
        }

        return gP;
    }

    public int hitung_cost(Puzzle puzzle){

        int gP = 0;

        int [][] final_state = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                if(puzzle.getTile(i, j) != 16){
                    if(puzzle.getTile(i, j) != final_state[i][j]){
                        gP++;
                    }
                }
            }
        } 
        return gP;
    }

    public int get_cost(){

        return this.cost;

    }

    public void add_cost(int c){
        this.cost = this.cost + c;
    }

    public void set_cost(int _cost){
        this.cost = _cost;
    }

    public void get_x_blank(){

        int x = -1;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.puzzle[i][j] == 16){
                    x = i;
                }
            }
        }
        this.blankX = x;
    }

    public void get_y_blank(){

        int y = -1;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.puzzle[i][j] == 16){
                    y = j;
                }
            }
        }
        this.blankY =  y;
    }

}

