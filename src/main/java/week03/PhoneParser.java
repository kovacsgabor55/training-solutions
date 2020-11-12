package week03;

public class PhoneParser {
    public Phone parsePhone(String s) {
        //30-1234567
        String prefix = s.substring(0, s.indexOf("-"));
        String number = s.substring(s.indexOf("-") + 1);
        Phone phone = new Phone(prefix, number);
        return phone;
    }
}
