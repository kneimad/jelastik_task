import classes.First;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

    private static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        str.append("{\n");
        getRecursiveClassInfo(First.class);
        str.append("\n}");
        System.out.println(str);
    }

    private static void getRecursiveClassInfo(Class clazz) {
        if ( Modifier.isFinal(clazz.getModifiers()) ) {
            str.append("\"" + clazz.getSimpleName() + "\"");
            return;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        int len = declaredFields.length;
        for (int i = 0; i < len; i++) {
            str.append("\"" + declaredFields[i].getName() + "\"");
            str.append(" : ");
            if (Modifier.isFinal(declaredFields[i].getType().getModifiers())) {
                str.append("\"" + declaredFields[i].getType().getSimpleName() + "\"");
                if (i < len-1) str.append(",\n");
            } else {
                Type genericField = declaredFields[i].getGenericType();
                if (genericField instanceof ParameterizedType) {
                    getParameterizedTypeClass(genericField);
                    if (i < len-1) str.append(",\n");
                } else {
                    str.append("\n{");
                    getRecursiveClassInfo(declaredFields[i].getType());
                        str.append("},\n");
                }
            }
        }
    }

    private static void getParameterizedTypeClass(Type type){
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class rawType = (Class) parameterizedType.getRawType();
            Boolean isInterface = false;
            Boolean isMap = false;
            if ( rawType.isInterface() ) {
                isInterface = true;
                str.append("[\n");
                if ( "Map".equals(rawType.getSimpleName()) ) {
                    isMap = true;
                    str.append("{");
                }
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                getParameterizedTypeClass(actualTypeArguments[i]);
                if ( isMap && i == 0) {
                    str.append(" :\n");
                }
            }
            if ( isInterface ) {
                if ( isMap ) {
                    str.append("}");
                }
                str.append("\n, \"...\"]");
            }
        } else {
            if( !Modifier.isFinal(((Class) type).getModifiers()) ) {
                str.append("{");
            }
            getRecursiveClassInfo((Class) type);
            if( !Modifier.isFinal(((Class) type).getModifiers()) ) {
                str.append("}");
            }
        }
    }

}
