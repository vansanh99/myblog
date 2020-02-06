/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

/**
 *
 * @author sanhpv
 */
public class validate {

    String msgAge = "";

    public String checkAge(String num, int min, int max) {
        try {
            int age = Integer.parseInt(num);
            if (age < min || age > max) {
                msgAge = "Age is between " + min + " and " + max;
                return msgAge;
            }
        } catch (NumberFormatException e) {
            msgAge = "must enter a number.";
            return msgAge;
        }
        return "ok";
    }

    public String checkInputPassword(String password) {
        if (password.isEmpty()) {
            msgAge = "must enter something.";
            return msgAge;
        } else {
            if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{9,}$")) {
                msgAge = "the password must contains at least ONE upper case, ONE digit and ONE special letter and length > 8.";
                return msgAge;
            }
            return "ok";
        }
    }
    public String checkInputName(String username) {
        if (username.isEmpty()) {
            msgAge = "must enter something.";
            return msgAge;
        } else {
            if (!username.matches("^[a-zA-Z0-9]+$") || username.length() <= 6) {
                msgAge = "the name does not contain special letter and length > 6.";
                return msgAge;
            }
            return "ok";
        }
    }
}
