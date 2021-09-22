package no.moldesoft.j17.test1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        new Test().exec(args);
    }

    private void exec(String[] args) {
        List<? extends Serializable> list = Arrays.asList(1957, "Erling", null, Math.PI, Long.MAX_VALUE, 3.14f,
                                                          Something.THREE, 6., 9., GenderPrefix.MISS, GenderPrefix.MR);
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
            case GenderPrefix gp-> gp.getClass().getSimpleName() + '.' + gp;
            case Enum e -> "Enum: " + e;
            default -> String.format("Some other type : %s, and value %s", obj.getClass(), obj);
        };
    }
}
