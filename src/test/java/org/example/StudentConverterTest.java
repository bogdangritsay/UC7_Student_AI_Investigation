package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentConverterTest {

    private static StudentConverter converter;
    private static List<Student> students;

    @BeforeAll
    public static void init() {
        converter = new StudentConverter();
        students = new ArrayList<>();

        // High achiever
        Student highAchiever = new Student();
        highAchiever.setAge(21);
        highAchiever.setGrade(91);
        students.add(highAchiever);

        // Exceptional young high achiever
        Student exceptional = new Student();
        exceptional.setAge(20);
        exceptional.setGrade(95);
        students.add(exceptional);

        // Passed student
        Student passed = new Student();
        passed.setGrade(80);
        students.add(passed);

        // Failed student
        Student failed = new Student();
        failed.setGrade(70);
        students.add(failed);
    }

    @Test
    public void testHighAchiever() {
        List<Student> result = converter.convertStudents(students);
        assertEquals(students.size(), result.size());
        assertTrue(result.get(0).isHonorRoll());
    }

    @Test
    public void testExceptionalYoungHighAchiever() {
        List<Student> result = converter.convertStudents(students);
        assertEquals(students.size(), result.size());
        assertTrue(result.get(1).isExceptional());
    }

    @Test
    public void testPassedStudent() {
        List<Student> result = converter.convertStudents(students);
        assertEquals(students.size(), result.size());
        assertTrue(result.get(2).isPassed());
    }

    @Test
    public void testFailedStudent() {
        List<Student> result = converter.convertStudents(students);
        assertEquals(students.size(), result.size());
        assertFalse(result.get(3).isPassed());
    }

    @Test
    public void testEmptyArray() {
        List<Student> result = converter.convertStudents(List.of());
        assertTrue(result.isEmpty(), "Result should be an empty list for an empty input.");
    }

    @Test
    public void testInputIsNull() {
        assertThrows(NullPointerException.class, () -> {
            converter.convertStudents(null);
        }, "Should throw NullPointerException when input is null.");
    }
}
