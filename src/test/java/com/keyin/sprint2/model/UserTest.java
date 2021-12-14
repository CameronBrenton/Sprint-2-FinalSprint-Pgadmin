package com.keyin.sprint2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("iloveyou", actualUser.getPassword());
    }

    @Test
    void testConstructor2() {
        User actualUser = new User("jane.doe@example.org", "iloveyou");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("iloveyou", actualUser.getPassword());
    }
}

