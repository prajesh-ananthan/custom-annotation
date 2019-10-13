package io.prajeshananthan.customannotation;

/**
 * Created by prajesh.ananthan on 13/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */
public class JsonSerializationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JsonSerializationException(String message) {
        super(message);
    }
}
