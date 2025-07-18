package co.com.encora.project.utils;

import com.github.javafaker.Faker;

public class RandomUserGenerator {
    private static final Faker faker = new Faker();

    public static String generateUsername() {
        return faker.name().username() + faker.number().randomDigit();
    }

    public static String generatePassword() {
        return faker.internet().password(8, 12);
    }
}