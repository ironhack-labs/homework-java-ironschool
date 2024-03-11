
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {

    private Course course;

    @BeforeEach
    public void setUp(){
        course = new Course("Math", 120);
    }

    @Test
    public void returns(){
        assertEquals("Math", course.getName());
    }

    @Test
    public void priceTest(){
        assertEquals(120, course.getPrice());
    }

}
