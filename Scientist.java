public class Scientist{
    private String scientistID;
    private String name;
    private String projectIDs;
    public Scientist(String scientistID,String name,String projectIDs){
        this.scientistID=scientistID;
        this.name=name;
        this.projectIDs=projectIDs;
    }
    public String getScientistID() {
        return scientistID;
    }
    public void setScientistID(String scientistID) {
        this.scientistID = scientistID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProjectID() {
        return projectIDs;
    }
    public void setProjectID(String projectID) {
        this.projectIDs = projectID;
    }
    @Override
    public String toString() {
        return scientistID+": "+name+", on projects\n"+projectIDs;
    }
}