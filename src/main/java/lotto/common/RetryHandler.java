package lotto.common;

import java.util.function.Supplier;

public final class RetryHandler {

    public static <T> T handleRetry(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (final IllegalArgumentException e) {
                System.out.printf("[ERROR]: %s\n", e.getMessage());
            }
        }
    }

}
