
package Ex7;
public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        if (researchTopic == null || researchTopic.isEmpty() || supervisorName == null || supervisorName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null || researchTopic.isEmpty()) {
            throw new IllegalArgumentException("Invalid research topic");
        }
        this.researchTopic = researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName == null || supervisorName.isEmpty()) {
            throw new IllegalArgumentException("Invalid supervisor name");
        }
        this.supervisorName = supervisorName;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Supervisor Name: " + supervisorName);
    }
}

