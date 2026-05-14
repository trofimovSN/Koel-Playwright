package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {

    private static final Faker FAKER = new Faker();

    public static Stream<Arguments> provideIncorrectEmails() {
        return Stream.of(
                Arguments.of("sergei.trofimov1testpro.io", "Email without @ symbol"),
                Arguments.of("sergei.trofimov1@testpro", "Email without dot symbol"),
                Arguments.of("sergei.trofimov1@", "Email without @testpro.io domain"),
                Arguments.of("sergei.trofimov+test1@testpro.io", "Email with + symbol before @")
        );
    }

    public static Stream<Arguments> getPlayListNames() {
        return Stream.of(
                Arguments.of("A", true),
                Arguments.of(FAKER.lorem().characters(256), true),
                Arguments.of(FAKER.lorem().characters(257), false),
                Arguments.of("", false),
                Arguments.of("Ab", false),
                Arguments.of("AbC", true),
                Arguments.of("123456789A", true),
                Arguments.of("1234567890A", false)
        );
    }
}
