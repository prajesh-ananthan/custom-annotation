package io.prajeshananthan.customannotation.model;

import io.prajeshananthan.customannotation.annotations.Init;
import io.prajeshananthan.customannotation.annotations.JsonElement;
import io.prajeshananthan.customannotation.annotations.JsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by prajesh.ananthan on 12/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Data
@AllArgsConstructor
@JsonSerializer
public class Person {

    @JsonElement
    private String firstName;

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
