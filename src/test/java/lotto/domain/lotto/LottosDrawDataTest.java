package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.controller.dto.LottoDrawResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class LottosDrawDataTest {
    @DisplayName("로또 추첨 테스트")
    @Test
    void test_draw_lottos() {
        // given
        final WinningLotto winningLotto = createWinningLotto(7, 1, 2, 3, 4, 5, 6);
        final LottosDrawData lottosDrawData = new LottosDrawData(winningLotto);

        final List<Lotto> lottos = List.of(
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 7),
                createLotto(1, 2, 3, 4, 5, 10),
                createLotto(1, 2, 3, 4, 10, 11),
                createLotto(1, 2, 3, 9, 10, 11)
        );
        // when
        lottosDrawData.drawLotto(lottos.get(0));
        lottosDrawData.drawLotto(lottos.get(1));
        lottosDrawData.drawLotto(lottos.get(2));
        lottosDrawData.drawLotto(lottos.get(3));
        lottosDrawData.drawLotto(lottos.get(4));

        final LottoDrawResult lottoDrawResult = lottosDrawData.toLottoDrawResult();

        // then
        assertThat(lottoDrawResult.first()).isEqualTo(1);
        assertThat(lottoDrawResult.second()).isEqualTo(1);
        assertThat(lottoDrawResult.third()).isEqualTo(1);
        assertThat(lottoDrawResult.fourth()).isEqualTo(1);
        assertThat(lottoDrawResult.fifth()).isEqualTo(1);

    }

    @DisplayName("수익률 테스트")
    @Test
    void test_earning_rate_lottos() {
        // 50000(fourth)
        // 3000(purchase)

        // 50000/3000 * 100 -> 1666.7

        // given
        final WinningLotto winningLotto = createWinningLotto(7, 1, 2, 3, 4, 5, 6);
        final LottosDrawData lottosDrawData = new LottosDrawData(winningLotto);

        final List<Lotto> lottos = List.of(
                // fourth
                createLotto(1, 2, 3, 4, 10, 11),
                // fifth
                createLotto(1, 2, 9, 10, 11, 12),
                createLotto(1, 2, 9, 10, 11, 12)
        );
        // when
        lottosDrawData.drawLotto(lottos.get(0));
        lottosDrawData.drawLotto(lottos.get(1));
        lottosDrawData.drawLotto(lottos.get(2));

        final LottoDrawResult lottoDrawResult = lottosDrawData.toLottoDrawResult();

        // then
        assertThat(lottoDrawResult.fourth())
                .isEqualTo(1);

        assertThat(lottoDrawResult.totalEarningReturn())
                .isEqualTo(1666.7);

    }

    private Lotto createLotto(final int... numbers) {
        return new Lotto(Arrays.stream(numbers).boxed().toList());
    }

    private WinningLotto createWinningLotto(final int bonusNumber, final int... numbers) {
        return new WinningLotto(
                createLotto(numbers),
                bonusNumber
        );
    }
}