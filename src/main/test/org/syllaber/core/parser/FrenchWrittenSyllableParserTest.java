package org.syllaber.core.parser;


import org.junit.Assert;
import org.junit.Test;
import org.syllaber.core.datamodel.WrittenSyllable;

import java.util.List;

public class FrenchWrittenSyllableParserTest {
    @Test
    public void testParseToSyllables() {
        //String word = "intéressant";
        String word = "travailler";
        SyllableParser sp = new FrenchWrittenSyllableParser();
        sp.init();
        List<WrittenSyllable> writtenSyllables = sp.toSyllables(word);
        Assert.assertEquals(writtenSyllables.size(),4);
    }
}
