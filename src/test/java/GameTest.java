import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 120);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        int actual = game.round("Ольга", "Анна");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 120);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        int actual = game.round("Анна", "Ольга");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 150);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        int actual = game.round("Анна", "Ольга");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 150);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Лена", "Анна"));
    }

    @Test
    public void secondPlayerNotRegistered() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 150);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Анна", "Лена"));
    }

    @Test
    public void twoPlayerNotRegistered() {
        Player olga = new Player(1, "Ольга", 150);
        Player anna = new Player(2, "Анна", 150);
        Game game = new Game();

        game.register(olga);
        game.register(anna);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ира", "Лена"));
    }
}
