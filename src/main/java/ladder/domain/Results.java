package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String RESULT_SEPARATOR = ",";
    static final String ALERT_INVALID_NUMBER_OF_RESULT = "결과의 수는 참여자 수와 같아야 합니다.";

    private final List<Result> results;

    private Results(List<Result> results, int numberOfPlayers) {
        if (results.size() != numberOfPlayers) {
            throw new IllegalArgumentException(ALERT_INVALID_NUMBER_OF_RESULT);
        }
        this.results = results;
    }

    public static Results from(String inputResults, int numberOfPlayers) {
        return new Results(Arrays
                .stream(inputResults.split(RESULT_SEPARATOR))
                .map(String::trim)
                .map(Result::from)
                .collect(Collectors.toList()), numberOfPlayers);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
