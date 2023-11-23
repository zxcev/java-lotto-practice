package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    // 1. 금액 입력
    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    // 2. 당첨 번호 입력
    public static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return readLine();
    }

    // 3. 보너스 번호 입력
    public static String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return readLine();
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}
