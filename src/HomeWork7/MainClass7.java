package HomeWork7;

public class MainClass7 {
    public static void main(String[] args) {
        Cat[] cats = {
                new  Cat("Barsik", 55),
                new  Cat("Barsik2", 28),
                new  Cat("Barsik3", 39),
                new  Cat("Barsik4",10),
                new  Cat("Barsik5",7),
                new  Cat("Barsik6",9)
        };

        Plate plate = new Plate(35 );

////ВАРИАНТ - без пополнения тарелки
//        for (int i = 0; i < cats.length; i++) {
//            cats[i].eat(plate);
//        }

        for (int i = 0; i < cats.length; i++) {
            if(!cats[i].eat(plate)){
                plate.addFood(20);
                cats[i].eat(plate);
            }
        }


        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
    }
}
