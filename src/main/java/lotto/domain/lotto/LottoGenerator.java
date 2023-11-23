package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class LottoGenerator {

    public static Lotto generate() {
        return Lotto.from(generateNumber());
    }

    private static List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER,
                Lotto.NUMBERS_LENGTH
        );

    }
}
