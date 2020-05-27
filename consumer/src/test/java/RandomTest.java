import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomTest {
    private final String[] randomNameList = "Nagato,Deidara,Konan,Itachi,Zetsu,Orochimaru,Kisame,Kakuzu,Hidan,Sasori,Obito".split(",");

    @Test
    public void shouldHasOneElementOfEach() {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int index = new Random().nextInt(randomNameList.length);
            set.add(randomNameList[index]);
            list.add(randomNameList[index]);
        }
        List<String> randomNameList = List.of(this.randomNameList);

        randomNameList
                .forEach(it -> {
                    System.out.println(it + ": " + list.stream().filter(inner -> inner.equals(it)).count());
                    assertTrue(set.contains(it));
                });
    }


}