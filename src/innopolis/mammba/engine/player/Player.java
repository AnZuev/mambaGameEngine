package innopolis.mammba.engine.player;

import innopolis.mammba.engine.User;
import innopolis.mammba.engine.errors.*;

import innopolis.mammba.engine.cards.Card;
import innopolis.mammba.engine.game.Game;
import innopolis.mammba.engine.game.GameState;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anton on 17/07/16.
 */


public class Player {
    private int id;
    private User user;
    private PlayerState state;
    private int _secret;
    private Game game;

    private static int idCounter = 0;


    List<Card> cards = new LinkedList<>();

    public User getUser(){
        return user;
    }

    public Player(User nUser, int secret, Game nGame){
        user = nUser;
        state = PlayerState.active;
        _secret = secret;
        id = ++idCounter;
        game = nGame;
    }

    public int getId(){
        return id;
    }

    public void call(){
        if(isGameDied()){
            throw new GameFlowError(GameFlowErrorType.gameFinished, "Game has finished");
        }
        checkMoveState();
        state = PlayerState.active;
        game.call(id);
    };

    public void pass(){
        if(isGameDied()){
            throw new GameFlowError(GameFlowErrorType.gameFinished, "Game has finished");
        }
        checkMoveState();
        game.pass(id);
        state = PlayerState.active;
    }

    public void raise(int stake){
        if(isGameDied()){
            throw new GameFlowError(GameFlowErrorType.gameFinished, "Game has finished");
        }
        checkMoveState();
        if(stake > user.getBalance()){
            throw new GameFlowError(GameFlowErrorType.noEnoughMoney, "Not enough money");
        }
        game.raise(id, stake);
        //TODO: check if user balance enough
        // TODO: raise in game
        state = PlayerState.active;

    }

    public void fold(){
        if(isGameDied()){
            throw new GameFlowError(GameFlowErrorType.gameFinished, "Game has finished");
        }
        checkMoveState();
        game.fold(id);
//        state = PlayerState.folded;

    }

    public void changeStateToWaitToMove(int secret){
        if(secret == _secret){
            state = PlayerState.waitForMove;
        }else{
            throw new Error("Invalid key");
        }
    }
    public void changeStateToFolded(int secret){
        if(secret == _secret){
            state = PlayerState.folded;
        }else{
            throw new Error("Invalid key");
        }
    }



    private void checkMoveState(){
        if(!isAllowedToMove()){
            throw new GameFlowError(GameFlowErrorType.notYourTurn, "It isn't your turn to move");
        }
    }

    private boolean isAllowedToMove(){
        return (PlayerState.waitForMove == state);
    }

    public PlayerState getState(){
        return state;
    }

    public void setCards(Card card1, Card card2, int secret){
        if(secret == _secret){
            cards.add(card1);
            cards.add(card2);
        }else{
            throw new Error("Invalid key");
        }
    }

    private boolean isGameDied(){
        return (game.getState() == GameState.finished);
    }

    public List<Card> getCards(){
        return cards;
    }

    public List<PlayerAction> getActions(){
        if(isAllowedToMove()){
            LinkedList<PlayerAction> actions = new LinkedList<>();
            return game.getActionsByPlayer(this, _secret);
        }
        return null;
    }



}



