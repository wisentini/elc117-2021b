import java.util.Arrays;

import java.util.stream.Collectors;

public class SharedArray {
    private Character[] array;
    private int index = 0;

    public SharedArray(int n) {
        array = new Character[n];
        Arrays.fill(array, '-');
    }

    public synchronized void addChar(char c) {
        // public void addChar(char c) {
        array[index] = c;
        spendSomeTime();
        index++;
    }

    // Length of filtered array (functional approach, using stream and lambda)
    public int countOccurrences(char c) {
        return Arrays.asList(array).stream().filter(i -> (i == c)).collect(Collectors.toList()).size();
    }

    // Same as above (imperative approach)
    public int oldCountOccurrences(char c) {
        int count = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                count++;
            }
        }

        return count;
    }

    private void spendSomeTime() {
        int i = 0;

        for (; i < 1000000; i++) {}

        i++;
    }

    @Override
    public String toString() {
        return Arrays.stream(array).map(Object::toString).collect(Collectors.joining());
    }
}
