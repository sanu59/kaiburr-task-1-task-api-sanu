package com.kaiburr.taskapi.service;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class CommandValidator {
    private static final List<String> ALLOWED_WINDOWS = List.of("echo", "dir");
    private static final List<String> ALLOWED_UNIX = List.of("echo", "pwd", "ls", "date");

    public void ensureSafe(String command) {
        if (command == null || command.isBlank()) {
            throw new IllegalArgumentException("Command is blank");
        }
        String lowered = command.toLowerCase(Locale.ROOT);
        if (lowered.contains("&&") || lowered.contains("||") || lowered.contains("|") ||
            lowered.contains(";") || lowered.contains(">") || lowered.contains("<")) {
            throw new IllegalArgumentException("Unsafe command: chaining/redirects are not allowed");
        }
        String first = lowered.trim().split("\\s+")[0];
        boolean ok = SystemUtils.IS_OS_WINDOWS ? ALLOWED_WINDOWS.contains(first) : ALLOWED_UNIX.contains(first);
        if (!ok) {
            throw new IllegalArgumentException("Command not allowed: " + first);
        }
    }
}
