package Assignment10_FamilyTree;

import java.util.ArrayList;

public class Person {
    public String name;
    public String gender;
    public ArrayList <Person> children = new ArrayList();
    
    public Person(String n, String g){
        name = n;
        gender = g;
    }
    public void addChild (Person p){
        children.add(p);
        
    }
    
}
