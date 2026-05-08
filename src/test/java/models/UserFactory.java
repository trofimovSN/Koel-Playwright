package models;

import utils.ConfigReader;

public class UserFactory {
    public static User mainUser() {
        return new User(
                ConfigReader.get("user.email"),
                ConfigReader.get("user.password")
        );
    }
    public static User testUser() {
        return new User(
                ConfigReader.get("user.test.email"),
                ConfigReader.get("user.test.password")
        );
    }
    public static User testUser2() {
        return new User(
                ConfigReader.get("spare.test.email"),
                ConfigReader.get("spare.test.password")
        );
    }
}