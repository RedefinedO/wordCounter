package com.word.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String REGEX = "[\\s.,]+";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("There should be 2 input elements: <file name> <how much words to show>");
            System.exit(1);
        }

        try (final BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(args[0]))) {
            Set<Word> words = WordAggregator.countWords(extactWords(bufferedReader));

            WordAggregator.showFirstMostFrequent(words, Long.valueOf(args[1]));
        } catch (IOException ioe) {
            System.err.println("Exception happened " + ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Cannot parse number from string " + args[1]);
        }
    }

    private static Stream<String> extactWords(BufferedReader bufferedReader) {
        return bufferedReader.lines().flatMap(line -> Stream.of(line.split(REGEX)));
    }
}
