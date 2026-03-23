public class Project{
    public String getProjectID() {
        return projectID;
    }
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    private String projectID;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    public Project(String projectID,String name){
        this.projectID=projectID;
        this.name=name;
    }
    @Override
    public String toString() {
        return projectID+":"+name;
    }
}