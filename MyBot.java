import hlt.GameMap;
import hlt.Networking;
import strategy.AbstractStrategy;
import strategy.StrategyFactory;

public class MyBot {

    public static void main(final String[] args) {
        final Networking networking = new Networking();
        final GameMap gameMap = networking.initialize("n1try-basic-v1.7");

        AbstractStrategy currentStrategy = StrategyFactory.chooseStrategy(gameMap);

        while (true) {
            networking.updateMap(gameMap);
            Networking.sendMoves(currentStrategy.apply());
        }
    }
}
