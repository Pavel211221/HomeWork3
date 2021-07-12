package HomeWork6.Animal;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }


    /*Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    * */
    public abstract void run(int distance);

    public abstract void swim(int distance);

}