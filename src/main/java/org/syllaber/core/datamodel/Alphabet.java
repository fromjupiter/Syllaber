package org.syllaber.core.datamodel;

import java.util.Set;

/**
 * Created by ThinkPad on 2017/5/29.
 */
public class Alphabet {
    private Set<String> vowels;

    private Set<String> consonants;

    public boolean isVowel(char c) {
        return vowels.contains(String.valueOf(c));
    }

    public boolean isVowel(String str) {
        return vowels.contains(str);
    }

    public boolean isConsonant(char c) {
        return consonants.contains(String.valueOf(c));
    }

    public boolean isConsonant(String str) {
        return consonants.contains(str);
    }

    public boolean isSemivowel(char c) {
        return isVowel(c) && isConsonant(c);
    }

    public boolean isSemivowel(String str) {
        return isVowel(str) && isConsonant(str);
    }

    public Set<String> getVowels() {
        return vowels;
    }

    public void setVowels(Set<String> vowels) {
        this.vowels = vowels;
    }

    public Set<String> getConsonants() {
        return consonants;
    }

    public void setConsonants(Set<String> consonants) {
        this.consonants = consonants;
    }

}
