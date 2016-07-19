package innopolis.mammba.engine;

import innopolis.mammba.engine.errors.GameFlowError;
import innopolis.mammba.engine.game.Game;
import innopolis.mammba.engine.player.Player;
import innopolis.mammba.engine.player.PlayerAction;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       /* CardDeck cards = new CardDeck();
        cards.shuffle();
        Card card1 = cards.getCard();
        Card card2 = cards.getCard();*/



        //System.out.println(card1.compareTo(card2));

        User user1 = new User("user1", "last1", 200);
        User user2 = new User("user2", "last2", 200);
        User user3 = new User("user3", "last3", 200);
        LinkedList<User> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Game game = new Game();
        Player player1 = game.addUser(user1);
        Player player2 = game.addUser(user2);
        Player player3 = game.addUser(user3);

        game.start();

        player1.fold();
        player2.pass();
        player3.pass();


        player2.pass();
        player3.pass();


        player2.raise(1);
        player3.call();

        player2.fold();


        try{
            List<PlayerAction> list = player3.getActions();
            player3.pass();
        }catch (GameFlowError a){
            System.out.println(a.toString());
        }

        /*player2.raise(22);
        player3.call();*/

        System.out.println("dsd");

    }


}
