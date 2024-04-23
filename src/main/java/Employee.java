import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Employee {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    ArrayList<Paycheck> paychecks= new ArrayList<>();

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        return LocalDate.now().getYear() - dateOfEmployment.getYear();
    }

    public void addPaycheck(LocalDate payday){
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(LocalDate paycheck){
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck(){
        return paychecks.iterator();
    }

    public String getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Nome: %s, Cargo: %s, Salário: %.2f, Data de Contratação: %s",
                id, name, jobTitle, salary, dateOfEmployment.toString());
    }
}
