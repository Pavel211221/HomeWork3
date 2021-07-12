package HomeWork7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean addFood(int amount){  //добавление еды в тарелку
        if (amount < 0){
            return false;
        }
        food +=amount;
        return true;
    }


    public boolean decrease(int amount){
        if (amount < 0 || amount > food){    //условие достатаочности еды
            return false;
        }
        food -=amount;
        return true;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}