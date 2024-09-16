import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create workers
        Worker worker1 = new Worker("John", "Doe", "001", "Mr.", 1980, 15.00);
        Worker worker2 = new Worker("Jane", "Smith", "002", "Ms.", 1990, 20.00);
        Worker worker3 = new Worker("Bill", "Jones", "003", "Dr.", 1975, 25.00);

        // Create salary workers
        SalaryWorker salaryWorker1 = new SalaryWorker("Anna", "Taylor", "004", "Ms.", 1985, 30.00, 50000);
        SalaryWorker salaryWorker2 = new SalaryWorker("Tom", "Brown", "005", "Mr.", 1987, 35.00, 60000);
        SalaryWorker salaryWorker3 = new SalaryWorker("Mike", "White", "006", "Prof.", 1983, 40.00, 70000);

        // Add them to a list
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(salaryWorker1);
        workers.add(salaryWorker2);
        workers.add(salaryWorker3);

        // Simulate 3 weeks of work
        double[] hoursWorked = {40, 50, 40};
        for (int week = 0; week < 3; week++) {
            System.out.printf("Week %d Pay%n", week + 1);
            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked[week]);
            }
            System.out.println();
        }
    }
}
