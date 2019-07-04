package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Results results = Results.from(InputView.askResults(), players.numberOfPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);

        OutputView.drawLadder(players, ladder, results);

        GameResult gameResult = GameResult.of(players, ladder, results);

//        InputView.askWhichResultToSqee();

        OutputView.printResultMap(gameResult);
    }
}
