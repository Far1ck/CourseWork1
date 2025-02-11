class Employee {
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

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    void setDepartment(int department) {
        this.department = department;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void setAll(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    String getFullName() {
        return fullName;
    }
    int getDepartment() {
        return department;
    }
    double getSalary() {
        return salary;
    }

    static void getListOfAllEmployees(Employee[] list) {
        System.out.println("\nСписок всех сотрудников: ");
        for (Employee employee : list) {
            if (employee.fullName != null || employee.department != -1 || employee.salary != -1.0) {
                System.out.println(employee.id + "    " + employee.fullName + "    " + employee.department + "    " + employee.salary);
            }
        }
    }

    static double salaryCostsPerMonth(Employee[] list) {
        System.out.println();
        double sum = 0.0;
        for (Employee i : list) {
            if (i.salary != -1) {
                sum += i.salary;
            }
        }
        System.out.println("Сумма затрат на ЗП в месяц: " + sum + " рублей");
        return sum;
    }

    static void employeeWithMinSalary(Employee[] list) {
        System.out.println();
        int minSal = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i].salary != -1.0 && list[i].salary < list[minSal].salary) {
                minSal = i;
            }
        }
        System.out.println("Сотрудник с минимальной ЗП: " + list[minSal].fullName + " c зарплатой " + list[minSal].salary);
    }

    static void employeeWithMaxSalary(Employee[] list) {
        System.out.println();
        int maxSal = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i].salary != -1.0 && list[i].salary > list[maxSal].salary) {
                maxSal = i;
            }
        }
        System.out.println("Сотрудник с максимальной ЗП: " + list[maxSal].fullName + " c зарплатой " + list[maxSal].salary);
    }

    static double averageSalary(Employee[] list) {
        System.out.println();
        int count = 0;
        double result;
        for (Employee i : list) {
            if (i.salary != -1) {
                count++;
            }
        }
        result = salaryCostsPerMonth(list) / count;
        System.out.println("Средняя ЗП: " + String.format("%.2f", result));
        return result;
    }

    static void getListOfAllFullNames(Employee[] list) {
        System.out.println("\nФИО всех сотрудников: ");
        for (Employee employee : list) {
            if (employee.fullName != null || employee.department != -1 || employee.salary != -1.0) {
                System.out.println(employee.fullName);
            }
        }
    }

    static void indexSalary(Employee[] list, double percentage) {
        if (percentage < -100) {
            return;
        }
        double indexCoef = (100 + percentage) / 100;
        for (int i = 0; i < list.length; i++) {
            if (list[i].salary != -1) {
                list[i].salary *= indexCoef;
            }
        }
    }

    static void minSalaryInDepartment(Employee[] list, int depart) {
        if (depart < 1 || depart > 5) {
            return;
        }
        int minSal = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].department == depart) {
                minSal = i;
                break;
            }
            if (i == list.length - 1 && minSal == -1) {
                return;
            }
        }
        for (int i = minSal + 1; i < list.length; i++) {
            if (list[i].department == depart && list[i].salary != -1.0 && list[i].salary < list[minSal].salary) {
                minSal = i;
            }
        }
        System.out.println("Сотрудник с минимальной ЗП в отделе " + depart + ": " + list[minSal].fullName + " c зарплатой " + list[minSal].salary);
    }

    static void maxSalaryInDepartment(Employee[] list, int depart) {
        if (depart < 1 || depart > 5) {
            return;
        }
        int maxSal = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].department == depart) {
                maxSal = i;
                break;
            }
            if (i == list.length - 1 && maxSal == -1) {
                return;
            }
        }
        for (int i = maxSal + 1; i < list.length; i++) {
            if (list[i].department == depart && list[i].salary != -1.0 && list[i].salary > list[maxSal].salary) {
                maxSal = i;
            }
        }
        System.out.println("Сотрудник с максимальной ЗП в отделе " + depart + ": " + list[maxSal].fullName + " c зарплатой " + list[maxSal].salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employeesBook1  = new Employee[10];
        for (int i = 0; i < employeesBook1.length; i++) {
            employeesBook1[i] = new Employee();
        }
    }
}