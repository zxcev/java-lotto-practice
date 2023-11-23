package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class LottoValidator {

    public static final String INVALID_LEN_MESSAGE = "로또 번호는 반드시 6자리여야 합니다.";
    public static final String DUPLICATE_MESSAGE = "로또 번호에 중복이 존재해서는 안 됩니다.";
    public static final String INVALID_RANGE_MESSAGE = "로또 번호는 반드시 1~45 범위 내에 속해야 합니다.";

    // 1. 길이
    public static void validateNumbersLength(final List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.NUMBERS_LENGTH) {
            throw new IllegalArgumentException(INVALID_LEN_MESSAGE);
        }
    }

    // 2. 중복 번호
    public static void validateDuplicateNumbers(final List<Integer> lottoNumbers) {
        final int uniqueSize = new HashSet<>(lottoNumbers).size();

        if (uniqueSize != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    // 3. 로또 번호 범위
    public static void validateLottoNumbersRange(final List<Integer> lottoNumbers) {
        for (final int lottoNumber : lottoNumbers) {
            validateLottoNumberRange(lottoNumber);
        }
    }

    public static void validateBonusNumberDuplicate(
            final List<Integer> lottoNumbers,
            final int bonusNumber
    ) {
        final List<Integer> numbers = new ArrayList<>(lottoNumbers);
        numbers.add(bonusNumber);

        validateLottoNumberRange(bonusNumber);
        validateDuplicateNumbers(numbers);
    }

    public static void validateLottoNumberRange(final int lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || lottoNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }
}
