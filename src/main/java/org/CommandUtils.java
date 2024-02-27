package org;

import java.util.HashMap;
import java.util.List;

public class CommandUtils {
    public static void showAll(HashMap<String, ?> map){
        map.forEach((id, obj) -> {
            if (obj instanceof Teacher) {
                System.out.println(((Teacher)obj).getInfo());
            } else if (obj instanceof Course) {
                System.out.println(((Course)obj).getInfo());
            } else if (obj instanceof Student) {
                System.out.println(((Student)obj).getInfo());
            }
        });
    }

    public static void lookUp(HashMap<String, ?> map, String targetId){
        map.forEach((id, obj) -> {
            if (obj instanceof Teacher && id.equals(targetId)) {
                System.out.println(((Teacher)obj).getInfo());
            } else if (obj instanceof Course && id.equals(targetId)) {
                System.out.println(((Course)obj).getInfo());
            } else if (obj instanceof Student && id.equals(targetId)) {
                System.out.println(((Student)obj).getInfo());
            }
        });
    }
}
