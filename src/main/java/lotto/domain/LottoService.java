package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.Lottos;

public final class LottoService {

    public static Lottos purchaseLottos(final int purchaseAmount) {
        int remainedAmount = purchaseAmount;
        final List<Lotto> purchasedLottos = new ArrayList<>();

        while (remainedAmount >= Lotto.LOTTO_PRICE) {
            final Lotto lotto = LottoGenerator.generate();
            purchasedLottos.add(lotto);
            remainedAmount -= Lotto.LOTTO_PRICE;
        }
        return new Lottos(purchasedLottos);
    }

}
