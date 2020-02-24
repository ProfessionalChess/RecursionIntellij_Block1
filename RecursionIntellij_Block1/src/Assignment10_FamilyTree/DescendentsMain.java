package Assignment10_FamilyTree;
import java.util.Scanner;

public class DescendentsMain {
    public static int recursiveRuns1 = 0;
    public static int recursiveRuns2 = 0;
    public static int recursiveRuns3 = 0;
    public static Scanner wordscan = new Scanner(System.in);
    public static void main(String[] args) {
        //generation 0
        Person person1 = new Person("Bob", "male");
       //generation 1
        person1.addChild(new Person("Susan", "female"));
        person1.addChild(new Person("Jill", "female"));
        person1.addChild(new Person("Bob Jr", "male"));
       //generation 2
        person1.children.get(0).addChild(new Person("Zain", "male"));
        person1.children.get(2).addChild(new Person("Bob III", "male"));
        person1.children.get(2).addChild(new Person("Jasmine", "female"));
       //generation 3
        person1.children.get(0).children.get(0).addChild(new Person("Zain Jr", "male"));
        person1.children.get(0).children.get(0).addChild(new Person("Zainette", "male"));
        person1.children.get(2).children.get(0).addChild(new Person("Bob IV", "male"));
        person1.children.get(2).children.get(1).addChild(new Person("Zaiesha", "female"));
        person1.children.get(2).children.get(1).addChild(new Person("Steve", "male"));
        //Jill generations
        person1.children.get(1).addChild(new Person("Jill Jr", "male"));
        person1.children.get(1).children.get(0).addChild(new Person("Jill II", "male"));
        person1.children.get(1).children.get(0).addChild(new Person("Jillette", "female"));
        person1.children.get(1).children.get(0).children.get(0).addChild(new Person("Rick", "male"));
        person1.children.get(1).children.get(0).children.get(1).addChild(new Person("Jillette II", "female"));




        //start of assignment

        System.out.print("The number of people in " + person1.name + "'s family is ");
        //should get 17 - great it works
        System.out.println(countFamily(person1));
             System.out.println("Program complete.  The recursive function countFamily() ran " + recursiveRuns1 +" times");

        System.out.println("All females:");
        //should get 6 - great it works
        printFemales(person1);
        System.out.println("Program complete.  The recursive function printFemales() ran " + recursiveRuns2 +" times");


        //final percents
        System.out.println("Find Family by Name");
        String find = wordscan.nextLine();
        printFromHere(find, person1);
        System.out.println("Program complete.  The recursive function printFormHere() ran " + recursiveRuns3 +" times");
    }
    public static int countFamily(Person ptemp){
        recursiveRuns1++;
        int num = 0;
        if (ptemp.children.size() == 0){
            num++;
        }else if(ptemp.children.size() > 0){
            num++;
            for (int i = 0; i < ptemp.children.size(); i++) {
                num += countFamily(ptemp.children.get(i));
            }
        }
        return num;
    }
    public static void printFemales(Person ptemp){
        recursiveRuns2++;
        if (ptemp.children.size() == 0 && ptemp.gender.equalsIgnoreCase("female")){
            System.out.println(ptemp.name);
        }else if(ptemp.children.size() > 0){
            if(ptemp.gender.equalsIgnoreCase("female")){
                System.out.println(ptemp.name);
            }
            for (int i = 0; i < ptemp.children.size(); i++) {
                printFemales(ptemp.children.get(i));
            }
        }
    }


    public static void printFromHere(String nameToFind, Person ptemp){
        recursiveRuns3++;
        if(ptemp.name.equalsIgnoreCase(nameToFind)){

            System.out.println("There are/is " + countFamily(ptemp) + " people in " + nameToFind + "'s family");
        }  else if(ptemp.children.size()>0){
            for (int i = 0; i < ptemp.children.size(); i++) {
                printFromHere(nameToFind, ptemp.children.get(i));
            }
        }
    }
}
