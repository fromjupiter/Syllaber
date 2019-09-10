package org.syllaber.core.datamodel;

/**
 * Created by ThinkPad on 2017/5/29.
 */
public interface Syllable {
    boolean isOpenSyllable();
    String getOnset();
    String getNucleus();
    String getCoda();
}
