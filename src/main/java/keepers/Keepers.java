package keepers;

import java.util.List;
import java.util.stream.Collectors;

public class Keepers {

    List<String> filterEmojies(List<String> messages) {
        return messages.stream().map(m -> m.replaceAll("[\ud83c\udf00-\ud83d\ude4f]|[\ud83d\ude80-\ud83d\udeff]", ""))
                .collect(Collectors.toList());
    }
}
