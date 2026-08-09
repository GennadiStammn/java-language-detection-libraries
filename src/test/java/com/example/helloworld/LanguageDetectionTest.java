package com.example.helloworld;

import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageDetectionTest {
    @Test
    void detectsLanguages() throws IOException {
        String english = "Some may say, I don't know anything. But why?";
        String italian = "Oggi ho mangiato la pizza. E poi ho bevuto un caffè.";
        String french = "Aujourd'hui, j'ai mangé une pizza. Et puis j'ai bu un café.";

        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
        var detector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .withProfiles(languageProfiles)
                .build();

        assertEquals("en", detector.detect(english).transform(LdLocale::getLanguage).orNull());
        assertEquals("it", detector.detect(italian).transform(LdLocale::getLanguage).orNull());
        assertEquals("fr", detector.detect(french).transform(LdLocale::getLanguage).orNull());
    }
}
