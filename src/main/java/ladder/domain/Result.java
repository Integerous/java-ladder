package ladder.domain;

public class Result {

    private final String result;

    private Result(String inputResult) {
        this.result = inputResult;
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
