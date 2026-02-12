package study;

public class Car {
    private String name;
    private int location;

    public Car(int location, String name) {
        if (location >= 0) this.location = location;
        if (location < 0) this.location = 0;
        if (name.length() <= 5) this.name = name;
    }

    public StringBuilder forward(int input) {
        if (input >= 4) location++;
        return printLocation();
    }

    public StringBuilder printLocation() {
        StringBuilder moving = new StringBuilder();
        for (int i = 0; i < location; i++) moving.append("-");
        return moving;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
