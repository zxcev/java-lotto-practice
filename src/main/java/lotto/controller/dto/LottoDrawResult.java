package lotto.controller.dto;

public record LottoDrawResult(
        int first,
        int second,
        int third,
        int fourth,
        int fifth,
        double totalEarningReturn
) {
}
