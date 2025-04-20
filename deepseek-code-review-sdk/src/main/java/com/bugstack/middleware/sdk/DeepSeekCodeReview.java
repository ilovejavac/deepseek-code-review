package com.bugstack.middleware.sdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DeepSeekCodeReview {

    public static void main(String[] args) throws Exception {
        System.out.println("run code review-test");

        ProcessBuilder processBuilder = new ProcessBuilder("git", "diff", "HEAD~1", "HEAD");
        processBuilder.directory(new File("."));

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuffer diffCode = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            diffCode.append(line);
        }

        int exitCode = process.waitFor();
        System.out.println("exited with code:" + exitCode);

        System.out.println("评审代码" + diffCode);
    }

}
