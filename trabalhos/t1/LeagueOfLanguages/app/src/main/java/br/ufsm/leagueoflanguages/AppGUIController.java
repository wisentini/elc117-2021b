package br.ufsm.leagueoflanguages;

import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.List;

public class AppGUIController {
    private AppGUIView view;

    public AppGUIController(AppGUIView view) {
        this.view = view;
    }

    public void init() {
        view.getSaveLanguageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String languageId = view.getLanguageIdTextField().getText();
                String firstAppeared = view.getFirstAppearedTextField().getText();
                String paradigm = view.getParadigmTextField().getText();
                String userId = view.getUserIdTextField().getText();
                view.getTextArea().setText(saveLanguage(languageId, firstAppeared, paradigm, userId));
            }
        });

        view.getListAllLinguagesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTextArea().append(getListOfAllLanguages());
            }
        });
    }

    private String saveLanguage(String languageId, String firstAppeared, String paradigm, String userId) {
        String[] args = {languageId, firstAppeared, paradigm, userId};

        if (argsAreEmpty(args)) return "Error: no fields can be empty.";

        LanguageRepository languageRepository = new LanguageRepository();
        boolean userIdIsValid = false;

        try {
            userIdIsValid = languageRepository.validateUserId(userId);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (!userIdIsValid) return "Error: invalid userId.";

        Language language = new Language(languageId, firstAppeared, paradigm, userId);
        String result = "Error: failed to save language.";

        try {
            result = languageRepository.save(language);
            result += "\n\n" + language.toString();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    private String getListOfAllLanguages() {
        LanguageRepository languageRepository = new LanguageRepository();
        List<Language> languages = null;

        try {
            languages = languageRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }

        return languagesListToJSON(languages);
    }

    private String languagesListToJSON(List<Language> languages) {
        String content = "";

        for (int i = 0; i < languages.size(); i++) {
            content += languages.get(i).toString();

            if (i != languages.size() - 1) {
                content += ",\n";
            }
        }

        return content;
    }

    private boolean argsAreEmpty(String[] args) {
        for (String arg : args) {
            if (arg.isEmpty() || arg.isBlank()) {
                return true;
            }
        }

        return false;
    }
}
