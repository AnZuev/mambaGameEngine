package innopolis.mammba.engine.player;

/**
 * Created by anton on 19/07/16.
 */


public class PlayerAction{
    private PlayerActionsEnum type;
    private int amount;


    public PlayerAction(PlayerActionsEnum type) {
        this.type = type;
        this.amount = 0;
    }


    public PlayerAction(PlayerActionsEnum type, int amount) {
        this.type = type;
        this.amount = amount;
    }


    public PlayerActionsEnum getType() {
        return type;
    }
    public int getAmount(){
        return amount;
    }

}



