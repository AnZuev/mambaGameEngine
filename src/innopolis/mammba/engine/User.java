package innopolis.mammba.engine;

/**
 * Created by anton on 17/07/16.
 */
public class User {
    String name;
    String surname;
    Integer balance;

    User(String nName, String nSurname, Integer nBalance){
        name = nName;
        surname = nSurname;
        balance = nBalance;
    }


    public int getBalance(){
        return balance;
    }

    public void reduceBalance(int amount){
        balance -= amount;
    }

}
