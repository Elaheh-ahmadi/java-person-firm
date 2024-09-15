
import org.junit.Test;

import javax.management.InvalidAttributeValueException;

import static org.junit.Assert.assertEquals;

public class TestFirma {

    @Test
    public void testAvgAlter() {
        try {
            Person p1 = new Person("P---1", "P---1", 33);
            Person p2 = new Person("P---2", "P---2", 33);
            Person p3 = new Person("P---3", "P---3", 33);

            Firma f = new Firma();
            f.hinzufuegenPerson(p1);
            f.hinzufuegenPerson(p2);
            f.hinzufuegenPerson(p3);

            double avg = f.avgAlter();
            assertEquals(avg, (double)33.0, 0);
            System.out.printf("Avg Alter %f\n", avg);

        } catch (Exception err) {
            System.err.println(err.getMessage());
            assertEquals(true, false);
        }
    }

    @Test
    public void testAlter() {
        Person p = null;
        try {
            p = new Person("ppp", "pppppp", 23);

            assertEquals(true, false);
        } catch (InvalidAttributeValueException e) {
            System.err.println(e.getMessage());
            assertEquals(true, true);
        }

    }

    @Test
    public void testMaxAlter() {
        try {
            Person p1 = new Person("P---1", "P---1", 33);
            Person p2 = new Person("P---2", "P---2", 35);
            Person p3 = new Person("P---3", "P---3", 39);

            Firma f = new Firma();
            f.hinzufuegenPerson(p1);
            f.hinzufuegenPerson(p2);
            f.hinzufuegenPerson(p3);

            int max = f.maxAlter();
            assertEquals(max, 39);
            System.out.printf("Max Alter %d\n", max);

        } catch (Exception err) {
            System.err.println(err.getMessage());
            assertEquals(true, false);
        }
    }

    @Test
    public void testMinAlter() {
        try {
            Person p1 = new Person("P---1", "P---1", 33);
            Person p2 = new Person("P---2", "P---2", 35);
            Person p3 = new Person("P---3", "P---3", 39);

            Firma f = new Firma();
            f.hinzufuegenPerson(p1);
            f.hinzufuegenPerson(p2);
            f.hinzufuegenPerson(p3);

            int min = f.minAlter();
            assertEquals(min, 33);
            System.out.printf("Min Alter %d\n", min);

        } catch (Exception err) {
            System.err.println(err.getMessage());
            assertEquals(true, false);
        }
    }
}
