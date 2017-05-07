package com.word.counter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Word implements Comparable<Word> {

    private final String word;
    private final Long appearances;

    @Override
    public int compareTo(Word other) {
        int appearencesCompare = other.getAppearances().compareTo(appearances);
        return appearencesCompare == 0 ? word.compareTo(other.getWord()) : appearencesCompare;
    }

    @Override
    public String toString() {
        return word + "=" + appearances;
    }
}
