package io.prajeshananthan.customannotation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by prajesh.ananthan on 12/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Builder
@Data
@AllArgsConstructor
public class Person2 {

    @NotBlank(message = "firstName cannot be empty")
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    private String lastName;

    @NotBlank(message = "age cannot be empty")
    private String age;

}
