package HomeWork6.Animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    /*У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
     * */
    @Override
    public void run(int distance) {
        if (0 <= distance && distance <= 200){
            System.out.println(name + " пробежал " + distance + " метров ");
        } else if (distance > 200){
            System.out.println(name + " пробежит только 200 метров!!!");
        }else {
            System.out.println("Введите положительное значение");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("коты не умеет плавать!!!");
    }
}