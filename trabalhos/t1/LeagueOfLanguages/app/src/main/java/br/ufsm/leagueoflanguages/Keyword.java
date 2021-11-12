package br.ufsm.leagueoflanguages;

public class Keyword {
    private String languageId;
    private String keyword;
    private String description;
    private String userId;

    public Keyword() {
    }

    public Keyword(String languageId, String description, String keyword, String userId) {
        this.languageId = languageId;
        this.description = description;
        this.keyword = keyword;
        this.userId = userId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        String li = "{\n    \"languageId\": \"" + this.languageId + "\",\n";
        String k = "    \"keyword\": \"" + this.keyword + "\",\n";
        String d = "    \"description\": \"" + this.description + "\",\n";
        String ui = "    \"userId\": \"" + this.userId + "\"\n}";
        return li + k + d + ui;
    }
}
