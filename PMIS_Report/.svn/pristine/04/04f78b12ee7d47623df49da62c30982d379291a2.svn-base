package com.tetrapak.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadUtil {
    public static String[] readFileLines(String filePath) throws IOException {
	StringBuilder sb = new StringBuilder();
	File file = new File(filePath);
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	String line = null;
	while ((line = br.readLine()) != null) {
	    sb.append(line).append("\r\n");
	}
	br.close();
	return sb.toString().split("\r\n");
    }
}
