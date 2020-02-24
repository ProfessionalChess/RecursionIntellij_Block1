package BackTracking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private  final char wall = 'W';
    private  final char exit = 'x';
    private  final char open = '.';
    private  final char tried = '-';
    private  final char path = '+';
    private  char[][] map;
    private int row = 0;
    private int col = 0;
    public Maze(int row_, int col_){
        row = row_;
        col = col_;
        map = this.loadFile("F:\\CompSci30\\RecursionIntellij_Block1\\25x25Maze.txt");
    }

    public char[][] loadFile(String filename) {
        char map[][] = new char[row][col];
        String temp = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.ready()) {
                for (int i = 0; i < row; i++) {
                    temp = file.readLine();
                    map[i] = temp.toCharArray();
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    return map;
    }//end loadFile

    public void printAll(){
        for (int i = 0; i < map.length; i++) {
            if(i<10 && i != -1){
                System.out.print(" ");
            }
            System.out.print(i-1 + " ");
        }
        System.out.print("24");
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            if(i < 10){
                System.out.print(" ");
            }
                System.out.print(i + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(" " + map[i][j] + " ");
            }
            System.out.println();
        }
    }//end printAll

    public boolean findExitFrom (int row, int col){
        boolean successful = false;
        if(map[row][col] == exit){
            map[row][col] = path;
            successful = true;
        } else {
            map[row][col] = tried;
            //south
            if(map[row+1][col] == open || map[row+1][col] == exit){
                successful = findExitFrom(row+1, col);
            }
            //east
            if(!successful){
                if(map[row][col+1] == open || map[row][col+1] == exit){
                    successful = findExitFrom(row, col+1);
                }
            }
            //north
            if(!successful){
                if(map[row-1][col] == open || map[row-1][col] == exit){
                    successful = findExitFrom(row-1, col);
                }
            }
            //west
            if(!successful){
                if(map[row][col-1] == open || map[row][col-1] == exit){
                    successful = findExitFrom(row, col-1);
                }
            }
            if(successful){
                map[row][col] = path;
            }
        }
    return successful;
    }



}
