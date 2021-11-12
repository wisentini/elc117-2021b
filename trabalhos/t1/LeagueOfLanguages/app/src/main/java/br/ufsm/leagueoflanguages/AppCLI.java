package br.ufsm.leagueoflanguages;

import java.util.*;

public class AppCLI {
    public static void main(String[] args) throws Exception {
        switch (args[0]) {
            case "saveLanguage":
                saveLanguage(args);
                break;
            case "findAllLanguages":
                findAllLanguages();
                break;
            case "listAllLanguagesByOrderOfAppearance":
                listAllLanguagesByOrderOfAppearance();
                break;
            default:
                System.out.println("Invalid operation: " + args[0]);
        }
    }

    private static void saveLanguage(String[] args) throws Exception {
        String languageId = args[1];
        String firstAppeared = args[2];
        String paradigm = args[3];
        String userId = args[4];

        LanguageRepository languageRepository = new LanguageRepository();
        boolean userIdIsValid = false;

        try {
            userIdIsValid = languageRepository.validateUserId(userId);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        if (!userIdIsValid) return;

        Language language = new Language(languageId, firstAppeared, paradigm, userId);
        String result = languageRepository.save(language);
        System.out.println(result);
    }

    private static void findAllLanguages() throws Exception {
        LanguageRepository languageRepository = new LanguageRepository();
        List<Language> languages = languageRepository.findAll();
        listLanguages(languages);
    }

    private static void listAllLanguagesByOrderOfAppearance() throws Exception {
        LanguageRepository languageRepository = new LanguageRepository();
        List<Language> languages = languageRepository.getLanguagesByOrderOfAppearance();
        listLanguages(languages);
    }

    private static void listLanguages(List<Language> languages) throws Exception {
        System.out.println();

        for (int i = 0; i < languages.size(); i++) {
            System.out.print(languages.get(i));

            if (i != languages.size() - 1) {
                System.out.println(",");
            }
        }
        
        System.out.println();
    }
}
