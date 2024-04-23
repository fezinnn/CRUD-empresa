import java.time.LocalDate;

public final class Paycheck {
    private LocalDate payday;
    private Double salary;

    public Paycheck(LocalDate payday, Double salary){
        this.payday = payday;
        this.salary = salary;
    }

}
