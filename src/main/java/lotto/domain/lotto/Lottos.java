package lotto.domain.lotto;

import java.util.List;
import lotto.controller.dto.LottosDto;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDto toLottosDto() {
        return new LottosDto(
                lottos.stream()
                        .map(Lotto::toLottoDto)
                        .toList()
        );
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
