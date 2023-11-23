package lotto.domain.lotto;

import java.util.EnumMap;
import lotto.controller.dto.LottoDrawResult;
import lotto.domain.WinningLotto;

public final class LottosDrawData {

    private final EnumMap<LottoReward, Integer> rewardsMap;
    private final WinningLotto winningLotto;

    private double totalPurchaseAmount = 0;
    private double totalPrizeAmount = 0;

    public LottosDrawData(final WinningLotto winningLotto) {
        this.rewardsMap = new EnumMap<>(LottoReward.class);
        this.winningLotto = winningLotto;
    }

    public void drawLotto(final Lotto lotto) {
        final boolean hasBonusNumber = winningLotto.hasBonusNumber(lotto);
        final int matchCount = winningLotto.calcMatchCount(lotto);
        final LottoReward lottoReward = LottoReward.of(matchCount, hasBonusNumber);
        save(lottoReward);
    }

    private void save(final LottoReward lottoReward) {
        final int prevCount = getCountOf(lottoReward);
        rewardsMap.put(lottoReward, prevCount + 1);
        totalPrizeAmount += lottoReward.getPrizeAmount();
        totalPurchaseAmount += Lotto.LOTTO_PRICE;
    }

    private int getCountOf(final LottoReward reward) {
        return rewardsMap.getOrDefault(reward, 0);
    }

    public LottoDrawResult toLottoDrawResult() {
        return new LottoDrawResult(
                getCountOf(LottoReward.FIRST),
                getCountOf(LottoReward.SECOND),
                getCountOf(LottoReward.THIRD),
                getCountOf(LottoReward.FOURTH),
                getCountOf(LottoReward.FIRST),
                calcTotalEarningReturn()
        );
    }

    private double calcTotalEarningReturn() {
        final double earningReturn = totalPrizeAmount / totalPurchaseAmount * 100;
        return Math.round(earningReturn * 10) / 10.0;
    }

}
