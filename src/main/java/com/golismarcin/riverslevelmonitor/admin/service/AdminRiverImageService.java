package com.golismarcin.riverslevelmonitor.admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AdminRiverImageService {

    @Value("${riverApp.uploadDir}")
    String uploadDir;

    public String uploadImage(String fileName, InputStream inputStream) {
        String newFilaName = UploadedFileNameUtils.slugifyFileName(fileName);
        newFilaName = ExistingFileUtils.renameIfExists(Path.of(uploadDir), newFilaName);

        Path filePath = Paths.get(uploadDir).resolve(newFilaName);
        try(OutputStream outputStream = Files.newOutputStream(filePath)) {
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            throw new RuntimeException("Nie moge zapisać pliku", e);
        }
        return newFilaName;
    }

    public Resource serveFiles(String filename) {
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        return fileSystemResourceLoader.getResource(uploadDir + filename);
    }
}
