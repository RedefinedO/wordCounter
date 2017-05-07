package com.word.counter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class WordAggegatorTest {

    @Test
    public void emptyStreamsYieldsEmptySetOfWords() {
        Set<Word> words = WordAggregator.countWords(Stream.empty());
        Assert.assertEquals(words.size(), 0);
    }

    @Test
    public void streamOfTwoDifferentWordsYieldsSetOfSize2() {
        Set<Word> words = WordAggregator.countWords(Stream.of("word1", "word2"));
        Assert.assertEquals(words.size(), 2);
    }

    @Test
    public void streamOfTwoEqualsWordsYieldsSetOfSize1() {
        Set<Word> words = WordAggregator.countWords(Stream.of("word", "word"));
        Assert.assertEquals(words.size(), 1);
    }

    @Test
    public void wordsSortedByAppearances() {
        Set<Word> words = WordAggregator.countWords(Stream.of("word1", "word2", "word1"));
        List<Word> wordList = new ArrayList<>(words);
        Assert.assertEquals(words.size(), 2);
        Assert.assertEquals(wordList.get(0).getWord(), "word1");
    }

    @Test
    public void wordsSortedByAppearancesAndThenAlphabetically() {
        Set<Word> words = WordAggregator.countWords(Stream.of("word1", "word2", "word1", "word2", "word3"));
        List<Word> wordList = new ArrayList<>(words);
        Assert.assertEquals(words.size(), 3);
        Assert.assertEquals(wordList.get(0).getWord(), "word1");
        Assert.assertEquals(wordList.get(1).getWord(), "word2");
    }

}
