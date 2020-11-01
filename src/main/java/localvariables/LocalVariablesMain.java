package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;
        //nem lehet kiirni mert nincs érték adva neki.
        b = false;
        int a = 2;
        int i = 3, j = 4;
        int k = i;
        //még nem lehet kiirni feiniálás nélkül.
        String s = "Hello World";
        String t = s;
        {
            int x = 0;
        }
        //nem lehet kiirni a blokkba lévő lokális változot
        {
            System.out.println(a);
        }
    }
}
