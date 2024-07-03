package main.java.lesson_07;

public class SimpleObject {
    int value;
    String str;

    public SimpleObject(int value, String str) {
        this.value = value;
        this.str = str;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + value + ":  " + str + "]";
    }
}
