package com.hortalsoft.crosscutting.helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class DateHelper {
    private DateHelper() {
        super();
    }

    public static boolean isEqual(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return date.equals(comparator);
    }

    public static boolean isGreater(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return date.isAfter(comparator);
    }

    public static boolean isLesser(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return date.isBefore(comparator);
    }

    public static boolean isGreaterOrEqual(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return isGreater(date, comparator) || isEqual(date, comparator);
    }

    public static boolean isLesserOrEqual(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return isGreater(date, comparator) || isEqual(date, comparator);
    }

    public static boolean isDifferent(final LocalDateTime date, final LocalDateTime comparator) {
        // Isabella: Ensure first date and comparator aren't null!!!!
        return !isEqual(date, comparator);
    }

    public static boolean isBetween(final LocalDateTime date, final LocalDateTime initialRange,
                                    final LocalDateTime finalRange, final boolean includeInitialRange, final boolean includeFinalRange) {
        // Isabella: Ensure first date, initialRange and finalRange aren't null!!!!
        return (includeInitialRange) ? isGreaterOrEqual(date, initialRange)
                : isGreater(date, initialRange) && (includeFinalRange) ? isLesserOrEqual(date, finalRange)
                : isLesser(date, finalRange);
    }

    public static boolean isBetweenInclusive(final LocalDateTime date, final LocalDateTime initialRange,
                                             final LocalDateTime finalRange) {
        // Isabella: Ensure first date, initialRange and finalRange aren't null!!!!
        return isBetween(date, initialRange, finalRange, true, true);
    }

    public static boolean isBetweenExclusive(final LocalDateTime date, final LocalDateTime initialRange,
                                             final LocalDateTime finalRange) {
        // Isabella: Ensure first date, initialRange and finalRange aren't null!!!!
        return isBetween(date, initialRange, finalRange, false, false);
    }

    public static long toMilliseconds(final LocalDateTime date) {
        // Isabella: Ensure first date aren't null!!!!
        return ZonedDateTime.of(date, ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}