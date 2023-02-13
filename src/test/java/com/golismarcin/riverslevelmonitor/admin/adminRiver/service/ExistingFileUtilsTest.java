package com.golismarcin.riverslevelmonitor.admin.adminRiver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExistingFileUtilsTest {

    @Test
    void shouldRenameFileName(@TempDir Path temp) throws IOException {
        String newFileName = ExistingFileUtils.renameIfExists(temp, "test.png");
        assertEquals("test.png", newFileName);
    }

    @Test
    void shouldNotRenameFileName(@TempDir Path temp) throws IOException {
        Files.createFile(temp.resolve("test.png"));
        String newFileName = ExistingFileUtils.renameIfExists(temp, "test.png");
        assertEquals("test-1.png", newFileName);
    }

    @Test
    void shouldRenameFileNameManyTimes(@TempDir Path temp) throws IOException {
        Files.createFile(temp.resolve("test.png"));
        Files.createFile(temp.resolve("test-1.png"));
        Files.createFile(temp.resolve("test-2.png"));
        String newFileName = ExistingFileUtils.renameIfExists(temp, "test.png");
        assertEquals("test-3.png", newFileName);
    }

}