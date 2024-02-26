package org;

import java.util.HashMap;
import java.util.List;

public class CommandUtils {
    public static void showAll(HashMap<String, ?> map){
        map.forEach((id, obj) -> {
            if (obj instanceof Teacher) {
                ((Teacher)obj).getInfo();
            } else if (obj instanceof Course) {
                ((Course)obj).getInfo();
            } else if (obj instanceof Student) {
                ((Student)obj).getInfo();
            }
        });
    }

    public static void lookUp(HashMap<String, ?> map, String targetId){
        map.forEach((id, obj) -> {
            if (obj instanceof Teacher && id.equals(targetId)) {
                ((Teacher)obj).getInfo();
            } else if (obj instanceof Course && id.equals(targetId)) {
                ((Course)obj).getInfo();
            } else if (obj instanceof Student && id.equals(targetId)) {
                ((Student)obj).getInfo();
            }
        });
    }
}
