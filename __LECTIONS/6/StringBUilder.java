public class StringBUilder {


    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = "3";
        String d = "4";

        System.out.println(a + b + c + d);


        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        sb.append(d);

        System.out.println(sb.toString());

    }
}
