import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle {
    
    private int [][] puzzle;
    // private File inputFile;
    // private Node elements;
    
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
    }

    public void printPuzzle(){

        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4; j++){

                System.out.print(this.puzzle[i][j] + " ");
            
            }
            System.out.println();
        }

    }

    public int kurangI(){
        
        int kurangi = 0;
    
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                
                int current = this.puzzle[i][j];

                for(int m = 0; m < 4; m++){
                    for(int n = 0; n < 4; n++){

                        if(n > j && this.puzzle[m][n] < current){
                            kurangi++;
        
                        }     
                    }
                }
            }
        }
        return kurangi;
    }

    public Boolean isReachable(int KurangI){

        if(KurangI % 2 == 0){
            return true;
        } else {
            return false;
        }

    }




}