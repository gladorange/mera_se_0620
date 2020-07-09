package com.mera.lesson5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ExceptionsAndStackTrace {


    public static void main(String[] args) {
        try {
            String str = getRandomString();
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Случайная строка не удалась");
        }
    }

    private static String getRandomString() {
        int length;
       /* try {
            length = getLengthOfRandomString();
        } catch (Exception e ) {
            System.out.println("Произошло исключение, длина = 10");
            length = 10;
        }*/
        length = getLengthOfRandomString();


        char[] str = new char[length];

        for (int i = 0; i < length; i++) {
            str[i] = 'a';
        }

        return new String(str);
    }

    private static int getLengthOfRandomString() {

        int someInt = 0;
        return 24 / 0;
    }


}
