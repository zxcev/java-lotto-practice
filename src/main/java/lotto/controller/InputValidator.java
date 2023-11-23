package lotto.controller;

import java.util.regex.Pattern;
import lotto.domain.lotto.Lotto;

// TEMPLATE
public final class InputValidator {
    public static final String VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE = "로또 숫자 형식이 일치하지 않습니다.";
    public static final String VALIDATE_NUMERIC_INPUT_MESSAGE = "반드시 숫자를 입력해야 합니다.";
    public static final String VALIDATE_PURCHASE_AMOUNT_INPUT_MESSAGE = "로또 구매 금액은 반드시 1,000원 단위로 떨어져야 합니다.";
    private static final String WINNING_NUMBERS_REGEX = "^(\\d+,){5}(\\d+)$";

    public static void validatePurchaseAmountInput(final String input) {
        validateNumericInput(input);
        final int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount == 0 || (purchaseAmount % Lotto.LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_AMOUNT_INPUT_MESSAGE);
        }
    }

    public static void validateNumericInput(final String input) {
        validateNullAndEmptyInput(input, VALIDATE_NUMERIC_INPUT_MESSAGE);
        for (final char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(VALIDATE_NUMERIC_INPUT_MESSAGE);
            }
        }
    }

    public static void validateWinningNumbersInput(final String input) {
        validateNullAndEmptyInput(input, VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE);
        if (!Pattern.matches(WINNING_NUMBERS_REGEX, input)) {
            throw new IllegalArgumentException(VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE);
        }
    }

    private static void validateNullAndEmptyInput(final String input, final String message) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
