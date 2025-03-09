public class EmployeeBook {
    private Employee[] employees;

    EmployeeBook() {
        employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
        }
    }

    EmployeeBook(int maxNumberOfEmployees) {
        if (maxNumberOfEmployees < 0) {
            throw new IllegalArgumentException("Некорректно указан максимальный размер книги");
        }
        employees = new Employee[maxNumberOfEmployees];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Employee employee : employees) {
            if (employee.getFullName() != null || employee.getDepartment() != -1 || employee.getSalary() != -1.0) {
                result.append(employee.toString());
            }
        }
        return result.toString();
    }

    public double getSalaryCostsPerMonth() {
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getMinWageEmployee() {
        int minSal = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() != -1.0) {
                minSal = i;
                break;
            }
        }
        if (minSal == -1) {
            return null;
        }
        for (int i = minSal + 1; i < employees.length; i++) {
            if (employees[i].getSalary() != -1.0 && employees[i].getSalary() < employees[minSal].getSalary()) {
                minSal = i;
            }
        }
        return employees[minSal];
    }

    public Employee getMaxWageEmployee() {
        int maxSalIndex = -1;
        double maxSal = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() != -1.0 && employees[i].getSalary() > maxSal) {
                maxSal = employees[i].getSalary();
                maxSalIndex = i;
            }
        }
        if (maxSalIndex == -1) {
            return null;
        }
        return employees[maxSalIndex];
    }

    public double getAverageSalary() {
        int count = 0;
        double sum = 0;
        for (Employee i : employees) {
            if (i.getSalary() != -1) {
                count++;
                sum += i.getSalary();
            }
        }
        return sum / count;
    }

    public void getListOfAllFullNames() {
        System.out.println("\nФИО всех сотрудников: ");
        for (Employee employee : employees) {
            if (employee.getFullName() != null || employee.getDepartment() != -1 || employee.getSalary() != -1.0) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexSalary(double percentage) {
        if (percentage < -100) {
            return;
        }
        double indexCoefficient = (100 + percentage) / 100;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1) {
                employee.setSalary(employee.getSalary() * indexCoefficient);
            }
        }
    }

    public Employee getMinWageEmployeeInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        int minSal = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                minSal = i;
                break;
            }
            if (i == employees.length - 1 && minSal == -1) {
                return null;
            }
        }
        for (int i = minSal + 1; i < employees.length; i++) {
            if (employees[i].getDepartment() == department
                    && employees[i].getSalary() != -1.0
                    && employees[i].getSalary() < employees[minSal].getSalary()) {
                minSal = i;
            }
        }
        return employees[minSal];
    }

    public Employee getMaxWageEmployeeInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        int maxSal = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                maxSal = i;
                break;
            }
            if (i == employees.length - 1 && maxSal == -1) {
                return null;
            }
        }
        for (int i = maxSal + 1; i < employees.length; i++) {
            if (employees[i].getDepartment() == department
                    && employees[i].getSalary() != -1.0
                    && employees[i].getSalary() > employees[maxSal].getSalary()) {
                maxSal = i;
            }
        }
        return employees[maxSal];
    }

    public double getSalaryCostsPerMonthInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double getAverageSalaryInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        int count = 0;
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1 && employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public void indexSalaryInTheDepartment(int department, double percentage) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        if (percentage < -100) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        double indexCoefficient = (100 + percentage) / 100;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1 && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * indexCoefficient);
            }
        }
    }

    public void printAllEmployeesInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.printf("%-5d %-37s %-10.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printAllEmployeesWithSalaryLessThanTheNumber(double number) {
        for (Employee employee : employees) {
            if (employee.getSalary() != -1 && employee.getSalary() < number) {
                System.out.printf("%-5d %-37s %-10.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public void printAllEmployeesWithSalaryGreaterThanTheNumber(double number) {
        for (Employee employee : employees) {
            if (employee.getSalary() != -1 && employee.getSalary() >= number) {
                System.out.printf("%-5d %-37s %-10.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public boolean addNewEmployee(String fullName, int department, double salary) {
        if (fullName == null || department < 1 || department > 5 || salary < 0) {
            throw new IllegalArgumentException("Некорректные данные сотрудника");
        }
        boolean result = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName() == null
                    && employees[i].getDepartment() == -1
                    && employees[i].getSalary() == -1.0) {
                employees[i].setFullName(fullName);
                employees[i].setDepartment(department);
                employees[i].setSalary(salary);
                result = true;
                break;
            }
        }
        return result;
    }

    public void deleteEmployee(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("ID не может быть меньше 1");
        }
        employees[id - 1].setFullName(null);
        employees[id - 1].setDepartment(-1);
        employees[id - 1].setSalary(-1.0);
    }

    public Employee getEmployeeById(int id) {
        return employees[id - 1];
    }
}
