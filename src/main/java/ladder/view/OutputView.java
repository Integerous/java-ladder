package ladder.view;

import ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.view.InputView.printEmptyLine;

public class OutputView {
    private static final String MESSAGE_FOR_RESULT_TITLE = "사다리 결과";
    private static final String EMPTY_SPACE = "     ";
    private static final String BAR = "-----";
    private static final String COLUMN = "|";
    private static final String BLANK_TO_FILL_THE_NAME_SPACE = " ";
    private static final int SPACE_FOR_NAME = 5;

    public static void drawLadder(Players players, Ladder ladder, Results results) {
        printResultTitle();
        printPlayers(players);
        printLadder(ladder);
        printResults(results);
    }

    private static void printResultTitle() {
        printEmptyLine();
        System.out.println(MESSAGE_FOR_RESULT_TITLE);
        printEmptyLine();
    }

    private static void printPlayers(Players players) {
        players.getPlayers().stream()
                .map(OutputView::adjustNameLength)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String adjustNameLength(Player player) {
        String name = player.getName();
        int spaceForBlank = SPACE_FOR_NAME - name.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> BLANK_TO_FILL_THE_NAME_SPACE)
                .collect(Collectors.joining())
                .concat(name);
    }

    private static void printResults(Results results) { //TODO: 위의 코드와 중복 해결하기
        results.getResults().stream()
                .map(OutputView::adjustNameLength)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String adjustNameLength(Result result) {
        String resultName = result.getResult();
        int spaceForBlank = SPACE_FOR_NAME - resultName.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> BLANK_TO_FILL_THE_NAME_SPACE)
                .collect(Collectors.joining())
                .concat(resultName);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(EMPTY_SPACE);
        line.getBars().stream()
                .map(OutputView::printBars)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String printBars(Boolean bar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COLUMN);
        if (bar) {
            return stringBuilder.append(BAR).toString();
        }
        return stringBuilder.append(EMPTY_SPACE).toString();
    }

    public static void printResultMap(Map<Player, Result> resultMap) {
        System.out.println("실행 결과");
        resultMap.entrySet()
                .stream()
                .forEach(result -> System.out.println(
                                result.getKey().getName() + " : " + result.getValue().getResult()));
    }
}
