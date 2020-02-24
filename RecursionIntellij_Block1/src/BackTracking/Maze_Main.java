package BackTracking;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Maze_Main {
    public static Scanner numscan = new Scanner(System.in);

    public static void main(String[] args) {
        Maze mapCurrent = new Maze(25, 25);
        mapCurrent.printAll();
        System.out.println("Enter Row to start from, Good Luck");
        int row = numscan.nextInt();
        System.out.println("Enter Col to start from, Good Luck");
        int col = numscan.nextInt();
        mapCurrent.findExitFrom(row, col);
        mapCurrent.printAll();
    }//end main
}//end main
