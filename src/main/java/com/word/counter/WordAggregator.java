package com.word.counter;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordAggregator {

    static Set<Word> countWords(Stream<String> words) {
        return words.map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> Word.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    static void showFirstMostFrequent(Set<Word> words, long firstMostFrequent) {
        if (firstMostFrequent < 0 || firstMostFrequent > words.size()) {
            System.err.println("Number of words to show is too negative or too big");
        } else {
            words.stream()
                    .limit(firstMostFrequent)
                    .forEach(System.out::println);

        }
    }

}
