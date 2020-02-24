
import java.util.Scanner;

public class Assign4_Couprinacci {


    public static Scanner numscan = new Scanner(System.in);
    public static int times = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Generate which term number?");
            int find = numscan.nextInt();
            System.out.println("Term #" + find + " is " + coupSequence(find));
            System.out.println("Times repeated is " + times);
            times = 0;
        }
    }

    public static int coupSequence(int num) {
        times++;
        if (num <= 1) {
            return 3;
        } else if (num == 2) {
            return 5;
        } else if (num == 3) {
            return 8;
        } else {
            return (coupSequence(num - 1) + coupSequence(num - 2) + coupSequence(num - 3));
        }
    }
}
