package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.lotto.Lottos;
import lotto.view.OutputView;

public final class LottoController {

    public static void run() {
        purchaseLottos();
        drawLottos();
    }

    public static void purchaseLottos() {
        final int purchaseAmount = InputManager.inputPurchaseAmount();
        final Lottos lottos = LottoService.purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottos(lottos.toLottosDto());
    }

    public static void drawLottos() {

    }
}
