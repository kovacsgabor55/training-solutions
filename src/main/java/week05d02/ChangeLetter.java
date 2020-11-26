package week05d02;

public class ChangeLetter {
    /*public String ChnageVowels(String s) {
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
    }*/

    public static final String VOWELS = "aeiou";
    static final char[] VOWELS_CHAR = {'a', 'e', 'i', 'o', 'u'};

    public String changeVowels(String temp) {
        temp = temp.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            String s = temp.substring(i, i + 1);
            if (VOWELS.contains(s)) {
                sb.append("*");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public String changeVowels2(String temp) {
        for (char c : VOWELS_CHAR) {
            temp = temp.replace(c, '*');
        }
        return temp;
    }


    public static void main(String[] args) {
        ChangeLetter changeLetter = new ChangeLetter();
        System.out.println(changeLetter.changeVowels("aleiouaAEIOUASvHSDREfgdzthiuAAAwfvgjmxscma"));
    }
}