import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authorization {

    public static boolean characterCheck(String str) {

        String regex = "^(\\w*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkAuthorization(String login, String password, String confirmPassword) {

        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Логин слишком длинный.");
            }
            if (!characterCheck(login)) {
                System.out.println("Логин содержит недопустимые символы.");
                return false;
            }
            if (password.length() >= 20) {
                System.out.println("Пароль слишком длинный.");
                return false;
            }
            if (!characterCheck(password)) {
                System.out.println("Пароль содержит недопустимые символы.");
                return false;
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают.");
            }

            System.out.println("Успешная авторизация!");
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
    }
}
