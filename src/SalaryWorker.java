public class SalaryWorker extends Worker {
    protected double annualSalary;

    // Constructor
    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.printf("Weekly Pay (fraction of annual salary): $%.2f%n", calculateWeeklyPay(hoursWorked));
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toXML() {
        return "<Person>" +
                "<FirstName>" + getFirstName() + "</FirstName>" +
                "<LastName>" + getLastName() + "</LastName>" +
                "<ID>" + getID() + "</ID>" +
                "<Title>" + getTitle() + "</Title>" +
                "<YOB>" + getYOB() + "</YOB>" +
                "<HourlyPayRate>" + String.format("%.2f", this.hourlyPayRate) + "</HourlyPayRate>" +
                "<AnnualSalary>" + String.format("%.2f", this.annualSalary) + "</AnnualSalary>" +
                "</Person>";
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", String.format(",\"annualSalary\":%.2f}", annualSalary));
    }
}
