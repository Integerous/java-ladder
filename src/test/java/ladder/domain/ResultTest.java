package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 각_사다리의_결과를_입력받아_생성한다() {
        String resultTest = "꽝";
        Result result = Result.from(resultTest);

        assertThat(result.getResult()).isEqualTo(resultTest);
    }
}
