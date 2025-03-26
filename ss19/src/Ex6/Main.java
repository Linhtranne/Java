
package Ex6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "lambda", "stream", "functional");
        List<String> processedStrings = new ArrayList<>();

        IString processor = String::toUpperCase;

        for (String str : strings) {
            processedStrings.add(processor.processString(str));
        }

        processor.printList(processedStrings);
    }
}