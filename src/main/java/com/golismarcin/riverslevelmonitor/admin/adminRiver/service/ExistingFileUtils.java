package com.golismarcin.riverslevelmonitor.admin.adminRiver.service;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;

class ExistingFileUtils {

    public static String renameIfExists(Path uploadDir, String filaName) {
        if(Files.exists(uploadDir.resolve(filaName))){
            return checkAndRename(uploadDir, filaName);
        }
        return filaName;
    }

    private static String checkAndRename(Path uploadDir, String fileName) {
        String newFileName = renameFileName(fileName);
        if(Files.exists(uploadDir.resolve(newFileName))){
            newFileName = checkAndRename(uploadDir, newFileName);
        }
        return newFileName;
    }

    private static String renameFileName(String fileName) {
        String baseName = FilenameUtils.getBaseName(fileName);
        String[] split = baseName.split("-(?=[0-9]+$)");
        int counter = split.length > 1 ? Integer.parseInt(split[1]) + 1 : 1;
        return split[0]+ "-" + counter + "." + FilenameUtils.getExtension(fileName);
    }
}
