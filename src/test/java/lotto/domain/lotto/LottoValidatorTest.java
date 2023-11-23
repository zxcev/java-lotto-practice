package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class LottoValidatorTest {
    @DisplayName("각 로또 숫자 범위가 1~45에 속하며 중복이 없는 6자리 숫자 List 검증 성공")
    @Test
    void validateAll_withCorrectLenAndRangeAndNotDuplicateNumbers_shouldBeOk() {
        // given
        final List<Integer> lottoNumbers = List.of(
                1, 2, 3, 4, 5, 6
        );
        // when
        // then
        LottoValidator.validateDuplicateNumbers(lottoNumbers);
        LottoValidator.validateLottoNumbersRange(lottoNumbers);
        LottoValidator.validateNumbersLength(lottoNumbers);

    }

    @DisplayName("로또 숫자 중 범위가 1~45 이외인 경우 예외 발생")
    @Test
    void validateLottoRange_withInvalidRange_shouldThrow() {
        // given
        final List<Integer> lottoNumbers = List.of(
                -1, 2, 3, 4, 5, 6
        );
        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.validateLottoNumbersRange(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidator.INVALID_RANGE_MESSAGE);

    }

    @DisplayName("로또 숫자 길이가 6이 아닌 경우 예외 발생")
    @Test
    void validateLottoLength_withInvalidLen_shouldThrow() {
        // given
        final List<Integer> lottoNumbers = List.of(
                1, 2, 3, 4, 5
        );
        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.validateNumbersLength(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidator.INVALID_LEN_MESSAGE);
    }

    @DisplayName("중복 로또 숫자가 존재하는 경우 예외 발생")
    @Test
    void validateDuplicateNumbers_withDuplicateNumbers_shouldThrow() {
        // given
        final List<Integer> lottoNumbers = List.of(
                1, 2, 3, 4, 5, 5
        );
        // when
        // then
        assertThatThrownBy(() ->
                LottoValidator.validateDuplicateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidator.DUPLICATE_MESSAGE);
    }

}