package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.common.RetryHandler;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public final class InputManager {


    public static int inputPurchaseAmount() {
        return RetryHandler.handleRetry(InputManager::_inputPurchaseAmount);
    }

    public static WinningLotto inputWinningLotto() {
        return WinningLotto.from(
                RetryHandler.handleRetry(InputManager::_inputWinningNumbers),
                RetryHandler.handleRetry(InputManager::_inputBonusNumber)
        );
    }

    private static int _inputPurchaseAmount() {
        final String input = InputView.inputPurchaseAmount();
        InputValidator.validatePurchaseAmountInput(input);

        return Integer.parseInt(input);
    }

    private static List<Integer> _inputWinningNumbers() {
        final String input = InputView.inputWinningNumbers();
        InputValidator.validateWinningNumbersInput(input);

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private static int _inputBonusNumber() {
        final String bonusNumberInput = InputView.inputBonusNumber();
        InputValidator.validateNumericInput(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

}
