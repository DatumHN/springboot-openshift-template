package dev.snowdrop.example.service;

// tag::snippet-greeting[]
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
