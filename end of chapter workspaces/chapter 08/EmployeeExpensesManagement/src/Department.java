public class Department {

    private String name;
    private String managerName;

    public Department(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public String getName() {
        return name;
    }

    public String getManagerName() {
        return managerName;
    }
}
