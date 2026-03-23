public class Scientist{
    private String scientistID;
    public String getScientistID() {
        return scientistID;
    }
    public void setScientistID(String scientistID) {
        this.scientistID = scientistID;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String projectIDs;
    public String getProjectID() {
        return projectIDs;
    }
    public void setProjectID(String projectID) {
        this.projectIDs = projectID;
    }
    public Scientist(String scientistID,String name,String projectIDs){
        this.scientistID=scientistID;
        this.name=name;
        this.projectIDs=projectIDs;
    }
    @Override
    public String toString() {
        return scientistID+":"+name+", project: "+projectIDs;
    }
}