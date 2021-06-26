package com.example.milestone1.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;

public final class FileManagerUtils {

    protected static Logger log = LoggerFactory.getLogger(FileManagerUtils.class);

    public static void readJSONFromFile(String fileName) {

        try {
            File file = ResourceUtils.getFile(fileName);
            System.out.print(file);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
