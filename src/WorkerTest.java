import org.junit.Test;
import static org.junit.Assert.*;

public class WorkerTest {

    @Test
    public void testCalculateWeeklyPay_NoOvertime() {
        Worker worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
        double hoursWorked = 40;
        double expectedPay = 40 * 20.0;
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.01);
    }

    @Test
    public void testCalculateWeeklyPay_WithOvertime() {
        Worker worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
        double hoursWorked = 50;
        double expectedPay = (40 * 20.0) + (10 * 20.0 * 1.5);
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.01);
    }

    @Test
    public void testToCSV() {
        Worker worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
        String expectedCSV = "John,Doe,001,Mr.,1980,20.0";
        assertEquals(expectedCSV, worker.toCSV());
    }

    @Test
    public void testToXML() {
        Worker worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
        String expectedXML = "<Person><FirstName>John</FirstName><LastName>Doe</LastName><ID>001</ID><Title>Mr.</Title><YOB>1980</YOB><HourlyPayRate>20.00</HourlyPayRate></Person>";
        assertEquals(expectedXML, worker.toXML());
    }

    @Test
    public void testToJSON() {
        Worker worker = new Worker("John", "Doe", "001", "Mr.", 1980, 20.0);
        String expectedJSON = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"001\",\"title\":\"Mr.\",\"YOB\":1980,\"hourlyPayRate\":20.00}";
        assertEquals(expectedJSON, worker.toJSON());
    }
}
