package com.hortalsoft.crosscutting.helper;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class TextHelper {

    public static final String EMPTY = "";
    public static final String UNDERLINE = "_";

    private TextHelper() {
        super();
    }

    public static final boolean isNull(final String string) {
        return ObjectHelper.isNull(string);
    }

    public static final boolean isNullOrEmpty(final String string) {
        return isNull(string) || EMPTY.equals(applyTrim(string));
    }

    //Modifica el applyTrim para usar getDefaultString de ObjectHelper
    public static final String applyTrim(final String string) {
        return ObjectHelper.getDefaultString(string).trim();
    }

    public static final String getDefault(final String string, final String defaultValue) {
        return ObjectHelper.getDefault(string, defaultValue);
    }

    public static final String getDefault(final String string) {
        return getDefault(string, EMPTY);
    }

    //Modifica concatenate para asegurar que la cadena sea no null mediante el getDefaultString
    public static final String concatenate(final String... strings) {
        return Arrays.asList(ObjectHelper.getDefault(strings, new String[0])).stream()
                .map(ObjectHelper::getDefaultString)
                .collect(Collectors.joining());
    }
}