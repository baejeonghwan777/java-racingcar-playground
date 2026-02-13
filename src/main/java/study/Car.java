package study;

public class Car {
    private String name;
    private final Location location;

    public Car(int value, String name) {
        this.location = new Location(value);
        if (name.length() <= 5) this.name = name;
    }

    public StringBuilder forward(int input) {
        location.increase(input);
        return printLocation();
    }

    public StringBuilder printLocation() {
        return location.printLocation();
    }

    public int getLocation() {
        return location.getValue();
    }

    public String getName() {
        return name;
    }
}
