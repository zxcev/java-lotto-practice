package lotto.domain;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoValidator;

public final class WinningLotto {

    private final Lotto winningLotto;

    private final int bonusNumber;

    public WinningLotto(
            final Lotto winningLotto,
            final int bonusNumber
    ) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(
            final List<Integer> winningNumbers,
            final int bonusNumberInput
    ) {
        final Lotto lotto = new Lotto(winningNumbers);
        LottoValidator.validateLottoNumberRange(bonusNumberInput);
        return new WinningLotto(
                lotto,
                bonusNumberInput
        );
    }

    public boolean hasBonusNumber(final Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int calcMatchCount(final Lotto lotto) {
        return winningLotto.calcMatchCount(lotto);
    }

}
