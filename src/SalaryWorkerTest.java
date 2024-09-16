import org.junit.Test;
import static org.junit.Assert.*;

public class SalaryWorkerTest {

    @Test
    public void testCalculateWeeklyPay() {
        SalaryWorker salaryWorker = new SalaryWorker("Anna", "Taylor", "004", "Ms.", 1985, 30.0, 52000.0);
        double expectedPay = 52000.0 / 52;
        assertEquals(expectedPay, salaryWorker.calculateWeeklyPay(40), 0.01);
        assertEquals(expectedPay, salaryWorker.calculateWeeklyPay(50), 0.01);  // Even with overtime, pay is the same
    }

    @Test
    public void testToCSV() {
        SalaryWorker salaryWorker = new SalaryWorker("Anna", "Taylor", "004", "Ms.", 1985, 30.0, 52000.0);
        String expectedCSV = "Anna,Taylor,004,Ms.,1985,30.0,52000.0";
        assertEquals(expectedCSV, salaryWorker.toCSV());
    }

    @Test
    public void testToXML() {
        SalaryWorker salaryWorker = new SalaryWorker("Anna", "Taylor", "004", "Ms.", 1985, 30.0, 52000.0);
        String expectedXML = "<Person><FirstName>Anna</FirstName><LastName>Taylor</LastName><ID>004</ID><Title>Ms.</Title><YOB>1985</YOB><HourlyPayRate>30.00</HourlyPayRate><AnnualSalary>52000.00</AnnualSalary></Person>";
        assertEquals(expectedXML, salaryWorker.toXML());
    }

    @Test
    public void testToJSON() {
        SalaryWorker salaryWorker = new SalaryWorker("Anna", "Taylor", "004", "Ms.", 1985, 30.0, 52000.0);
        String expectedJSON = "{\"firstName\":\"Anna\",\"lastName\":\"Taylor\",\"ID\":\"004\",\"title\":\"Ms.\",\"YOB\":1985,\"hourlyPayRate\":30.00,\"annualSalary\":52000.00}";
        assertEquals(expectedJSON, salaryWorker.toJSON());
    }
}
