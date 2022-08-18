package ru.skypro;

import ru.skypro.exceptions.WrongLoginException;
import ru.skypro.exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        loginCheck(login);
        loginExceptionsCheck();
        passwordCheck(password, confirmPassword);
        passwordExceptionsCheck();
    }
    public static String login = "java_skypr2";
    public static String password = "D_1hWiKjjP_9";
    public static String confirmPassword = "D_1hWiKjjP_90";

    public static boolean loginCheck(String login) {
        if (login.matches("^\\w{1,20}$")) {
            System.out.println("Логин соответствует требованиям");
            return true;
        } else {
            System.out.println("Логин не соответствует требованиям");
            return false;
        }
    }

    public static void loginLengthCheck(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
    }


    public static void passwordEqualsCheck(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
        } else {
            throw new WrongPasswordException();
        }
    }


    public static boolean passwordCheck(String password, String confirmPassword) {
        if (password.equals(confirmPassword) && password.matches("^\\w{1,19}$")) {
            System.out.println("Пароль соответствует требованиям");
            return true;
        } else {
            return false;
        }
    }

    private static void loginExceptionsCheck() {
        try {
            loginLengthCheck(login);
        } catch (WrongLoginException e) {
            System.out.println("Длина логина не может быть больше 20 символов");
        }

    }
    private static void passwordExceptionsCheck() {
        try {
            passwordEqualsCheck(password,confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        }

    }
}
