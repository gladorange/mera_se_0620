package com.mera.lesson8;

public class TypeNameAnnotationNotFoundException extends  Exception{
    TypeNameAnnotationNotFoundException (){
        super("XmlTypeName annotation isn't presented");
    }
}
