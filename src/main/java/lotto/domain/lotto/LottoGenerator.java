package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class LottoGenerator {

    public static Lotto generate() {
        final Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < Lotto.NUMBERS_LENGTH) {
            final int number = generateNumber();
            uniqueNumbers.add(number);
        }

        return Lotto.from(
                new ArrayList<>(uniqueNumbers)
        );
    }

    private static int generateNumber() {
        return Randoms.pickNumberInRange(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER
        );

    }
}
