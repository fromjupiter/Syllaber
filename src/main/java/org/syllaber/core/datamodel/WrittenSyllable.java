package org.syllaber.core.datamodel;

public class WrittenSyllable implements Syllable {
    private String onset;
    private String nucleus;
    private String coda;

    public WrittenSyllable() {
        onset="";
        nucleus="";
        coda="";
    }
    public WrittenSyllable(String onset, String nucleus, String coda) {
        this.onset = onset;
        this.nucleus = nucleus;
        this.coda = coda;
    }

    @Override
    public boolean isOpenSyllable() {
        return coda.equals("");
    }

    public String appendOnset(char str) {
        this.onset += str;
        return onset;
    }

    public String appendNucleus(char str) {
        this.nucleus += str;
        return nucleus;
    }

    public String appendCoda(char str) {
        this.coda += str;
        return coda;
    }

    @Override
    public String getOnset() {
        return onset;
    }

    public void setOnset(String onset) {
        this.onset = onset;
    }

    @Override
    public String getNucleus() {
        return nucleus;
    }

    public void setNucleus(String nucleus) {
        this.nucleus = nucleus;
    }

    @Override
    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    @Override
    public String toString() {
        return onset+nucleus+coda;
    }
}
