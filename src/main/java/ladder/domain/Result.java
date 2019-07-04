package ladder.domain;

public class Result {
    static final String ALERT_EXCEED_LENGTH_OF_RESULT = "결과는 다섯글자 이내로 작성해주세요.";
    static final String ALERT_MISSING_RESULT = "결과를 입력하세요.";
    private static final int MAXIMUM_LENGTH_OF_RESULT = 5;

    private final String result;

    private Result(String inputResult) {
        validationResult(inputResult);
        this.result = inputResult;
    }

    private void validationResult(String inputResult) {
        if (inputResult.length() > MAXIMUM_LENGTH_OF_RESULT) {
            throw new IllegalArgumentException(ALERT_EXCEED_LENGTH_OF_RESULT);
        }
        if (inputResult.isEmpty()) {
            throw new IllegalArgumentException(ALERT_MISSING_RESULT);
        }
    }

    public static Result from(String inputResult) {
        return new Result(inputResult);
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
