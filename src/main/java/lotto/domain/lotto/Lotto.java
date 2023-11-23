package lotto.domain.lotto;

import java.util.List;
import lotto.controller.dto.LottoDto;

public final class Lotto {

    public static final int LOTTO_PRICE = 1_000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoDto toLottoDto() {
        return new LottoDto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calcMatchCount(final Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }
}
