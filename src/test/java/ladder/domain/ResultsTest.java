package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultsTest {
    @Test
    void 입력된_각_사다리의_결과들로_Results를_생성한다() {
        int numberOfPlayers = 4;
        String inputResults = "꽝,5000,꽝,5000";
        Results results = Results.from(inputResults, numberOfPlayers);

        assertThat(results.getResults().size()).isEqualTo(4);
    }

    @Test
    void 플레이어_수와_결과의_수가_같지_않으면_예외가_발생한다() {
        int numberOfPlayers = 4;
        String inputResults = "꽝,꽝,꽝,꽝,당첨";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Results.from(inputResults, numberOfPlayers);
                }).withMessage(Results.ALERT_INVALID_NUMBER_OF_RESULT);
    }
}
