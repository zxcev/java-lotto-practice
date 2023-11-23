package lotto.view;

import java.util.stream.Collectors;
import lotto.controller.dto.LottoDrawResult;
import lotto.controller.dto.LottoDto;
import lotto.controller.dto.LottosDto;

public final class OutputView {

    public static void printPurchasedLottos(final LottosDto lottosDto) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottosDto.lottoDtos().size());
        final String rendered = renderLottosDto(lottosDto);
        System.out.println(rendered);
    }

    public static void printDrawingResult(final LottoDrawResult result) {
        System.out.printf("""
                                        
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        총 수익률은 %.1f%%입니다.
                        """.stripIndent(),
                result.fifth(),
                result.fourth(),
                result.third(),
                result.second(),
                result.first(),
                result.totalEarningReturn()
        );
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
