package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectlyWrittenPermission() {
        return new User(PropertyReader.getProperty("saucedemo.incorrectly_written_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyLoginPermission() {
        return new User("", PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPasswordPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"), "");
    }
}
