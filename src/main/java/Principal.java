import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        int op;

        while (true){
            System.out.println();
            System.out.println("1. Contratar funcionário");
            System.out.println("2. Demitir funcionário");
            System.out.println("3. Listar todos os funcionários");
            System.out.println("4. Listar funcionários por cargo");
            System.out.println("5. Pagar funcionário");
            System.out.println("6. Aumentar salário de um funcionário");
            System.out.println("7. Calcular salário médio por cargo");
            System.out.println("8. Calcular salário médio por data");
            System.out.println("9. Sair");
            System.out.println();
            System.out.println("Digite a opção desejada:");

            op = scanner.nextInt();

            System.out.println();

            switch (op){
                case 1:
                    System.out.println("Digite o ID do funcionário:");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    System.out.println("Digite o nome do funcionário:");
                    String name = scanner.nextLine();
                    System.out.println("Digite o cargo do funcionário:");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Digite o salário do funcionário:");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite a data de contratação do funcionário (AAAA-MM-DD):");
                    LocalDate dateOfEmployment = LocalDate.parse(scanner.nextLine());

                    company.hire(id, name, jobTitle, salary, dateOfEmployment);
                    System.out.println("Funcionário contratado!");
                    break;

                case 2:
                    System.out.println("Digite o ID do funcionário que você deseja demitir:");
                    scanner.nextLine();
                    String employeeId = scanner.nextLine();

                    company.fire(employeeId);
                    System.out.println("Funcionário demitido!");
                    break;

                case 3:
                    System.out.println("Funcionários da empresa:");
                    for (Employee employee : company.getEmployees()) {
                        System.out.println(employee);
                    }
                    break;

                case 4:
                    System.out.println("Digite o cargo dos funcionários que deseja consultar:");
                    scanner.nextLine();
                    String employeeJobTitle = scanner.nextLine();

                    List<Employee> employeesWithJobTitle = company.getEmployees(employeeJobTitle);
                    if (employeesWithJobTitle.isEmpty()){
                        System.out.println("Não há funcionários com o cargo especificado!");
                    } else{
                        System.out.println("Funcionários com o cargo '" + employeeJobTitle + "':");
                        for (Employee employee : employeesWithJobTitle){
                            System.out.println(employee);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Digite o ID do funcionário que você deseja pagar:");
                    scanner.nextLine();
                    String employeeIdToPay = scanner.nextLine();

                    company.pay(employeeIdToPay);
                    System.out.println("Funcionário pago!");
                    break;

                case 6:
                    System.out.println("Digite o ID do funcionário que você deseja aumentar o salário:");
                    scanner.nextLine();
                    String employeeIdToIncreaseSalary = scanner.nextLine();
                    System.out.println("Digite o novo salário:");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();

                    company.increaseSalary(employeeIdToIncreaseSalary, newSalary);
                    System.out.println("Salário aumentado com sucesso!");
                    break;

                case 7:
                    System.out.println("Digite o cargo para calcular o salário médio:");
                    scanner.nextLine();
                    String jobTitleToAverageSalary = scanner.nextLine();

                    double averageSalary = company.averageSalary(jobTitleToAverageSalary);
                    System.out.printf("O salário médio para o cargo '%s' é: %.2f\n", jobTitleToAverageSalary, averageSalary);
                    break;

                case 8:
                    System.out.println("Digite a data inicial para calcular o salário médio:");
                    scanner.nextLine();
                    LocalDate inicialDateToAverageSalary = LocalDate.parse(scanner.nextLine());
                    System.out.println("Digite a data final para calcular o salário médio:");
                    LocalDate finalDateToAverageSalary = LocalDate.parse(scanner.nextLine());

                    double averageDateSalary = company.averageSalary(inicialDateToAverageSalary, finalDateToAverageSalary);
                    System.out.printf("O salário médio é: %.2f\n", averageDateSalary);
                    break;

                case 9:
                    System.out.println("Saindo...");

                default:
                    System.out.println("Opção inválida!");
                    System.exit(0);
            }

        }
    }
}
