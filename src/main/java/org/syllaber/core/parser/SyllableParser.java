package org.syllaber.core.parser;

import org.syllaber.core.datamodel.Alphabet;
import org.syllaber.core.datamodel.Syllable;
import org.syllaber.core.datamodel.WrittenSyllable;

import java.util.*;

public abstract class SyllableParser {
    protected Alphabet alphabet;
    public abstract void init();

    public List<? extends Syllable> toSyllables(String word) {
        List<WrittenSyllable> res = new LinkedList<>();

        Set<String> validTokens = new HashSet<>(alphabet.getVowels());
        validTokens.addAll(alphabet.getConsonants());
        Iterator<String> iter = new TokenIterator(word,validTokens);
        while(iter.hasNext()) {
            String token = iter.next();
        }

        return res;
    }

    private class TokenIterator implements Iterator<String> {
        List<String> orderedTokenList;
        String sequence;
        int currentIndex=0;

        public TokenIterator(String str,Set<String> tokenSet) {
            this.sequence = str;
            this.orderedTokenList = new ArrayList<>(tokenSet);
            this.orderedTokenList.sort( (o1,o2) -> -1*o1.compareTo(o2) );
        }

        @Override
        public boolean hasNext() {
            return currentIndex < sequence.length();
        }

        @Override
        public String next() {
            //greedy algorithm
            return null;
        }
    }
}
