package com.hortalsoft.crosscutting.helper;

public final class ObjectHelper {

    private ObjectHelper() {
        super();
    }

    public static <T> boolean isNull(final T object) {
        return object == null;
    }

    public static <T> T getDefault(final T object, final T defaultObject) {
        return isNull(object) ? defaultObject : object;
    }

    public static String getDefaultString(final String string) {
        return isNull(string) || string.isEmpty() || string.isBlank()  ? "" : string;
    }

    public static Integer getDefaultInteger(final Integer integer) {
        return isNull(integer) ? 0 : integer;
    }
}