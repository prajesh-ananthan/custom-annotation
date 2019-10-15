package io.prajeshananthan.customannotation.annotations.javatpoint;

import java.lang.reflect.Method;

/**
 * Created by prajesh.ananthan on 15/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */
public class TestCustomAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {
        TestCustomAnnotation testCustomAnnotation = new TestCustomAnnotation();

        // Get method
        Method m = testCustomAnnotation.getClass().getMethod("sayHello");

        // Get annotation class
        MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);

        System.out.println("Value1 is : " + annotation.value1());
        System.out.println("Value2 is : " + annotation.value2());

    }

    @MyAnnotation(value1 = 10, value2 = "20")
    private void sayHello() {
        System.out.println("Hello Annotation");
    }
}
