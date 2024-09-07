import javax.management.InvalidAttributeValueException;

public class Manager extends Person{
    private String unit;

    public Manager(String vorname, String nachname, int alter, String unit) throws InvalidAttributeValueException {
        super(vorname, nachname, alter);
        setUnit(unit);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) throws InvalidAttributeValueException {
        if(unit == null || unit.isEmpty()) {
            throw new InvalidAttributeValueException("Unit cannot be null");
        }

        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() + "\n" +
                "unit='" + unit + '\'' +
                '}';
    }
}
