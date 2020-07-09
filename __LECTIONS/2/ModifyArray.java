import java.util.Arrays;
import java.util.Random;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ModifyArray {
    public static void main(String[] args) {
        long array[] = new long[10];
        for (int i = 0; i < 10; i++) {
            long leftLimit = -2147483648L;
            long rightLimit = 2147483647L;
            array[i] = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        }


        System.out.println(Arrays.toString(array));
    }


}