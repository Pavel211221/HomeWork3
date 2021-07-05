package HomeWork5;

public class MainClass5 {
    public static void main(String[] args) {
        /**4. Создать массив из 5 сотрудников.
         * */
        Employees[] employees1 = new Employees[5];
        employees1[0] = new Employees("Yarovikov", "ingener", "Yarovikov@mail.ru", 916614, 5000, 34);
        employees1[1] = new Employees("Ivanov", "ingener", "Ivanov@mail.ru", 916800, 5000, 55);
        employees1[2] = new Employees("Surkov", "designer", "Surkov@mail.ru", 916000, 5000, 62);
        employees1[3] = new Employees("Petrov", "designer", "Petrov@mail.ru", 916152, 5000, 24);
        employees1[4] = new Employees("Putin", "director", "Putin@mail.ru", 000001, 5000, 68);


        /**5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
         * */
//ВАРИАНТ1
//        for (int i = 0; i < employees1.length; i++) {
//            if (employees1[i].getAge() > 40)
//            {
//                System.out.println(employees1[i]);
//            }
//        }
//    }
//}


//ВАПИАНТ2
        for (int i = 0; i < employees1.length; i++) {
            if (employees1[i].getAge() > 40)
            {
                employees1[i].printFullInfo();
            }
        }
    }
}