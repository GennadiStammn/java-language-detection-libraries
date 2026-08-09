package com.example.helloworld;

import org.apache.tika.langdetect.charsoup.CharSoupLanguageDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApacheCharsoupTest {

    @Test
    void detectsLanguages() throws IOException {
        LanguageDetector detector = new CharSoupLanguageDetector().loadModels();

        var result = detector.detect("""
                The weather is pleasant today, so I am going to walk through the park
                and read a book beside the lake.
                """);
        assertEquals("eng", result.getLanguage());

        result = detector.detect("""
                Oggi ho mangiato la pizza. E poi ho bevuto un caffè.
                """);
        assertEquals("ita", result.getLanguage());

        result = detector.detect("""
                Aujourd'hui, j'ai mangé une pizza. Et puis j'ai bu un café.
                """);
        assertEquals("fra", result.getLanguage());
    }

}
