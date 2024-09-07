import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import java.rmi.AlreadyBoundException;
import java.util.ArrayList;

public class Firma {
    private ArrayList<Person> persons;

    public Firma() {
        this.persons = new ArrayList<Person>();
    }

    public void hinzufuegenPerson(Person person) throws AlreadyBoundException, InvalidAttributeValueException {
        if(person == null) {
            throw new InvalidAttributeValueException("Person cannot be null");
        }

        if (this.persons.contains(person)) {
            throw new AlreadyBoundException("This person is already added");
        }

        this.persons.add(person);
    }

    public void loschenPerson(Person person) throws InstanceNotFoundException {
        if(!this.persons.contains(person)) {
            throw new InstanceNotFoundException("This person is not added");
        }

        this.persons.remove(person);
    }

    public void loschenPerson(String vorname, String nachname) throws InstanceNotFoundException {
        Person person = null;
        for(Person p : this.persons) {
            if(p.getVorname() == null) continue;
            if(p.getNachname() == null) continue;

            if(p.getNachname().equals(nachname) && p.getVorname().equals(vorname)) {
                person = p;
                break;
            }
        }

        if(person == null) {
            throw new InstanceNotFoundException("Person with this vorname and nachname was not added");
        }

        this.loschenPerson(person);
    }

    public ArrayList<Person> getPersons() {
        return this.persons;
    }

    @Override
    public String toString() {
        return "Firma{" +
                "persons=" + persons.size() +
                '}';
    }
}
