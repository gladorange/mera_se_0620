import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExample {


    public static void main(String[] args) {

        String html = "<div> <span> Text </span>  <span> second </span> </div>";
        Pattern p = Pattern.compile("<span>(.*?)</");

        final Matcher matcher = p.matcher(html);

        while (matcher.find()) {
            System.out.println("Нашли вхождение span");
            System.out.println(matcher.group(1));
        }





    }
}
