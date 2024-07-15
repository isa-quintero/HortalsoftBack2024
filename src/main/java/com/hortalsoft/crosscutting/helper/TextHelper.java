package com.hortalsoft.crosscutting.helper;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class TextHelper {

    public static final String EMPTY = "";

    private TextHelper() {
        super();
    }

    public static boolean isNull(final String string) {
        return ObjectHelper.isNull(string);
    }

    public static boolean isNullOrEmpty(final String string) {
        return isNull(string) || EMPTY.equals(applyTrim(string));
    }

    public static String applyTrim(final String string) {
        return ObjectHelper.getDefaultString(string).trim();
    }

    public static String getDefault(final String string, final String defaultValue) {
        return ObjectHelper.getDefault(string, defaultValue);
    }

    public static String getDefault(final String string) {
        return ObjectHelper.getDefaultString(string);
    }

    public static String concatenate(final String... strings) {
        return Arrays.stream(ObjectHelper.getDefault(strings, new String[0]))
                .map(ObjectHelper::getDefaultString)
                .collect(Collectors.joining());
    }
}