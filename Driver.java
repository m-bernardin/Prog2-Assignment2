import java.util.ArrayList;
import java.util.Scanner;
public class Driver{
    private static ArrayList<Scientist> scientists=new ArrayList<>();
    private static ArrayList<Project> projects=new ArrayList<>();
    private static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        boolean running=true;
        while(running){
            System.out.print("Please select an option\n1. Create project\n2. Add scientist\n3. Show all info\n4. Search for a scientist\n5. Remove project\n6. Remove scientist\n7. quit");
            if(scientists.isEmpty())System.out.println("No scientists registered yet...");
            if(projects.isEmpty())System.out.println("No projects registered yet...");
            switch (input.nextInt()) {
                case 1:
                    createProject();
                    break;
                case 2:
                    addScientist();
                    break;
                case 3:
                    displayInfo();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    removeProject();
                    break;
                case 6:
                    removeScientist();
                    break;
                case 7:
                    input.close();
                    running=false;
                    System.out.println("goodbye :)");
                    break;
                default:
                    System.out.println("Please input a valid option...");
                    break;
            }
        }
    }
    private static void removeScientist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeScientist'");
    }
    private static void removeProject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProject'");
    }
    private static void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    private static void displayInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayInfo'");
    }
    private static void createProject() {
        input.nextLine();
        System.out.print("Please entwe the project name\n> ");
    }
    private static void addScientist(){
        input.nextLine();
        System.out.print("Please enter the scientis's name\n> ");
        String name=input.nextLine();
        String ID="";
        boolean gettingID=true;
        while(gettingID){
            System.out.print("Please enter the scientist ID\n> ");
            boolean valid=true;
            String tempID=input.next();
            for(Scientist scientist:scientists){
                if(scientist.getScientistID().equals(tempID)){
                    valid=false;
                    break;
                }
            }
            if(valid)ID=tempID;
            else System.out.println("Invalid ID; duplicate");
        }


        System.out.print("Please enter the number of projects the scientist has picked up\n> ");
        String projectIDs="";
        for(int i=0;i<input.nextInt();++i){
            System.out.print("Please enter the project's ID\n> ");
            projectIDs+=input.next()+";";
        }
        scientists.add(new Scientist(ID, name, projectIDs));
    }
}