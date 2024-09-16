public class Worker extends Person {
    protected double hourlyPayRate;

    // Constructor
    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f, Regular Pay: $%.2f, Overtime Hours: %.2f, Overtime Pay: $%.2f, Total Pay: $%.2f%n",
                regularHours, regularPay, overtimeHours, overtimePay, totalPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
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
                "</Person>";
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", String.format(",\"hourlyPayRate\":%.2f}", hourlyPayRate));
    }
}
