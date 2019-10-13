package io.prajeshananthan.customannotation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by prajesh.ananthan on 12/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
    String key() default "";
}
