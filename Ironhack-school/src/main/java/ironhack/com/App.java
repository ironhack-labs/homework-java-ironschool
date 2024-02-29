package ironhack.com;

import java.io.FileNotFoundException;
import java.util.*;

import static ironhack.com.ReadCsvInfo.readObjectInfo;
import static ironhack.com.ReadCsvInfo.readSchoolInfo;
import static ironhack.com.Utils.validate_number_of;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        boolean is_finish= false;
        do{


            System.out.println("*******School Management System******");

            System.out.println( "Let's create an School");
            System.out.println( "Enter a Name:");
            scanner.nextLine();

            System.out.println("how many teachers should be created?");
            int teacher_number = validate_number_of(scanner);
            System.out.println(teacher_number);
            create_teachers(scanner,teacher_number);

            System.out.println("how many courses should be created?");
            int courses_number = validate_number_of(scanner);
            System.out.println(courses_number);

            System.out.println("how many students should be created?");
            int students_number = validate_number_of(scanner);
            //TODO validate more than 0
            System.out.println(students_number);


            //more than 0 and
            is_finish=true;

        }while(!is_finish);
    }

    public static void create_teachers(Scanner scanner, int teacher_number){

        List<Teacher> teachers_list= new ArrayList<>();
        for (int i=1; i<teacher_number ; i++){
            System.out.println("Let's create teacher {i}");
            System.out.println("Enter Name:");
            String teacher_name = scanner.nextLine();

            System.out.println("Enter Salary (Ex 34000): ");
            int teacher_salary=validate_number_of(scanner);
            //Validate Range of Salaries
            teachers_list.add(new Teacher(teacher_name,teacher_salary));
            //school.setListToTeacherMap(teachers);
        }

    }

}
