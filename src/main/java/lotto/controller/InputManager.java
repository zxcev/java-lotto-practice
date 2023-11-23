package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.view.InputView;

public final class InputManager {

    public static int inputPurchaseAmount() {
        final String input = InputView.inputPurchaseAmount();
        InputValidator.validateNumericInput(input);

        return Integer.parseInt(input);
    }

    public static WinningLotto inputWinningLotto() {
        final String winningNumbersInput = InputView.inputWinningNumbers();
        final String bonusNumberInput = InputView.inputBonusNumber();
        InputValidator.validateWinningNumbersInput(winningNumbersInput);
        InputValidator.validateNumericInput(bonusNumberInput);
        return WinningLotto.from(winningNumbersInput, bonusNumberInput);
    }
}
