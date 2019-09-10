package org.syllaber.core.parser;

import org.syllaber.core.datamodel.Alphabet;
import org.syllaber.core.datamodel.WrittenSyllable;

import java.util.*;

public class FrenchWrittenSyllableParser extends SyllableParser {
    public void init() {
        alphabet = new Alphabet();

        HashSet<String> vowels = new HashSet<>(Arrays.asList("aeiouœéèàùâêîôûëïüÿ".chars().mapToObj(c -> String.valueOf(c)).toArray(String[]::new)));
        //semi-vowel
        vowels.add("ou");
        vowels.add("y");
        HashSet<String> consonants = new HashSet<>(Arrays.asList("bcdfghjklmnpqrstvwxz".chars().mapToObj(c -> String.valueOf(c)).toArray(String[]::new)));
        consonants.add("ill");
        //semi-vowel
        consonants.add("ou");
        consonants.add("y");

        alphabet.setVowels(vowels);
        alphabet.setConsonants(consonants);
    }
    @Override
    public List<WrittenSyllable> toSyllables(String word) {
        List<WrittenSyllable> res = new LinkedList<>();

        //tokenize
        int cursor=0;
        while (cursor<word.length()) {
            WrittenSyllable syl = new WrittenSyllable();
            boolean allScanned = false;
            for (int i=cursor;i<word.length();++i) {
                allScanned = (i==word.length()-1);
                char ch = word.charAt(i);
                if (alphabet.isVowel(ch)) {
                    syl.appendNucleus(ch);
                } else if (alphabet.isConsonant(ch)) {
                    if (syl.getNucleus().equals("")) {
                        //no nucleus yet, it's onset
                        syl.appendOnset(ch);
                    } else {
                        //see whether it's coda or the onset of next syllable
                        if (i == word.length()-1) {
                            //coda
                            syl.appendCoda(ch);
                            break;
                        } else if (i==word.length()-2 && word.charAt(i+1)=='e') {
                            //coda
                            syl.appendCoda(ch);
                            syl.appendCoda('e');
                            allScanned = true;
                            break;
                        } else if (syl.getCoda().equals("") && !alphabet.isVowel(word.charAt(i+1))) {
                            //coda
                            syl.appendCoda(ch);
                        } else {
                            //onset of next syllable
                            cursor = i;
                            break;
                        }
                    }
                } else {
                    throw new RuntimeException("Unknown character: "+ch);
                }
            }
            res.add(syl);
            if ( allScanned )
                break;
        }
        return res;
    }

    @Deprecated
    public List<WrittenSyllable> toSyllablesDeprecated(String word) {
        List<WrittenSyllable> res = new LinkedList<>();
        int cursor=0;
        while (cursor<word.length()) {
            WrittenSyllable syl = new WrittenSyllable();
            boolean allScanned = false;
            for (int i=cursor;i<word.length();++i) {
                allScanned = (i==word.length()-1);
                char ch = word.charAt(i);
                if (alphabet.isVowel(ch)) {
                    syl.appendNucleus(ch);
                } else if (alphabet.isConsonant(ch)) {
                    if (syl.getNucleus().equals("")) {
                        //no nucleus yet, it's onset
                        syl.appendOnset(ch);
                    } else {
                        //see whether it's coda or the onset of next syllable
                        if (i == word.length()-1) {
                            //coda
                            syl.appendCoda(ch);
                            break;
                        } else if (i==word.length()-2 && word.charAt(i+1)=='e') {
                            //coda
                            syl.appendCoda(ch);
                            syl.appendCoda('e');
                            allScanned = true;
                            break;
                        } else if (syl.getCoda().equals("") && !alphabet.isVowel(word.charAt(i+1))) {
                            //coda
                            syl.appendCoda(ch);
                        } else {
                            //onset of next syllable
                            cursor = i;
                            break;
                        }
                    }
                } else {
                    throw new RuntimeException("Unknown character: "+ch);
                }
            }
            res.add(syl);
            if ( allScanned )
                break;
        }
        return res;
    }
}
