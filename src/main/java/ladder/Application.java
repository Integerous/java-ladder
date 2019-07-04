package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Results results = Results.from(InputView.askResults(), players.numberOfPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);

        Map<Player, Result> resultMap = new HashMap<>(); //TODO: 클래스로 분리하기
        for (int i = 0; i < players.numberOfPlayers(); i++) {
            Player player = players.getPlayers().get(i);
            int finalPosition = ladder.executeLines(i); //TODO: Position 객체 만들기
            Result result = results.getResults().get(finalPosition);
            resultMap.put(player, result);
        }
        OutputView.drawLadder(players, ladder, results);
        OutputView.printResultMap(resultMap);
    }
}
