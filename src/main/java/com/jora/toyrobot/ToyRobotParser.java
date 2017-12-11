package com.jora.toyrobot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ToyRobotParser {
    public List<String> parse(String inputFileName) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(inputFileName).getPath()))) {
            return stream.collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new Exception("The input file does not exist. Please check it again.");
        }
    }
}
