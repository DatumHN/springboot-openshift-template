package dev.snowdrop.example.service;
import org.springframework.cache.annotation.Cacheable;

// tag::snippet-greeting[]
@Cacheable("miCache")
public class Greeting {

    public static final String FORMAT = "Hola, %s!";

    private final String content;

    public Greeting() {
        this.content = null;
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
// end::snippet-greeting[]
