package com.golismarcin.riverslevelmonitor.admin.common.utils;

import com.github.slugify.Slugify;
import org.apache.commons.io.FilenameUtils;

public class SlugifyUtils {

    public static String slugifyFileName(String fileName){
        String name = FilenameUtils.getBaseName(fileName);
        Slugify slg = new Slugify();
        String changedName = slg
                .withCustomReplacement("_","-")
                .slugify(name);
        return changedName + "." + FilenameUtils.getExtension(fileName);
    }
}
