package ironhack.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCsvInfo {
    //TODO handling possible exceptions
    public static String[]  readSchoolInfo() throws FileNotFoundException {
        String SCHOOL_PATH = "src/files/School.csv";
        File file_school = new File(SCHOOL_PATH);
        Scanner school_scanner =new Scanner(file_school);

        school_scanner.nextLine();
        String[] school_vector = school_scanner.nextLine().split(",");
        return school_vector;
    }
    public static <ObjectType> List<ObjectType> readObjectInfo(String path, int rowsToRead, RoleType type) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<ObjectType> objectList = new ArrayList<>();

        sc.nextLine();
        for (int i = 1; i <= rowsToRead; i++) {
            String[] properties = sc.nextLine().split(",");
            ObjectType newObj = createInstance(type, properties);
            objectList.add(newObj);
        }
        return objectList;
    }

    private static <ObjectType> ObjectType createInstance(RoleType type, String[] properties) {
        switch (type) {
            case TEACHER:
                @SuppressWarnings("unchecked")
                ObjectType teacher = (ObjectType) new Teacher(properties[0], Double.parseDouble(properties[1]));
                return teacher;
            case STUDENT:
                @SuppressWarnings("unchecked")
                ObjectType student = (ObjectType) new Student(properties[0], properties[1], properties[2]);
                return student;
            case COURSE:
                @SuppressWarnings("unchecked")
                ObjectType course = (ObjectType) new Course(properties[0], Double.parseDouble(properties[1]));
                return course;
            default:
                throw new IllegalArgumentException("Invalid RoleType");
        }
    }

}
