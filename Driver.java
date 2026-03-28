import java.util.ArrayList;
import java.util.Scanner;
public class Driver{
    private static ArrayList<Scientist> scientists=new ArrayList<>();
    private static ArrayList<Project> projects=new ArrayList<>();
    private static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        boolean running=true;
        while(running){
            System.out.print("\nPlease select an option\n1. Create project\n2. Add scientist\n3. Show all info\n4. Search for a scientist\n5. Remove project\n6. Remove scientist\n7. quit\n");
            if(scientists.isEmpty())System.out.println("<!> No scientists registered yet...");
            if(projects.isEmpty())System.out.println("<!> No projects registered yet...");
            System.out.print("> ");
            switch (input.nextInt()) {
                case 1:
                    createProject();
                    break;
                case 2:
                    if(projects.isEmpty()){
                        System.out.println("Please create a project first...");
                        break;
                    }
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
        if(scientist==null)return "Invalid scientist...";
        Scanner scientistInfo=new Scanner(scientist.toString());
        String formattedScientist=scientistInfo.nextLine()+":\n";
        Scanner projectsInfo=new Scanner(scientistInfo.nextLine()).useDelimiter(";");
        scientistInfo.close();
        while (projectsInfo.hasNext()) {
            formattedScientist+="\t\t"+searchProject(projectsInfo.next()).toString();
        }
        projectsInfo.close();
        return formattedScientist;
    }
    private static Project searchProject(String projectName) {
        for (Project project : projects) {
            if(project.getName().equals(projectName))return project;
        }
        return null;
    }
    private static void removeScientist() {
        input.nextLine();
        boolean succesfulRemoval=true;
        try {
            System.out.print("Please enter the name of the scientist to remove\n> ");
            scientists.remove(searchScientist(input.nextLine()));
        } catch (Exception e) {
            succesfulRemoval=false;
        }
        if(succesfulRemoval)System.out.println("Scientist succesfully removed");
        else System.out.println("No such scientist found...");
    }
    private static void removeProject() {
        input.nextLine();
        boolean succesfulRemoval=true;
        System.out.print("Please enter the name of the project to remove\n> ");
        Project project=searchProject(input.nextLine());
        if(project==null)succesfulRemoval=false;
        else projects.remove(project);
        if(succesfulRemoval)System.out.println("Project succesfully removed");
        else System.out.println("No such project found...");
    }
    private static Scientist searchScientist(String scientistName) {
        for(Scientist scientist:scientists){
            if(scientist.getName().equals(scientistName))return scientist;
        }
        return null;
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
            if(!existingProject(tempID)){
                ID=tempID;
                gettingID=false;
            }
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
            if(valid){
                ID=tempID;
                gettingID=false;
            }
            else System.out.println("Invalid ID: duplicate");
        }
        System.out.print("Please enter the number of projects the scientist has picked up\n> ");
        String projectIDs="";
        int nbProjects=input.nextInt();
        for(int i=0;i<nbProjects;++i){
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