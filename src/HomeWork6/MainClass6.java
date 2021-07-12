package HomeWork6;
/*1. Создать классы Собака и Кот с наследованием от класса Животное.
 *
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 * Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 *
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 *
 * 4. * Добавить подсчет созданных котов, собак и животных.
 * */

import HomeWork6.Animal.Animal;
import HomeWork6.Animal.Cat;
import HomeWork6.Animal.Dog;

public class MainClass6 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik"),
                new Dog("Tuzik"),
                new Cat("Tiger", 1000, 100),
                new Dog("Hunter", 2000, 300)
        };

        for (int i = 0; i < animals.length; i++) {
            animals[i].run(50);
            animals[i].swim(5);

        }

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCount());
        System.out.println(Dog.getCount());
    }
}
