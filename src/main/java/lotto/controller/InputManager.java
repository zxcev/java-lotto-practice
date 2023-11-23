package lotto.controller;

import java.util.Arrays;
import java.util.List;
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

        return WinningLotto.from(
                toChunks(winningNumbersInput),
                Integer.parseInt(bonusNumberInput)
        );
    }

    private static List<Integer> toChunks(final String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map((Integer::parseInt))
                .toList();
    }
}
