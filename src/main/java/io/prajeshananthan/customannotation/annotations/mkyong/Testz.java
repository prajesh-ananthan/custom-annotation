package io.prajeshananthan.customannotation.annotations.mkyong;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by prajesh.ananthan on 13/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testz {

    boolean enabled() default true;
}
