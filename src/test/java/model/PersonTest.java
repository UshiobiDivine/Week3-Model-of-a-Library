package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person teacher = new Person("Bisi", Position.TEACHER);


    @Test
    void assignLevel() {
        assertTrue(teacher.getLevel()==2);
    }

    @Test
    void getName() {
        assertTrue(teacher.getName().equals("Bisi"));
    }

    @Test
    void getLevel() {
        assertTrue(teacher.getLevel()==2);
    }

    @Test
    void getPosition() {
        assertTrue(teacher.getPosition().equals(Position.TEACHER));
    }
}