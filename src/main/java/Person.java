import javax.management.InvalidAttributeValueException;

public class Person {
    private String vorname;
    private String nachname;
    private int alter;

    public Person(String vorname, String nachname, int alter) throws InvalidAttributeValueException {
        setVorname(vorname);
        setNachname(nachname);
        setAlter(alter);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) throws InvalidAttributeValueException {
        if(vorname == null || vorname.isEmpty()) {
            throw new InvalidAttributeValueException("Vorname cannot be null or empty");
        }

        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) throws InvalidAttributeValueException {
        if(nachname ==null || nachname.isEmpty()){
            throw new InvalidAttributeValueException("nachname cannot be null or empty");
        }

        this.nachname = nachname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) throws InvalidAttributeValueException {
        if(alter <= 25 || alter >=60){
            throw new InvalidAttributeValueException("Alter must be between 25 and 65");
        }

        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", alter=" + alter +
                '}';
    }
}
