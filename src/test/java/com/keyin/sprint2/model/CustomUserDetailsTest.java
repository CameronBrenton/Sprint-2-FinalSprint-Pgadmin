package com.keyin.sprint2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CustomUserDetailsTest {
    @Test
    void testConstructor() {
        CustomUserDetails actualCustomUserDetails = new CustomUserDetails(new User());
        assertNull(actualCustomUserDetails.getAuthorities());
        assertTrue(actualCustomUserDetails.isAccountNonExpired());
        assertTrue(actualCustomUserDetails.isAccountNonLocked());
        assertTrue(actualCustomUserDetails.isCredentialsNonExpired());
        assertTrue(actualCustomUserDetails.isEnabled());
    }

    @Test
    void testGetPassword() {
        assertEquals("iloveyou", (new CustomUserDetails(new User("jane.doe@example.org", "iloveyou"))).getPassword());
    }

    @Test
    void testGetUsername() {
        assertEquals("jane.doe@example.org",
                (new CustomUserDetails(new User("jane.doe@example.org", "iloveyou"))).getUsername());
    }

    @Test
    void testGetFullName() {
        assertEquals("null null", (new CustomUserDetails(new User("jane.doe@example.org", "iloveyou"))).getFullName());
    }
}

