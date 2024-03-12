# School Management System

This project is a School Management System that helps manage students, teachers, and courses with basic functionalities. It includes classes for Teacher, Student, and Course, along with a text-based menu system to interact with the system.

## How the Application Works

The application starts by asking for the school's name. Then, it asks for the teachers, students and courses to be created and their details.

Once the school has been created, the user can enter commands to execute actions in the system.

## Commands

- **ENROLL [STUDENT_ID] [COURSE_ID]**: Enrolls the specified student in the corresponding course and updates the course's money_earned.
- **ASSIGN [TEACHER_ID] [COURSE_ID]**: Assigns the specified teacher to the corresponding course.
- **SHOW COURSES**: Displays a list of all courses.
- **LOOKUP COURSE [COURSE_ID]**: Displays the full details of the specified course.
- **SHOW STUDENTS**: Displays a list of all students.
- **LOOKUP STUDENT [STUDENT_ID]**: Displays the full details of the specified student.
- **SHOW TEACHERS**: Displays a list of all teachers.
- **LOOKUP TEACHER [TEACHER_ID]**: Displays the full details of the specified teacher.
- **SHOW PROFIT**: Calculates and displays the total profit (money earned from courses - sum of all teachers' salaries).
- **ADD NEW TEACHER**
- **ADD NEW COURSE**
- **ADD NEW STUDENT**

## Testing

In order to ensure the reliability and functionality of the system's main features and commands, a comprehensive testing approach has been implemented. 
This includes the creation of unit tests using JUnit, these tests cover various scenarios and edge cases to validate the behavior of the system under different conditions.
