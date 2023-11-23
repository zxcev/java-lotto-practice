package lotto.domain.lotto;

import java.util.List;

public enum LottoReward {
    X(0, 0, false),
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    ;

    private static final List<LottoReward> lottoRewards = List.of(values());
    private final int matchCount;

    private final int prizeAmount;

    private final boolean hasBonusNumber;

    LottoReward(
            final int matchCount,
            final int prizeAmount,
            final boolean hasBonusNumber
    ) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoReward of(
            final int matchCount,
            final boolean hasBonusNumber
    ) {
        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }

        return lottoRewards.stream()
                .filter(l -> !l.hasBonusNumber)
                .filter(l -> l.matchCount == matchCount)
                .findFirst()
                .orElse(X);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
