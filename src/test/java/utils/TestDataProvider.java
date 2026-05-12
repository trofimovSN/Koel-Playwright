package utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {

    public static Stream<Arguments> provideIncorrectEmails() {
        return Stream.of(
                Arguments.of("sergei.trofimov1testpro.io", "Email without @ symbol"),
                Arguments.of("sergei.trofimov1@testpro", "Email without dot symbol"),
                Arguments.of("sergei.trofimov1@", "Email without @testpro.io domain"),
                Arguments.of("sergei.trofimov+test1@testpro.io", "Email with + symbol before @")
        );
    }
}
