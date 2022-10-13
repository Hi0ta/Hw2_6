package com.example.hw2_6;

public class Data {
    private String login;
    private String password;
    private String confirmPassword;
    private static final String VALID_CHARACTERS = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    public Data(String login, String password, String confirmPassword) {
        this.setLogin(login);
        this.setPassword(password);
        this.setConfirmPassword(confirmPassword);
    }
    public String getLogin() {return login;}
    public String getPassword() {return password;}
    public String getConfirmPassword() {return confirmPassword;}

    public void setLogin(String login) {
        if (0 < login.length() && login.length() <= 20) {
            this.login = login;
            System.out.println("true");
            } else{
            try {
                throw new WrongLoginException("Логин должен быть заполнен!! И содержать в себе только латинские буквы, цифры или знак подчеркивания. Длиной не более 20 символов");
            } catch (WrongLoginException e) {
                System.out.println(e.getMessage());
            }
            }
    }
    public void setPassword(String password) {
        if (0 < password.length() && password.length() <= 20) {
            this.password = password;
            System.out.println("true");
        } else {
            try {
                throw new WrongPasswordException("Пароль должен быть заполнен!! И содержать в себе только латинские буквы, цифры или знак подчеркивания. Длиной не более 20 символов");
            } catch (WrongPasswordException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void setConfirmPassword(String confirmPassword) {
        if (confirmPassword.equals(password)) {
            this.confirmPassword = confirmPassword;
            System.out.println("true");
        } else {
            try {
                throw new WrongPasswordException("Подтверждающий пароль должен быть заполнен!! И полностью совпадать с паролем");
            } catch (WrongPasswordException exept) {
                System.out.println(exept.getMessage());
            }
        }
    }
    private static boolean valid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) ;
            return false;
        }
        return true;
    }

}


