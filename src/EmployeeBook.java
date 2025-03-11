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
        Employee result = null;
        double minSal = 999_999_999_999.0;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1.0 && employee.getSalary() < minSal) {
                minSal = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public Employee getMaxWageEmployee() {
        Employee result = null;
        double maxSal = -1;
        for (Employee employee : employees) {
            if (employee.getSalary() != -1.0 && employee.getSalary() > maxSal) {
                maxSal = employee.getSalary();
                result = employee;
            }
        }
        return result;
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
        Employee result = null;
        double minSal = 999_999_999_999.0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department
                    && employee.getSalary() != -1.0
                    && employee.getSalary() < minSal) {
                minSal = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public Employee getMaxWageEmployeeInTheDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        Employee result = null;
        double maxSal = -1;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department
                    && employee.getSalary() != -1.0
                    && employee.getSalary() > maxSal) {
                maxSal = employee.getSalary();
                result = employee;
            }
        }
        return result;
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
