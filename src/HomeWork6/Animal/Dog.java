package HomeWork6.Animal;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    /* У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
     * */
    @Override
    public void run(int distance) {
        if (0 <= distance && distance <= 500){
            System.out.println(name + " пробежал " + distance + " метров ");
        } else if (distance > 500){
            System.out.println(name + " пробежит только 500 метров!!!");
        }else {
            System.out.println("Введите положительное значение");
        }
    }

    @Override
    public void swim(int distance) {
        if (0 <= distance && distance <= 10){
            System.out.println(name + " проплыл " + distance + " метров ");
        } else if (distance > 10){
            System.out.println(name + " проплывет только 10 метров!!!");
        }else {
            System.out.println("Введите положительное значение");
        }
    }
}