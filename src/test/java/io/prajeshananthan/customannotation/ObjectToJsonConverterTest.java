package io.prajeshananthan.customannotation;

import io.prajeshananthan.customannotation.annotations.mkyong.TesterInfo;
import io.prajeshananthan.customannotation.annotations.mkyong.Testz;
import io.prajeshananthan.customannotation.model.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by prajesh.ananthan on 13/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

class ObjectToJsonConverterTest {

    @Test
    void test_object_to_json_converter() throws IllegalAccessException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.getJsonString(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }

    @Test
    void test_custom_annotation() throws IllegalAccessException, InstantiationException {

        // Given
        Class<?> clazz = TestExample.class;

        if (clazz.isAnnotationPresent(TesterInfo.class)) {

            // Get annotation class
            TesterInfo testerInfo = clazz.getAnnotation(TesterInfo.class);

            // Get values from annotation class
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
            System.out.printf("%nTags :");

            int tagLength = testerInfo.tags().length;

            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

            // Get the list of methods for this class
            for (Method method : clazz.getDeclaredMethods()) {

                System.out.println(method.getName());

                if (method.isAnnotationPresent(Test.class)) {
                    Testz test = method.getAnnotation(Testz.class);

                    try {
                        method.invoke(clazz.newInstance());


                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }


                }

            }

        }

    }
}