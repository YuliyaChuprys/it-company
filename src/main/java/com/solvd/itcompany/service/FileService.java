package com.solvd.itcompany.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.apache.commons.lang3.CharEncoding.UTF_8;

public class FileService {

    public List<String> readFile(String source) throws IOException {
        File file = new File(source);
        String lines = FileUtils.readFileToString(file, UTF_8);
        lines = lines.toLowerCase().replaceAll("[^a-z0-9]", " ");
        return new ArrayList<>(Arrays.asList(StringUtils.split(lines)));
    }

    public HashMap<String, Integer> countWord(List<String> doc) {
        HashMap<String, Integer> fileMap = new HashMap<>();
        for (String word : doc) {
            if (fileMap.containsKey(word)) {
                fileMap.put(word, fileMap.get(word) + 1);
            } else {
                fileMap.put(word, 1);
            }
        }
        return fileMap;
    }

    public StringBuilder sortBy(HashMap<String, Integer> fileMap) {

        Map<Integer, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
//        fileMap.forEach((k, v) -> sortedMap.put(v, k));
//        sortedMap.forEach((k, v) -> System.out.print(k + "=" + v + ", "));
        for (Map.Entry<String, Integer> entry : fileMap.entrySet()) {
            sortedMap.put(entry.getValue(), entry.getKey());
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
            result.append(", ");
        }
        return result;
    }

    public void writeToFile(StringBuilder result, String source) throws IOException {

        System.out.println(result);
        FileUtils.writeStringToFile(new File("src\\main\\resources\\SortedText.txt"), result.toString());


    }
}
