package com.golismarcin.riverslevelmonitor.admin.common.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlugifyRegionNameUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "test test.png, test-test.png",
            "ąęśćżźńłó.png, aesczznlo.png",
            "test test.png, test-test.png",
            "Foto 1.png, foto-1.png",
            "Foto_1.png, foto-1.png",
            "Foto__1.png, foto-1.png",
    })
    void shouldSlugifyFileName(String in, String out){
        String filename = SlugifyUtils.slugifyFileName(in);
        assertEquals(filename,out);
    }


}