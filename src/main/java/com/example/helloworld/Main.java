package com.example.helloworld;

import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;

import java.io.IOException;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws IOException {
        // optimaize language detector
        String englisch = "Some may say, I don't know anything. But why? And where is the coffe shop?";
        String italian = "Oggi ho mangiato la pizza. E poi ho bevuto un caffè.";
        String french = "Aujourd'hui, j'ai mangé une pizza. Et puis j'ai bu un café.";

        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
        var detector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .withProfiles(languageProfiles)
                .build();

        System.out.println(detector.detect(englisch).transform(LdLocale::getLanguage));
        System.out.println(detector.detect(italian).transform(LdLocale::getLanguage));
        System.out.println(detector.detect(french).transform(LdLocale::getLanguage));

    }
}
