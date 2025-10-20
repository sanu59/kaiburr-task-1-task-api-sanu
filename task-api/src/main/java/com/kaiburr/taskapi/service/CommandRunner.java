package com.kaiburr.taskapi.service;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class CommandRunner {
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    public String run(String command) throws Exception {
        ProcessBuilder pb = SystemUtils.IS_OS_WINDOWS
                ? new ProcessBuilder("cmd.exe", "/c", command)
                : new ProcessBuilder("/bin/sh", "-c", command);

        pb.redirectErrorStream(true);
        Process p = pb.start();
        boolean finished = p.waitFor(TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
        if (!finished) {
            p.destroyForcibly();
            throw new IllegalStateException("Command timed out");
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line).append('\n');
            return sb.toString().trim();
        }
    }
}
