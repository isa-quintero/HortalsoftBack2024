package com.hortalsoft.crosscutting.helper;


public final class NumberHelper {
    private NumberHelper() {
        super();
    }

    public static boolean greaterThan(int numero, int comparador) {
        return numero > comparador;
    }

    public static  boolean lessThan(int numero, int comparador) {
        return numero < comparador;
    }

    public static  boolean equalsThan(int numero, int comparador) {
        return numero == comparador;
    }

    public static  boolean lessEqualsThan(int numero, int comparador) {
        return lessThan(numero, comparador) || equalsThan(numero, comparador);
    }

    public static  boolean greaterEqualsThan(int numero, int comparador) {
        return greaterThan(numero, comparador) || equalsThan(numero, comparador);
    }

    public static  boolean isBetween(int numero, int comparadorInicial, int comparadorFinal, boolean incluirRangoInicial, boolean incluirRangoFinal) {
        return (incluirRangoInicial) ? greaterEqualsThan(numero, comparadorInicial): greaterThan(numero, comparadorInicial)
                &&
                (incluirRangoFinal) ? lessEqualsThan(numero, comparadorFinal): lessThan(numero, comparadorFinal);
    }

    public static  boolean isBetweenInclusive(int numero, int comparadorInicial, int comparadorFinal) {
        return isBetween(numero, comparadorInicial, comparadorFinal, true, true);
    }

    public static  boolean isBetweenExclusive(int numero, int comparadorInicial, int comparadorFinal) {
        return isBetween(numero, comparadorInicial, comparadorFinal, false, false);
    }
}
