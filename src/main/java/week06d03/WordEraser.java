package week06d03;

public class WordEraser {
    public String eraseWord(String words, String word) {
        String[] splitted = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String item : splitted) {
            if (!item.equals(word)) {
                sb.append(item + " ");
            }
        }
        sb.delete(sb.toString().length() - 1, sb.toString().length());
        return sb.toString();
    }
}
