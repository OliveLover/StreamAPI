package streamOperator.terminalOperations;

import java.util.stream.Stream;

public class toArray {
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Stream<String> colorStream = Stream.of(colors);

        Object[] colorArray = colorStream.toArray();

        for (Object color : colorArray) {
            System.out.println(color);
        }
    }
}
