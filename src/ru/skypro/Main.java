package ru.skypro;

import ru.skypro.exceptions.WrongLoginException;
import ru.skypro.exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        loginExceptionsCheck();
        passwordExceptionsCheck();
    }
    public static String login = "java_skypr2";
    public static String password = "D_1hWiKjjP_9";
    public static String confirmPassword = "D_1hWiKjjP_9";

    public static boolean loginCheck(String login) {
        if (login.matches("^\\w{1,}$")) {
            if (login.length() <= 20) {
                System.out.println("Логин соответствует требованиям");
                return true;
            } else {
                throw new WrongLoginException();
            }
        } else {
            System.out.println("Логин не соответствует требованиям");
            throw new WrongLoginException();
        }
    }

    public static boolean passwordCheck(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            if (password.matches("^\\w{1,}$")) {
                if (password.length() < 20) {
                    System.out.println("Пароль соответствует требованиям");
                    return true;
                } else {
                    System.out.println("Пароль слишком длинный!");
                    throw new WrongPasswordException();
                }
            } else {
                System.out.println("Пароль не соответствует требованиям");
                throw new WrongPasswordException();
            }
        } else {
            System.out.println("Пароли не совпадают");
            throw new WrongPasswordException();
        }
    }

    private static boolean loginExceptionsCheck() {
        try {
            loginCheck(login);
        } catch (WrongLoginException e) {
            return false;
        }
        return false;
    }
    private static boolean passwordExceptionsCheck() {
        try {
            passwordCheck(password, confirmPassword);
        } catch (WrongPasswordException e) {
            return  false;
        }
        return false;
    }
}
