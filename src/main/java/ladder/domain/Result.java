package ladder.domain;

public class Result {

    private static final String ALERT_EXCEED_LENGTH_OF_RESULT = "결과는 다섯글자 이내로 작성해주세요.";
    private static final int MAXIMUM_LENGTH_OF_RESULT = 5;
    private final String result;

    private Result(String inputResult) {
        if (inputResult.length() > MAXIMUM_LENGTH_OF_RESULT) {
            throw new IllegalArgumentException(ALERT_EXCEED_LENGTH_OF_RESULT);
        }
        this.result = inputResult;
    }

    public static Result from(String inputResult) {
        return new Result(inputResult);
    }

    String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
