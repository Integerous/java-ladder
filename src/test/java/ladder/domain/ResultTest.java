package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultTest {
    @Test
    void 각_사다리의_결과를_입력받아_생성한다() {
        String resultTest = "꽝";
        Result result = Result.from(resultTest);

        assertThat(result.getResult()).isEqualTo(resultTest);
    }

    @Test
    void 각_사다리의_결과가_다섯글자_이상이면_예외가_발생한다() {
        String exceedLengthResult = "길이 제한을 초과하는 결과";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Result.from(exceedLengthResult);
                }).withMessage(Result.ALERT_EXCEED_LENGTH_OF_RESULT);
    }
}
