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

//        Map<Player, Result> resultMap = new HashMap<>();
//        for (int i = 0; i < players.numberOfPlayers(); i++) {
//            Player player = players.getPlayers().get(i);
//            // i(position)에서 시작해서 사다리 타고 나서의 position
//            int finalPosition = ladder.executeLines(i);
//            result = results.get(finalPosition); // Results의 position위치의 Result
//            resultMap.put(player, result);
//        }

        OutputView.drawLadder(players, ladder, results);
    }
}
