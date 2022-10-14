package com.example.hw2_6;

public class Data {
    private String login;
    private String password;
    private String confirmPassword;
    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    public Data(String login, String password, String confirmPassword) {
        try {
            this.setLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.setPassword(password);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.setConfirmPassword(confirmPassword);
        } catch (WrongPasswordException e) {
          System.out.println(e.getMessage());
        }
    }
    public String getLogin() {return login;}
    public String getPassword() {return password;}
    public String getConfirmPassword() {return confirmPassword;}

    public void setLogin(String login) throws WrongLoginException {
        if (0 < login.length() && login.length() <= 20 && valid(login)) {
            this.login = login;
        } else{
            throw new WrongLoginException("Логин должен быть заполнен!! И содержать в себе только латинские буквы, цифры или знак подчеркивания. Длиной не более 20 символов");
        }
    }
    public void setPassword(String password) throws WrongPasswordException {
        if (0 < password.length() && password.length() <= 20 && valid(password)) {
            this.password = password;
        } else {
            throw new WrongPasswordException("Пароль должен быть заполнен!! И содержать в себе только латинские буквы, цифры или знак подчеркивания. Длиной не более 20 символов");
        }
    }
    public void setConfirmPassword(String confirmPassword) throws WrongPasswordException {
        if (confirmPassword.equals(password)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new WrongPasswordException("Подтверждающий пароль должен быть заполнен!! И полностью совпадать с паролем");
        }
    }
    private static boolean valid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

}


