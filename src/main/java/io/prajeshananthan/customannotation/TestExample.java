package io.prajeshananthan.customannotation;

import io.prajeshananthan.customannotation.annotations.mkyong.TesterInfo;
import io.prajeshananthan.customannotation.annotations.mkyong.TesterInfo.Priority;
import io.prajeshananthan.customannotation.annotations.mkyong.Testz;

/**
 * Created by prajesh.ananthan on 13/10/2019.
 *
 * @author Prajesh Ananthan, BIGLIFE Sdn. Bhd.
 */

@TesterInfo(
        priority = Priority.HIGH,
        createdBy = "prajeshananthan.com",
        tags = {"sales", "software development"}
)
class TestExample {
    @Testz
    void testA() {
        if (true) {
            throw new RuntimeException("This test always failed");
        }
    }

    @Testz(enabled = false)
    void testB() {
        if (false)
            throw new RuntimeException("This test always passed");
    }

    @Testz(enabled = true)
    void testC() {
        if (10 > 1) {
            // do nothing, this test always passed.
        }
    }
}
