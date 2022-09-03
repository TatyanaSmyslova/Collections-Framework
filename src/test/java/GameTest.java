import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GameTest {

    Player player = new Player(1, "Игрок 1", 5);
    Player player1 = new Player(2, "Игрок 2", 2);
    Player player2 = new Player(3, "Игрок 3", 3);
    Player player3 = new Player(4, "Игрок 4", 7);
    Player player4 = new Player(5, "Игрок 5", 10);
    Player player5 = new Player(6, "Игрок 6", 2);

    private Game game = new Game();

    @Test
    public void findName (){
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.findByName("Игрок 6");
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void roundOneWinSecond() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Игрок 3", "Игрок 4");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void roundTwoWinFirst() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Игрок 5", "Игрок 6");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void roundThreeDraw() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        int actual = game.round("Игрок 2", "Игрок 6");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayers() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 7", "Игрок 8");

        });
    }

    @Test
    public void FirstPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 8", "Игрок 1");

        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 1", "Игрок 8");

        });
    }
}