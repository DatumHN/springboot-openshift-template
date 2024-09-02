package dev.snowdrop.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocalTest extends AbstractExampleApplicationTest {

    @Value("${local.server.port}")
    private int port;

    @Override
    public String baseURI() {
        return String.format("http://localhost:%d", port);
    }
}
