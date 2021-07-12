package HomeWork6;


import HomeWork6.Animal.Animal;
import HomeWork6.Animal.Cat;
import HomeWork6.Animal.Dog;

public class MainClass6 {
    public static void main(String[] args) {

        Animal cat = new Cat("Barsik");
        Animal cat1 = new Cat("Pirat");
        Animal cat2 = new Cat("Murka");

        Animal dog = new Dog("Bobik");
        Animal dog1 = new Dog("Naida");


        cat.run(-15);
        cat1.run(700);
        cat2.run(100);
        dog.run(400);
        dog1.run(3000);

        cat.swim(50);
        cat1.swim(5);
        dog.swim(5);
        dog1.swim(200);

    }
}