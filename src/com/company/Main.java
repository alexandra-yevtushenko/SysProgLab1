package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("file.txt")), StandardCharsets.UTF_8);
        text = text.trim();
        String[] words = text.split("[^0-9a-zA-Z\\-\\']+");
        for (int i = 0; i < words.length; i++)
        {
            words[i] = words[i].replaceAll("[^\\w\\-]", "");
            if (words[i].length() > 30)
            {
                words[i] = words[i].substring(0, 30);
            }
        }

        Map<String, Integer> wordsCount = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++)
            {
                if(wordsCount.containsKey(words[i]))
                {
                    wordsCount.put(words[i], wordsCount.get(words[i]) + 1);
                }
                else
                {
                    wordsCount.put(words[i], 1);
                }
            }
        System.out.println("Counts of all words: " + wordsCount);

        int maxCount = Collections.max(wordsCount.values());
        List<String> maxCountKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet())
        {
            if (entry.getValue()==maxCount)
            {
                maxCountKeys.add(entry.getKey());
            }
        }
        System.out.println("The most frequent words: " + maxCountKeys);
    }
}
