package layout;

public class Projects {

    String nameProject;
    String descriptionProject;
    int imgProject;

    public Projects() {
    }

    public Projects(String nameProject, String descriptionProject, int imgProject){
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.imgProject = imgProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public int getImgProject() {
        return imgProject;
    }

    public void setImgProject(int imgProject) {
        this.imgProject = imgProject;
    }
}
