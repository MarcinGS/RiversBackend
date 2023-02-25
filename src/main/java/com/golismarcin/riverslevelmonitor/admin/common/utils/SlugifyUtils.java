package com.golismarcin.riverslevelmonitor.admin.common.utils;

import com.github.slugify.Slugify;
import org.apache.commons.io.FilenameUtils;

public class SlugifyUtils {

    public static String slugifyFileName(String fileName){
        String name = FilenameUtils.getBaseName(fileName);
        Slugify slg = Slugify.builder()
                .customReplacement("_","-").build();

        return slg.slugify(name) + "." + FilenameUtils.getExtension(fileName);
    }
}
