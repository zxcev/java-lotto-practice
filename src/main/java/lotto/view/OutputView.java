package lotto.view;

import java.util.stream.Collectors;
import lotto.controller.dto.LottoDto;
import lotto.controller.dto.LottosDto;

public final class OutputView {

    public static void printPurchasedLottos(final LottosDto lottosDto) {
        System.out.println("\n8개를 구매했습니다.");
        final String rendered = renderLottosDto(lottosDto);
        System.out.println(rendered);
    }

    public static void printDrawingResult() {
        // TODO
        System.out.println("\n당첨 통계\n---\n");
    }

    private static String renderLottosDto(final LottosDto lottosDto) {
        return lottosDto.lottoDtos()
                .stream()
                .map(OutputView::renderLottoDto)
                .collect(Collectors.joining("\n"));

    }

    private static String renderLottoDto(final LottoDto lottoDto) {
        final String rendered = lottoDto.numbers()
                .stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        return String.format("[%s]", rendered);

    }
}
