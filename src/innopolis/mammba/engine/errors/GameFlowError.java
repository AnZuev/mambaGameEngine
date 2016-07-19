package innopolis.mammba.engine.errors;

/**
 * Created by anton on 17/07/16.
 *
 */
public class GameFlowError extends Error{
    private GameFlowErrorType type;
    private String message;

    public GameFlowError(GameFlowErrorType nType, String nMessage){
        super();
        type = nType;
        message = nMessage;
    }
    public String toString(){
        return "GameFlowError: " + type.toString() + " ; Message: " + message + ".";
    }
}

