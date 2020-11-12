package stringtype.registration;

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username.equals("")) {
            System.out.println("A felhasználónév megadása kötelező.");
            return false;
        }
        return true;
    }

    public boolean isValidPassword(String password1, String password2) {
        if (password1.length() >= 8 && password1.equals(password2)) {
            return true;
        } else {
            System.out.println("A jelszó legalább 8 karakter hosszú kell legyen, és a két megadott jelszónak egyeznie kell.");
            return false;
        }
    }

    public boolean isValidEmail(String email) {
        int atSign = email.indexOf("@");
        int dotSign = email.indexOf(".");
        //van kukac és pont
        if (atSign == -1 || dotSign == -1) {
            System.out.println("Az email címben kell lennie @ karakternek és valamikor utána (de nem közvetlenül) pontnak. A @ karakter nem lehet az első, az őt követő pont pedig az utolsó.");
            return false;
        } else if (atSign == 0 || dotSign == email.length()) {
            System.out.println("Az email címben kell lennie @ karakternek és valamikor utána (de nem közvetlenül) pontnak. A @ karakter nem lehet az első, az őt követő pont pedig az utolsó.");
            return false;
        } else if (atSign >= dotSign + 1) {
            System.out.println("Az email címben kell lennie @ karakternek és valamikor utána (de nem közvetlenül) pontnak. A @ karakter nem lehet az első, az őt követő pont pedig az utolsó.");
            return false;
        } else {
            return true;
        }

    }
}
