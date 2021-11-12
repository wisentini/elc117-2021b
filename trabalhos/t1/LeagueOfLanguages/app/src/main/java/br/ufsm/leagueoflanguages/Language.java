package br.ufsm.leagueoflanguages;

public class Language {
    private String languageId;
    private String firstAppeared;
    private String paradigm;
    private String userId;

    public Language() {
    }

    public Language(String languageId, String firstAppeared, String paradigm, String userId) {
        this.languageId = languageId;
        this.firstAppeared = firstAppeared;
        this.paradigm = paradigm;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getFirstAppeared() {
        return firstAppeared;
    }

    public void setFirstAppeared(String firstAppeared) {
        this.firstAppeared = firstAppeared;
    }

    public String getParadigm() {
        return paradigm;
    }

    public void setParadigm(String paradigm) {
        this.paradigm = paradigm;
    }

    @Override
    public String toString() {
        String li = "{\n    \"languageId\": \"" + languageId + "\",\n";
        String fa = "    \"firstAppeared\": \"" + firstAppeared + "\",\n";
        String p = "    \"paradigm\": \"" + paradigm + "\",\n";
        String ui = "    \"userId\": \"" + userId + "\"\n}";
        return li + fa + p + ui;
    }
}
