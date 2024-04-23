import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Company {
    ArrayList<Employee> employees = new ArrayList<>();

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        employees.add(new Employee(id, name, jobTitle, salary, dateOfEmployment));
    }

    public void fire(String id){
        employees.removeIf(employee -> employee.getId().equals(id));
    }

    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    public List<Employee> getEmployees(String jobTitle){
        return employees.stream().filter(employee -> employee.getJobTitle().equals(jobTitle))
                .collect(Collectors.toList());
    }

    public void pay(String id){
        employees.stream().filter(employee -> employee.getId().equals(id))
                .forEach(employee -> employee.addPaycheck(LocalDate.now()));
    }

    public void increaseSalary(String id, double newSalary){
        employees.stream().filter(employee -> employee.getId().equals(id))
                .forEach(employee -> employee.setSalary(newSalary));
    }

    public double averageSalary(String jobTitle){
        return employees.stream().filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average()
                .orElse(0);

    }

    public double averageSalary(LocalDate initialDate, LocalDate finalDate){
        return employees.stream().filter(employee -> employee.getDateOfEmployment().isAfter(initialDate) &&
                employee.getDateOfEmployment().isBefore(finalDate))
                .mapToDouble(Employee::getSalary).average()
                .orElse(0);
    }
}
