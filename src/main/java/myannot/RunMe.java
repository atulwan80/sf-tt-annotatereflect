package myannot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunMe {
    // types are very restricted, primitives, String, class, annotation, arrays of these
    String color() default "Black";
    int value() default 3;
}
