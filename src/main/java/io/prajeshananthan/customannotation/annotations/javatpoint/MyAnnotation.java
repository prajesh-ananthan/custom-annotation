package io.prajeshananthan.customannotation.annotations.javatpoint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by prajesh.ananthan on 15/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Method level
public @interface MyAnnotation {
    int value1();

    String value2();
}
