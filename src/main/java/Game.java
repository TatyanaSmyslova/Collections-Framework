import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> playersList = new ArrayList<>();

    public void register(Player player){
        playersList.add(player);
    }

    public int findByName (String name){
        for (int i = 0; i < playersList.size(); i++) {
            Player player = playersList.get(i);
            if(player.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public int round(String name1, String name2) {
        int player1 = findByName(name1);
        int player2 = findByName(name2);
        if (player1 == -1) {
            throw new NotRegisteredException("Этот игрок" + name1 + "не зарегистрирован");
        }
        if (player2 == -1) {
            throw new NotRegisteredException("Этот игрок" + name2 + "не зарегистрирован");
        }
        int strength1 = playersList.get(player1).getStrength();
        int strength2 = playersList.get(player2).getStrength();

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        }
        return 0;
    }
}