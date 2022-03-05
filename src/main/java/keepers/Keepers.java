package keepers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Keepers {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    List<String> filterEmojies(List<String> messages) {
        List<String> filteredMeaasges = new ArrayList<>();
        messages.stream().forEach(m -> CompletableFuture
                .supplyAsync(() -> {
                    return m.replaceAll("[\ud83c\udf00-\ud83d\ude4f]|[\ud83d\ude80-\ud83d\udeff]", "");
                }, executor)
                .thenApply(f -> filteredMeaasges.add(f)));
        return filteredMeaasges;
    }

}
