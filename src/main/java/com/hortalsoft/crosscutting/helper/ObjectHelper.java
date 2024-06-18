package com.hortalsoft.crosscutting.helper;

public final class ObjectHelper {

    private ObjectHelper() {
        super();
    }

    public static final <T> boolean isNull(final T object) {
        return object == null;
    }

    public static final <T> T getDefault(final T object, final T defaultObject) {
        return isNull(object) ? defaultObject : object;
    }
}