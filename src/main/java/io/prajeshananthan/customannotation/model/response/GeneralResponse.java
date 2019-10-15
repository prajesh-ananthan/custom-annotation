package io.prajeshananthan.customannotation.model.response;

import lombok.Builder;
import lombok.Data;

/**
 * Created by prajesh.ananthan on 15/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@Builder
@Data
public class GeneralResponse {
    private String code;
    private String message;
    private Object object;
}
