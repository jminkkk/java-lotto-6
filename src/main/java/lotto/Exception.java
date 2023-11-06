package lotto;

public enum Exception {
    ONLY_DIVISIBLE_BY_THOUSAND("구입 금액은 1000원 단위로 입력해주세요."),
    ONLY_NUMERIC_INPUT_FOR_MONEY("구입금액은 숫자만 입력 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}