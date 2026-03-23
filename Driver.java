import java.util.ArrayList;
import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean running=true;
        ArrayList<Scientist> scientists=new ArrayList<>();
        ArrayList<Project> projects=new ArrayList<>();
        while(running){
            System.out.print("Please select an option\n1. Create project\n2. Add scientist\n3. Show all info\n4. Search for a scientist\n5. Remove project\n6. Remove scientist\n7. quit\n> ");
        }
    }
}