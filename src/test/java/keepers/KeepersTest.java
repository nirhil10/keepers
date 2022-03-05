package keepers;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class KeepersTest {

    Keepers keepers = new Keepers();

    @Test
    public void test() {
        List<String> messages = List.of("message with 😀 😁 🏁 🍌", "message without emoji");
        List<String> expected = List.of("message with    ", "message without emoji");
        List<String> filteredMessages = keepers.filterEmojies(messages);
        Assertions.assertThat(filteredMessages).isEqualTo(expected);
    }
}
