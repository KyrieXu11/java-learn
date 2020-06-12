package com.InputOutputStream;

import java.io.*;
import java.util.stream.Stream;

/**
 * @author KyrieXu
 * @since 2020/5/24 9:18
 **/
public class BitmapGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("F:\\XQ\\ASCIIGenerator\\ASCII-掰.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("F:\\XQ\\ASCIIGenerator\\掰.txt")));
        int line = 0;
        while (true) {
            String s = reader.readLine();
            if (s == null) break;
            StringBuilder sb = new StringBuilder(s.length() * 2);
            if (line == 0)
                sb.append("{");
            for (int i = 0; i < s.length(); i++) {
                if (i == 0)
                    sb.append("{");
                sb.append(s.charAt(i));
                if (i != s.length() - 1) {
                    sb.append(",");
                }
                else
                    sb.append("}");
            }
            sb.append(",\n");
            writer.write(sb.toString());
            ++line;
        }
        writer.write("}");
        writer.close();
        reader.close();
    }
}
