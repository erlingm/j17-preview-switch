package no.moldesoft.j17.test1;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        new Test().exec(args);
    }

    private void exec(String[] args) {
        List<? extends Serializable> list = Arrays.asList(1957, "Erling", null, Math.PI, Long.MAX_VALUE, 3.14f,
                                                          Something.THREE, 6., 9., GenderPrefix.MISS, GenderPrefix.MR,
                                                          LocalDate.of(1957, Month.AUGUST, 30), LocalDateTime.now(),
                                                          ZonedDateTime.now(ZoneId.of("UTC")));
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
        if (temporal.isSupported(ChronoUnit.HOURS)) {
            return "Supports HOURS: " + DateTimeFormatter.ofPattern("d. MMM uuuu 'kl.' H:mm:ss").format(temporal);
        }
        if (temporal.isSupported(ChronoUnit.DAYS)) {
            return "Supports DAYS: " + DateTimeFormatter.ofPattern("d. MMM uuuu", locale).format(temporal);
        }
        return temporal.getClass().getSimpleName();
    }
}
