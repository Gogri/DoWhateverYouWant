    
/**
 * This is the interface for the Senior Assassin program. 
 * It accepts a list of names and emails of the participants and a list of the names of those who have been elimonated(optional).
 * From these lists, it creates a NameList object and assignes targets to the participants.
 *  
 * @Ali Marsh and Shalin Gogri
 * @5/12
 */
import java.util.*;
import java.io.*;
public class Run {
    public static void main(String[] args) throws FileNotFoundException{
  
        //Creates input files and Scanner objects that use them
        File names = new File("names.txt");
        File dead = new File("dead.txt");
        Scanner deadNames;
        Scanner input = new Scanner(names);
        
        //Creates output files and PrintStream objects that use them
        File aa = new File("AssasinAssignments.txt");
        File ra = new File("killersLeft.txt");
        File mailList = new File("mailList.txt");
        PrintStream output = new PrintStream(aa);
        PrintStream output2 = new PrintStream(ra);
        PrintStream printMail = new PrintStream(mailList);
        
        //Introduction
        System.out.println("Running Senior Assasin 2017");
        System.out.println("This program reads a file with the original names and email and a file of the names of those who have been killed");
        System.out.println("It will produce a list of those still alive, an assignment list, and an email list");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
        
        //Creates an ArrayList of Person objects from the input data
        ArrayList<Person> nList = new ArrayList<Person>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] data = line.split("\t");
            String name = data[0] + " " + data[1];
            String email = data[2];
            nList.add(new Person(name, email));
        } 
        
        //Removes dead people from nList if there are any
        ArrayList<String> deadList = new ArrayList<String>();
        if (dead.exists()) {
            deadNames = new Scanner(dead);
            while(deadNames.hasNextLine()) {
                String n = "";
                String name = deadNames.nextLine();
                for  (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) != ' ') {
                        n += name.charAt(i);
                    }
                }
                deadList.add(n.toLowerCase());
            }
            for (int i = 0; i < deadList.size(); i++) {
                boolean found = false;
                int j = 0;
                while (!found && j < nList.size()) {
                    if (nList.get(j).getNameCode().equalsIgnoreCase(deadList.get(i))) {
                        nList.remove(j);
                        found = true;
                    } else {
                        j++;
                    }
                }
                if (!found) {
                    System.out.println(deadList.get(i) + " not found");
                }
            }
        }
        
        //Createsa NameList from nList, randomizes it, assignes targets, and sorts it
        NameList nameList = new NameList(nList);
        nameList.scramble();
        nameList.match();
        nameList.mergeSort();
        
        //Prints to the output files
        output.println("Number:\tAssasin:\tEmail:\t\t\tID:\tTarget:");
        output.print(nameList.toString());
        output2.println(nameList.toStringNames());
        printMail.println(nameList.toStringEmails());
        
        //Prints when done
        System.out.println("completed"); 
    } 
}
  
