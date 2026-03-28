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
                    input.nextLine();
                    System.out.print("Please enter the name of the scientist to search for\n> ");
                    System.out.println(formatScientist(searchScientist(input.nextLine())));
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
    private static String formatScientist(Scientist scientist) {
        // TODO Auto-generated method stub
        // format to none found if null
        throw new UnsupportedOperationException("Unimplemented method 'formatScientist'");
    }
    private static void removeScientist() {
        System.out.println("Please enter the name of the scientist to remove");// TODO
        boolean succesfulRemoval=true;
        try {
            scientists.remove(searchScientist(input.nextLine()));
        } catch (Exception e) {
            succesfulRemoval=false;
        }
        if(succesfulRemoval)System.out.println("Scientist succesfully removed");
        else System.out.println("No such scientist found...");
    }
    private static void removeProject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProject'");
    }
    private static Scientist searchScientist(String scientistID) {
        // TODO Auto-generated method stub
        // return null if none found
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    private static void displayInfo() {
        System.out.println("Scientists:");
        for(Scientist scientist:scientists){
            System.out.println("\t"+formatScientist(scientist));
        }
        System.out.println("\nProjects:");
        for(Project project:projects){
            System.out.println("\t"+project);
        }
    }
    private static void createProject() {
        input.nextLine();
        System.out.print("Please enter the project name\n> ");
        String name=input.nextLine();
        String ID="";
        boolean gettingID=true;
        while(gettingID){
            System.out.print("Please enter the project's ID\n> ");
            String tempID=input.next();
            if(!existingProject(tempID))ID=tempID;
            else System.out.println("Invalid ID: duplicate");
        }
        projects.add(new Project(ID, name));
        System.out.println("Project created:\n"+projects.getLast());
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
            else System.out.println("Invalid ID: duplicate");
        }
        System.out.print("Please enter the number of projects the scientist has picked up\n> ");
        String projectIDs="";
        for(int i=0;i<input.nextInt();++i){
            System.out.print("Please enter the project's ID\n> ");
            String tempID=input.next();
            if(existingProject(tempID))projectIDs+=tempID+";";
            else --i;
        }
        scientists.add(new Scientist(ID, name, projectIDs));
        System.out.println("Scientist added:\n"+scientists.getLast());
    }
    private static boolean existingProject(String ID){
        boolean exists=false;
        for(Project project:projects){
            if(project.getProjectID().equals(ID)){
                exists=true;
                break;
            }
        }
        return exists;
    }
}