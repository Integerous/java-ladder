package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Player, Result> resultMap;

    private GameResult(Map<Player, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public static GameResult of(Players players, Ladder ladder, Results results) {
        return new GameResult(execute(players, ladder, results));
    }

    private static Map<Player, Result> execute(Players players, Ladder ladder, Results results) {
        Map<Player, Result> resultMap = new HashMap<>();
        int numberOfPlayers = players.numberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players.getPlayers().get(i);
            int finalPosition = ladder.executeLines(i); //TODO: Position 객체 만들기
            Result result = results.getResults().get(finalPosition);
            resultMap.put(player, result);
        }
        return resultMap;
    }

    public Map<Player, Result> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
