package io.prajeshananthan.customannotation;

import io.prajeshananthan.customannotation.annotations.baeldung.Init;
import io.prajeshananthan.customannotation.annotations.baeldung.JsonElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by prajesh.ananthan on 12/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */
public class ObjectToJsonConverter {

    private void checkIfSerializable(Object object) throws InvocationTargetException, IllegalAccessException {

        if (Objects.isNull(object)) {
            throw new JsonSerializationException("The object to serialize is null");
        }

        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true); // Allows us to execute private methods
                method.invoke(object);
            }
        }
    }

    public String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                System.out.println(field.get(object));
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    public String convertToJson(Object object) {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage());
        }
    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }


    private String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class)
                .key();
        return value.isEmpty() ? field.getName() : value;
    }
}
