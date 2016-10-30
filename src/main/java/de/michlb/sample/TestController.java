package de.michlb.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static final String GREETING = "Greetings from Michael!";

    @GetMapping("/")
    public ResponseEntity index() {
        if (MyFeatures.HELLO_WORLD.isActive()) {
            StringBuilder sb = new StringBuilder(GREETING);
            if (MyFeatures.REVERSE_GREETING.isActive()) {
                sb.reverse();
            }
            return ResponseEntity.ok().body(sb.toString());
        }
        return ResponseEntity.notFound().build();
    }
}
