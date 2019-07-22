package com.trustbirungi.symbol_tables;

import java.util.HashMap;

/**
 * Class: SentenceStringCounter
 * Description: This class does several string operations such as determining the commonest word in a sentence,
 * how many times a word appears in a sentence, etc.
 * @author trustbirungi
 */
public class SentenceStringCounter {
    public static void main(String[] args) {
        SentenceStringCounter counter = new SentenceStringCounter();

        String sentence = "this sentence contains this word multiple times like at this point and at this point and " +
                "even this point plus also at this point";

        System.out.println("The commonest word in the sentence is " + counter.findCommonestWord(sentence));

    }

    private String findCommonestWord(String sentence) {
        HashMap<String, Integer> commonestWord = new HashMap<String, Integer>();

        HashMap<String, Integer> individualWords = new HashMap<String, Integer>();

        String[] separatedSentence = sentence.trim().split("\\s+");;



        for (String word: separatedSentence) {
            if(!individualWords.containsKey(word)) {
                individualWords.put(word, 1);
            } else {
                individualWords.put(word, individualWords.get(word) + 1);
            }
        }

        String max = "";
        individualWords.put(max, 0);


        for (String word:individualWords.keySet()) {
            if(individualWords.get(word) > individualWords.get(max)) {
                max = word;
            }
        }

        commonestWord.put(max, individualWords.get(max));


        return commonestWord.keySet().toString();
    }

}
