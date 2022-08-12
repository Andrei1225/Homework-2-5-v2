package ru.skypro;

import ru.skypro.exceptions.WrongLoginException;
import ru.skypro.exceptions.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        loginAndPasswordCheck();
    }

    public static void signInAccountCheck() {
        String login = "java_sky.pro";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        if (login.length() > 20) {
            throw new WrongLoginException();
        } else if (login.matches("^\\w{1,20}$")) {
            System.out.println("Логин соответствует требованиям");
        } else {
            System.out.println("Логин не соответствует требованиям");
        }

        if (password.length() != confirmPassword.length()) {
            throw new WrongPasswordException();
        } else if (password.equals(confirmPassword) && password.matches("^\\w{1,19}$")) {
            System.out.println("Пароль соответствует требованиям");
        } else {
            throw new WrongPasswordException();
        }
    }

    public static void loginAndPasswordCheck() {
        try {
            signInAccountCheck();
        } catch (WrongLoginException e) {
            System.out.println("Длина логина не может быть больше 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        }
    }
}
