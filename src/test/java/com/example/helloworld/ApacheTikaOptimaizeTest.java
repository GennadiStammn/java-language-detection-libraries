package com.example.helloworld;

import org.apache.tika.langdetect.optimaize.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApacheTikaOptimaizeTest {
    @Test
    void detectsLanguages() {
        LanguageDetector detector = new OptimaizeLangDetector().loadModels();

        var result = detector.detect("""
                The weather is pleasant today, so I am going to walk through the park
                and read a book beside the lake.
                """);
        assertEquals("en", result.getLanguage());

        result = detector.detect("""
                Oggi ho mangiato la pizza. E poi ho bevuto un caffè.
                """);
        assertEquals("it", result.getLanguage());

        result = detector.detect("""
                Aujourd'hui, j'ai mangé une pizza. Et puis j'ai bu un café.
                """);
        assertEquals("fr", result.getLanguage());
    }
}
