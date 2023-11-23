package lotto.controller;

import lotto.controller.dto.LottoDrawResult;
import lotto.domain.LottoService;
import lotto.domain.WinningLotto;
import lotto.domain.lotto.Lottos;
import lotto.view.OutputView;

public final class LottoController {

    public static void run() {
        final Lottos purchasedLottos = purchaseLottos();
        drawLottos(purchasedLottos);
    }

    public static Lottos purchaseLottos() {
        final int purchaseAmount = InputManager.inputPurchaseAmount();
        final Lottos purchasedLottos = LottoService.purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottos(purchasedLottos.toLottosDto());

        return purchasedLottos;
    }

    public static void drawLottos(final Lottos purchasedLottos) {
        final WinningLotto winningLotto = InputManager.inputWinningLotto();
        final LottoDrawResult result = LottoService.drawLottos(purchasedLottos, winningLotto);
        OutputView.printDrawingResult(result);
    }
}
