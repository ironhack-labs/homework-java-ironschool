package org;

import java.util.HashMap;
import java.util.Iterator;
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
        boolean founded = false;

        for (HashMap.Entry<String, ?> entry : map.entrySet()) {
            String id = entry.getKey();
            Object obj = entry.getValue();

            if (obj instanceof Teacher && id.equals(targetId)) {
                System.out.println(((Teacher)obj).getInfo());
                founded = true;
                break;
            } else if (obj instanceof Course && id.equals(targetId)) {
                System.out.println(((Course)obj).getInfo());
                founded = true;
                break;
            } else if (obj instanceof Student && id.equals(targetId)) {
                System.out.println(((Student)obj).getInfo());
                founded = true;
                break;
            }
        }
        if (!founded)
            System.out.println("Invalid ID.");
    }
}
