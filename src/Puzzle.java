import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Puzzle {
    
    private int [][] puzzle;
    private int [] currentState;
    // private Node elements;
    
    public Puzzle(){

        this.puzzle = new int[4][4];
        
        this.currentState = new int[16];

    }

    public Puzzle(String pathFile) throws FileNotFoundException{

        this.puzzle = new int[4][4];

        Scanner sc = new Scanner(new BufferedReader(new FileReader(pathFile)));
    
        while(sc.hasNextLine()) {
            for (int i=0; i<this.puzzle.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    puzzle[i][j] = Integer.parseInt(line[j]);
                }
            }
        }

        this.updateCurrentState();

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

    public void updateCurrentState() {

        this.currentState = new int[16];
        int k = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.currentState[k] = this.puzzle[i][j]; 
                k++;   
            }
        }


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

    public Puzzle slideUp(){

        Puzzle newPuzzle = new Puzzle();

        Boolean done = false; 

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4 ; j++){

                if(this.puzzle[i][j] == 16 && i != 3){
                    int temp;
                    int e1 = this.puzzle[i+1][j];
                    int blank = this.puzzle[i][j];
                    temp = e1;
                    this.puzzle[i+1][j] = blank;
                    this.puzzle[i][j] = temp;
                    done = true;
                    break;
                }   
            }
            if(done){
                break;
            }
        }

        this.updateCurrentState();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                newPuzzle.puzzle[i][j] = this.puzzle[i][j]; 

            }
        }

        newPuzzle.updateCurrentState();

        return newPuzzle;
    }

    public Puzzle slideDown(){

        Puzzle newPuzzle = new Puzzle();

        Boolean done = false; 

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4 ; j++){
                
                if(this.puzzle[i][j] == 16 && i != 0){
                    int temp;
                    int e1 = this.puzzle[i-1][j];
                    int blank = this.puzzle[i][j];
                    temp = e1;
                    this.puzzle[i-1][j] = blank;
                    this.puzzle[i][j] = temp;
                    done = true;
                    break;
                }
                
            }
            if(done){
                break;
            }
        }

        this.updateCurrentState();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                newPuzzle.puzzle[i][j] = this.puzzle[i][j]; 

            }
        }

        newPuzzle.updateCurrentState();

        return newPuzzle;
    }

    public Puzzle slideRight(){
        
        Puzzle newPuzzle = new Puzzle();

        Boolean done = false;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4 ; j++){
                
                if(this.puzzle[i][j] == 16 && j != 0){
                    int temp;
                    int e1 = this.puzzle[i][j-1];
                    int blank = this.puzzle[i][j];
                    temp = e1;
                    this.puzzle[i][j-1] = blank;
                    this.puzzle[i][j] = temp;
                    done = true;
                    break;
                }
                
            }
            if(done){
                break;
            }
        }

        this.updateCurrentState();
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                newPuzzle.puzzle[i][j] = this.puzzle[i][j]; 

            }
        }

        newPuzzle.updateCurrentState();

        return newPuzzle;
    }

    public Puzzle slideLeft(){

        Puzzle newPuzzle = new Puzzle();

        Boolean done = false;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4 ; j++){
                
                if(this.puzzle[i][j] == 16 && j != 3){
                    int temp;
                    int e1 = this.puzzle[i][j+1];
                    int blank = this.puzzle[i][j];
                    temp = e1;
                    this.puzzle[i][j+1] = blank;
                    this.puzzle[i][j] = temp;
                    done = true;
                    break;
                }
                
            }
            if(done){
                break;
            }
        }
        
        this.updateCurrentState();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){

                newPuzzle.puzzle[i][j] = this.puzzle[i][j]; 

            }
        }

        newPuzzle.updateCurrentState();

        return newPuzzle;

    }

    // untuk debugging
    public void printCurrentState() {

        for(int i = 0; i < 16 ; i++){
            System.out.print(this.currentState[i] + " ");
            
        }
        System.out.println();
    }

    public int hitungCost(){

        int gP = 0;

        for(int i = 0; i < 16; i++){

            if(this.currentState[i] != i+1){
                gP++;
            }

        }
        return gP;
    }

    public int get_x_blank(){

        int x = -1;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.puzzle[i][j] == 16){
                    x = i;
                }
            }
        }
        return x;
    }

    public int get_y_blank(){

        int y = -1;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(this.puzzle[i][j] == 16){
                    y = j;
                }
            }
        }
        return y;
    }
}

