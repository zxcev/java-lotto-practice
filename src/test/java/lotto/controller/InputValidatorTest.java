package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

final class InputValidatorTest {
    @DisplayName("0 또는 양수로만 구성된 문자열 입력 시 검증 성공")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "01", "123"})
    void validateNumericInput_onlyWithDigitChars_shouldBeOk(final String input) {
        // given
        // when
        // then
        InputValidator.validateNumericInput(input);

    }

    @DisplayName("음수 또는 숫자 외의 문자가 포함된 입력 검증 시 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "x", "1c", "xc"})
    void validateNumericInput_includesNonDigitChars_shouldThrow(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() ->
                InputValidator.validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.VALIDATE_NUMERIC_INPUT_MESSAGE);

    }

    @DisplayName(",로 구분된 숫자로만 이루어진 로또 번호 입력 검증 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5,6,7,8,9"})
    void validate_includesWithCommasSeparatedInput_shouldBeOk(final String input) {
        // given
        // when
        // then
        InputValidator.validateWinningNumbersInput(input);
    }

    @DisplayName("null 또는 콤마(,)나 숫자 외의 문자가 포함된 경우, 형식을 벗어난 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "1,2,3,",
            "4,5,6,7,8,x",
            "1.2.3.4.5.6",
            ",,,,,"
    })
    void validate_includesExceptCommasOrNumbers_shouldThrow(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() ->
                InputValidator.validateWinningNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidator.VALIDATE_WINNING_NUMBERS_INPUT_MESSAGE);

    }

    @DisplayName("형식을 준수한 경우 검증 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3", "1,2"})
    void validate_withCorrectFormat_shouldBeOk(final String input) {
        // given
        // when
        // then
        InputValidator.validateWinningNumbersInput(input);
    }
}