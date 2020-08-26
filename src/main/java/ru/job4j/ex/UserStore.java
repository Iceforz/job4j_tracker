package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User search = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                search = users[i];
                break;
            }
        }
        if (search == null) {
            throw new UserNotFoundException("There's no such user");
        }
        return search;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean confirm = false;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User isn't valid");
        } else {
            confirm = true;
        }
        return confirm;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    } catch (UserInvalidException ex) {
        System.out.println(ex.getMessage());
    } catch (UserNotFoundException ex) {
        System.out.println(ex.getMessage());
    }
    }
}
