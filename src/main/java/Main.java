import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import java.rmi.AlreadyBoundException;

public class Main {
    public static void main(String[] args) {
        Person p1 = null;
        Person p2 = null;
        Person p3 = null;
        Firma f = new Firma();

        try {
            p1 = new Person("P1", "P-1", 26);
            System.out.println("Created P1");
            p2 = new Person("P2", "P-2", 47);
            System.out.println("Created P2");
            p3 = new Person("P3", "P-3", 77);
            System.out.println("Created P3");
        } catch(InvalidAttributeValueException err) {
            System.err.println(err.getMessage());
        }

        try {
            f.hinzufuegenPerson(p1);
            System.out.println("Added P1 to F");

            f.hinzufuegenPerson(p2);
            System.out.println("Added P2 to F");

            f.hinzufuegenPerson(p3);
            System.out.println("Added P3 to F");
        } catch (AlreadyBoundException e) {
            System.err.println(e.getMessage());
        } catch (InvalidAttributeValueException e) {
            System.err.println("Person is null " + e.getMessage());
        }

        try {
            f.hinzufuegenPerson(p1);
            System.out.println("Re-Added P1 to F");
        } catch (InvalidAttributeValueException e) {
            System.err.println("Person is null " + e.getMessage());
        } catch(AlreadyBoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            f.loschenPerson(p2);
            System.out.println("Removed P2");

            f.loschenPerson(p2);
            System.out.println("Re-Removed P2");
        } catch (InstanceNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            f.loschenPerson("P1", "P-1");
            System.out.println("Removed P1 Via Vorname and Nachname");

            f.loschenPerson("P1", "P-1");
            System.out.println("Re-Removed P1 Via Vorname and Nachname");
        } catch (InstanceNotFoundException e) {
            System.err.println(e.getMessage());
        }

        for(Person p: f.getPersons()) {
            System.out.println(p.toString());
        }

        System.out.println(f.toString());


    }
}
