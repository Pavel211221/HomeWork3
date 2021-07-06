package HomeWork5;

public class Employees {

    /**1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
     *2. Конструктор класса должен заполнять эти поля при создании объекта.
     * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     * */

    private String name;
    private String post;
    private String email;
    private int telethon;
    private int salary;
    private int age;

    public Employees(String name, String post, String email, int telethon, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.telethon = telethon;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

//ВАРИАНТ1
//    @Override
//    public String toString() {
//        return "Employees{" +
//                "name='" + name + '\'' +
//                ", post='" + post + '\'' +
//                ", email='" + email + '\'' +
//                ", telethon='" + telethon + '\'' +
//                ", salary=" + salary +
//                ", age=" + age +
//                '}';
//    }
//}

//ВАРИАНТ2

public void printFullInfo(){
    System.out.println("fio: " + name + " post: " + post + " email: " + email +" telethon: " + telethon + " salary: " + salary + " age: " + age);
}}
