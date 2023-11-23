package lotto.controller;

import java.util.regex.Pattern;

// TEMPLATE
public final class InputValidator {
    public static final String VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE = "로또 숫자 형식이 일치하지 않습니다.";
    public static final String VALIDATE_NUMERIC_INPUT_MESSAGE = "반드시 숫자를 입력해야 합니다.";
    private static final String WINNING_NUMBERS_REGEX = "^(\\d+,)+(\\d+)$";

    public static void validateNumericInput(final String input) {
        for (final char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(VALIDATE_NUMERIC_INPUT_MESSAGE);
            }
        }
    }

    public static void validateWinningNumbersInput(final String input) {
        if (!Pattern.matches(WINNING_NUMBERS_REGEX, input)) {
            throw new IllegalArgumentException(VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE);
        }
    }


}
