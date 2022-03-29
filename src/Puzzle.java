import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle {
    
    private int [][] puzzle;
    private int [] content;
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

                if(this.puzzle[i][j] == 16){
                    System.out.print("-" + " ");
                } else {
                    System.out.print(this.puzzle[i][j] + " ");
                }
                
            }
            System.out.println();
        }

    }

    // Udah bener
    public int kurangI(){
        
        int kurangi = 0;
        this.content = new int[16];
        int k = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.content[k] = this.puzzle[i][j]; 
                k++;   
            }
        }

        for(int i = 0; i < this.content.length; i++){
            for(int j = 0; j < i ; j++){
                if(this.content[j] > this.content[i]){
                    kurangi++;
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

    public void slideUp(){

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
    }

    public void slideDown(){

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
    }

    public void slideRight(){
        
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
        
    }

    public void slideLeft(){

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
        
    }




}