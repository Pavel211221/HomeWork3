package HomeWork6.Animal;

public class Dog extends Animal {
    private static int count;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, "Собака", maxRunDistance, maxSwimDistance);
        count++;
    }

    public Dog(String name) {
        super(name, "Собака", 500, 30);
        count++;
    }

    public static int getCount() {
        return count;
    }
}