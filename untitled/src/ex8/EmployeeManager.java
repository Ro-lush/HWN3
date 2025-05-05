package ex8;

import java.util.ArrayList;
import java.util.List;


class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    // Нарушение DIP (Dependency Inversion Principle)
    private DatabaseConnection dbConnection = new MySQLConnection();
    private Report report = new Report();

    public void processEmployeeData(Employee emp) {
        if (!isValidEmployee(emp)) {
            return;
        }

        if (employeeExists(emp)) {
            System.out.println("Employee exists");
            return;
        }

        saveEmployee(emp);

    }

    private boolean isValidEmployee(Employee emp) {
        if (emp == null) {
            logAction("Employee is null");
            return false;
        }

        if (emp.getName() == null || emp.getName().isEmpty()) {
            logAction("Invalid name");
            return false;
        }

        if (emp.getAge() <= 18 || emp.getAge() >= 65) {
            logAction("Invalid age");
            return false;
        }

        if (emp.getSalary() <= 0) {
            logAction("Invalid salary");
            return false;
        }
        if (emp.getEmail() == null || !emp.getEmail().isEmpty()){
            logAction("Invalid email");
            return false;
        }

        return true;
    }

    private boolean employeeExists(Employee emp) {
        return employees.stream().anyMatch(e -> e.getId() == emp.getId());
    }

    private void saveEmployee(Employee emp) {
        if (!dbConnection.isConnected()) {
            logAction("DB not connected");
            return;
        }

        dbConnection.save(emp);
        employees.add(emp);
        logAction("Added: " + emp.getName());
    }


    public void generateReport(String type) {
        switch (type) {
            case ("PDF"):
                report.generatePdfReport();
                break;
            case ("EXCEL"):
                report.generateExcelReport();
                break;
            default:
                logAction("Отчет не требуется");
        }
    }

    private void logAction(String message) {
        System.out.println("[LOG] " + message);
    }
}
