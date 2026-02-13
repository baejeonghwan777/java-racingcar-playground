package study;

public class Location {
    private int value;

    public Location(int value) {
        if (value >= 0) this.value = value;
        if (value < 0) this.value = 0;
    }

    public StringBuilder printLocation() {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < value; i++) sign.append("-");
        return sign;
    }

    public void increase(int input) {
        if(input >= 4) this.value++;
    }

    public int getValue() {
        return value;
    }
}
