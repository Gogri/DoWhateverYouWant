
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Person {
    private String name;
    private String email;
    private int id;
    private String target;
    
    //Creates a Person from a name and email
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        id = (int)(Math.random() * 1000);
        target = "";
    }
    
    /*//Creates a Person from a name, email, id, and target
    public Person(String name, String email, int id, String target) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.target = target;
    }*/
    
    /*//Creates a person from a name, email, and target
    public Person(String name, String email, String target) {
        this.name = name;
        this.email = email;
        id = (int)(Math.random() * 1000);
        this.target = target;
    }*/
    
    //Sets the target of the Person object from another Person
    public void setTarget(Person other) {
        target += other.getName();
    }
    
    //Sets the target of the Preson object from a name
    public void setTarget(String target) {
        this.target = target;
    }
    
    //Returns Person's target
    public String getTarget() {
        return target;
    }
    
    //Returns Person's name;
    public String getName() {
        return name;
    }
    
    //Returns namecode for comparison
    public String getNameCode() {
        String n = "";
        for  (int i = 0; i < name.length(); i++) {
           if (name.charAt(i) != ' ') {
                 n += name.charAt(i);
           }
        }
        return n.toLowerCase();
    }
    
    //Reterns Person's email
    public String getEmail() {
        return email;
    }
    
    //Returns Person without target
    public String toStringNoTarget() {
        String s = name + "\t" + email + "\t" + id;
        return s;
    }
    
    //Return Person as a String
    public String toString(){
        String s = name + "\t" + email + "\t" + id + "\t" + target;
        return s;
    }
}
