
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder strBuild = new StringBuilder();
        
        strBuild.append("{");
        for (int x = 0; x < t.length; x++) {
            if (x % 4 == 0) {
                strBuild.append("\n ");
            }
            strBuild.append(t[x]);
            if (x < t.length - 1) {
                strBuild.append(", ");
            }
        }
        strBuild.append("\n}");
        return strBuild.toString();
    }
}
