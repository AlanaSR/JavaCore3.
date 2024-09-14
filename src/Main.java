import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            validationLoginAndPassword("ariruku2507", "Cnhfiysq176_", "Cnhfiysq176_");
        } catch (WrongPasswordException|WrongLoginException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void validationLoginAndPassword(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        String regexLogin ="^[a-z_0-9]{8,20}$";
        Pattern patternLogin = Pattern.compile(regexLogin);
        Matcher matcherLogin = patternLogin.matcher(login);

        String regexPassword ="^[a-zA-Z_0-9]{8,20}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if (!matcherLogin.matches()){
            throw new WrongLoginException();
        }
        if (!matcherPassword.matches()){
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }
    }
}
