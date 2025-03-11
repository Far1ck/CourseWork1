public class Employee {
    private static int idCounter = 1;
    private int id;
    private String fullName;
    private int department;
    private double salary;

    Employee() {
        fullName = null;
        department = -1;
        salary = -1.0;
        id = idCounter++;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return id * 29;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-37s %-5d %-10.2f\n", id, fullName, department, salary);
    }
}
