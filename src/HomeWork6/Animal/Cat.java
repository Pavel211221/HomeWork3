package HomeWork6.Animal;

public class Cat extends Animal {
    private static int count;

    public Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, "Кот", maxRunDistance, maxSwimDistance);
        count++;
    }

    public Cat(String name) {
        super(name, "Кот", 200, 0);
        count++;
    }

    public static int getCount() {
        return count;
    }
}

