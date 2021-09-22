package no.moldesoft.j17.test1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        new Test().exec(args);
    }

    private void exec(String[] args) {
        Optional<ZoneId> first = ZoneId.getAvailableZoneIds()
                .stream()
                .filter(((Predicate<String>) zone2 -> zone2.contains(
                        "Hawaii")).or(zone1 -> zone1.contains("United States"))
                                .or(zone -> zone.contains("New York")))
                .map(ZoneId::of)
                .findFirst();
        ZoneId hawaii = first.orElseGet(ZoneId::systemDefault);
        ZoneId honolulu = ZoneId.of("Pacific/Honolulu");
        List<Object> list = Arrays.asList(1957,
                                          "Erling",
                                          null,
                                          Math.PI,
                                          Long.MAX_VALUE,
                                          3.14f,
                                          Something.THREE,
                                          6.,
                                          GenderPrefix.MISS,
                                          GenderPrefix.MR,
                                          LocalDate.of(1957, Month.AUGUST, 30),
                                          LocalDateTime.now(),
                                          ZonedDateTime.now(ZoneId.of("UTC")),
                                          Instant.now().atZone(hawaii),
                                          Instant.now().atZone(honolulu));
        list.forEach(this::doCheck);
    }

    private void doCheck(Object obj) {
        System.out.printf("""
                          Checked value of "%s" is "%s"%n""", obj, check(obj));
    }

    private String check(Object obj) {
        return switch (obj) {
            case null -> "No defined value";
            case Integer i -> "Integer: " + i;
            case Long l -> "Long: " + l;
            case Float f -> "Float: " + f;
            case Double d -> "Double: " + d;
            case GenderPrefix gp -> gp.getClass().getSimpleName() + '.' + gp;
            case Enum e -> "Enum: " + e;
            case Temporal t -> check(t);
            default -> String.format("Some other type : %s, and value %s", obj.getClass(), obj);
        };
    }

    private String check(Temporal temporal) {
        Locale locale = Locale.forLanguageTag("nb");
        if (temporal.isSupported(ChronoUnit.HOURS) && temporal.isSupported(ChronoField.OFFSET_SECONDS)) {
            return "Supports HOURS: " +
                   DateTimeFormatter.ofPattern("d. MMM uuuu 'kl.' H:mm:ss - VV - zzzz", locale).format(temporal);
        }
        if (temporal.isSupported(ChronoUnit.HOURS)) {
            return "Supports HOURS: " +
                   DateTimeFormatter.ofPattern("d. MMM uuuu 'kl.' H:mm:ss").format(temporal);
        }
        if (temporal.isSupported(ChronoUnit.DAYS)) {
            return ", AND Supports DAYS: " +
                   DateTimeFormatter.ofPattern("d. MMM uuuu", locale).format(temporal);
        }
        return temporal.getClass().getSimpleName();
    }
}
