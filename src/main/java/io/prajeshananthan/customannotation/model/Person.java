package io.prajeshananthan.customannotation.model;

import io.prajeshananthan.customannotation.annotations.baeldung.Init;
import io.prajeshananthan.customannotation.annotations.baeldung.JsonElement;
import io.prajeshananthan.customannotation.annotations.baeldung.JsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by prajesh.ananthan on 12/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Data
@AllArgsConstructor
@JsonSerializer
public class Person {

    @NotBlank(message = "firstName cannot be empty")
    @JsonElement
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    @JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }

}
