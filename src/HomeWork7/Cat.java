package HomeWork7;

public class Cat {

    private String name;
    private boolean satiety;
    private int appetit;

    public Cat(String name) {
        this.name = name;
        this.appetit = 10;
    }

    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }


//    //ВАРИАНТ - без пополнения тарелки
//    public void eat(Plate plate) {                    //указали ссылку  класса Plate на объект plate
//        if (plate.decrease(appetit)) {               //проверили через метод decrease c возвратом
//            System.out.println(name + " eat...");
//            satiety = true;
//        } else {
//            System.out.println(name + " can't eat...");
//        }
//    }


    public boolean eat(Plate plate) {                    //указали ссылку  класса Plate на объект plate
        if (plate.decrease(appetit)) {               //проверили через метод decrease c возвратом
            System.out.println(name + " eat...");
            satiety = true;
            return true;
        } else {
            System.out.println(name + " can't eat...");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", satiety=" + satiety +
                ", appetit=" + appetit +
                '}';
    }
}
