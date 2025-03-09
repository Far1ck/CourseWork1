public class CourseWork1 {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        book.addNewEmployee("Саляхов Фарит Фанузович", 1, 500000.0);
        book.addNewEmployee("Иванов Иван Иванович", 2, 65000.0);
        book.addNewEmployee("Петров Петр Петрович", 3, 98543.0);
        book.addNewEmployee("Сергеев Сергей Сергеевич", 4, 125643.0);
        book.addNewEmployee("Александров Александр Александрович", 5, 55326.0);
        book.addNewEmployee("Алексеев Алексей Алексеевич", 2, 235643.0);
        book.addNewEmployee("Андреев Андрей Андреевич", 3, 132522.0);
        book.addNewEmployee("Романов Роман Романович", 3, 322153.0);
        book.addNewEmployee("Дмитриев Дмитрий Дмитриевич", 4, 73325.0);
        book.addNewEmployee("Павлов Павел Павлович", 4, 89234.0);
        book.addNewEmployee("Тимофеев Тимофей Тимофеевич", 5, 223532.0);
        System.out.println(book);
        System.out.println("Траты на ЗП за месяц: " + book.getSalaryCostsPerMonth() + "\n");
        System.out.println("Сотрудник с минимальной зарплатой: \n" + book.getMinWageEmployee());
        System.out.println("Сотрудник с максимальной зарплатой: \n" + book.getMaxWageEmployee());
        System.out.println("Средняя ЗП: " + String.format("%.2f", book.getAverageSalary()));
        book.getListOfAllFullNames();
        book.indexSalary(10);
        System.out.println("\n" + book);
        System.out.println("Сотрудник с минимальной ЗП в 4 отделе: \n" + book.getMinWageEmployeeInTheDepartment(4));
        System.out.println("Сотрудник с максимальной ЗП в 3 отделе: \n" + book.getMaxWageEmployeeInTheDepartment(3));
        System.out.println("Траты на ЗП во 2 отделе: " + String.format("%.2f", book.getSalaryCostsPerMonthInTheDepartment(2)));
        book.indexSalaryInTheDepartment(2, 10);
        System.out.println("Траты на ЗП во 2 отделе после индексации: "
                + String.format("%.2f", book.getSalaryCostsPerMonthInTheDepartment(2)));
        System.out.println("Средняя ЗП отдела 2: " + String.format("%.2f", book.getAverageSalaryInTheDepartment(2)) + "\n");
        System.out.println("Список сотрудников 3 отдела:");
        book.printAllEmployeesInTheDepartment(3);
        System.out.println();
        System.out.println("Сотрудники с ЗП меньше 100к:");
        book.printAllEmployeesWithSalaryLessThanTheNumber(100_000);
        System.out.println();
        System.out.println("Сотрудники с ЗП больше 100к:");
        book.printAllEmployeesWithSalaryGreaterThanTheNumber(100_000);
        System.out.println("\nСотрудник с id = 5: \n" + book.getEmployeeById(5));
        book.deleteEmployee(5);
        book.deleteEmployee(7);
        book.deleteEmployee(9);
        book.deleteEmployee(2);
        System.out.println(book);
        book.addNewEmployee("Пушкин Александр Сергеевич", 1, 324235);
        System.out.println(book);
    }
}
