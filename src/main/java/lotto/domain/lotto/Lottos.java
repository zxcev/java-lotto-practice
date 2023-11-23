package lotto.domain.lotto;

import java.util.List;
import lotto.controller.dto.LottosDto;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos.stream()
                .sorted()
                .toList();
    }

    public LottosDto toLottosDto() {
        // TODO
        return null;
    }
}
