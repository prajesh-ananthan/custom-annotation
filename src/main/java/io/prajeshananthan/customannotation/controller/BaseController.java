package io.prajeshananthan.customannotation.controller;

import io.prajeshananthan.customannotation.model.Person2;
import io.prajeshananthan.customannotation.model.response.GeneralResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

/**
 * Created by prajesh.ananthan on 3/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@RestController
public class BaseController {

    @GetMapping("/")
    public GeneralResponse getPerson(@Valid @RequestBody Person2 person) {
        return GeneralResponse.builder()
                .code("200")
                .message("success")
                .object(person)
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public GeneralResponse handleValidationError(ConstraintViolationException exception) {

        System.out.println(">>> Exception captured...");
        return GeneralResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    // TODO: Eve Annotations
}
