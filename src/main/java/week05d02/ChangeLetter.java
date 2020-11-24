package week05d02;

public class ChangeLetter {
    public String ChnageVowels(String s) {
        s = s.replace("a", "*");
        s = s.replace("e", "*");
        s = s.replace("i", "*");
        s = s.replace("o", "*");
        s = s.replace("u", "*");
        s = s.replace("A", "*");
        s = s.replace("E", "*");
        s = s.replace("I", "*");
        s = s.replace("O", "*");
        s = s.replace("U", "*");
        return s;
    }

    public static void main(String[] args) {
        ChangeLetter changeLetter = new ChangeLetter();
        System.out.println(changeLetter.ChnageVowels("aleiouaAEIOUASvHSDREfgdzthiuAAAwfvgjmxscma"));
    }
}
