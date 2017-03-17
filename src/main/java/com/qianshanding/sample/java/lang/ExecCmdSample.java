package com.qianshanding.sample.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fish on 2017/3/15.
 */
public class ExecCmdSample {
    public static void main(String[] args) throws Exception {
        List<String> cmdWrapper = new ArrayList<String>();
        //空格之间分开
        cmdWrapper.add("ls");
        cmdWrapper.add("-l");
        Map<String, String> environment = new HashMap<>();
        Process process = launchProcess(cmdWrapper, environment);


        StringBuilder sb = new StringBuilder();
        String output = getOutput(process.getInputStream());
        String errorOutput = getOutput(process.getErrorStream());
        sb.append(output);
        sb.append("\n");
        sb.append(errorOutput);

        int ret = process.waitFor();
        if (ret != 0) {
            System.out.println(cmdWrapper.toString() + " is terminated abnormally. ret={" + ret + "}, str={" + sb.toString() + "}");
        }
        System.out.println(sb.toString());
    }

    protected static java.lang.Process launchProcess(final List<String> cmdlist,
                                                     final Map<String, String> environment) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(cmdlist);
        builder.redirectErrorStream(true);
        Map<String, String> process_evn = builder.environment();
        for (Map.Entry<String, String> entry : environment.entrySet()) {
            process_evn.put(entry.getKey(), entry.getValue());
        }

        return builder.start();
    }

    public static String getOutput(InputStream input) {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = in.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
