package com.keyin.sprint2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SearchTest {
    @Test
    void testConstructor() {
        Search actualSearch = new Search();
        actualSearch.setDatabase("Database");
        actualSearch.setId(123L);
        actualSearch.setTopic("Topic");
        assertEquals("Database", actualSearch.getDatabase());
        assertEquals(123L, actualSearch.getId());
        assertEquals("Topic", actualSearch.getTopic());
        assertEquals("Search{topic='Topic'}", actualSearch.toString());
    }

    @Test
    void testConstructor2() {
        Search actualSearch = new Search("Topic");
        actualSearch.setDatabase("Database");
        actualSearch.setId(123L);
        actualSearch.setTopic("Topic");
        assertEquals("Database", actualSearch.getDatabase());
        assertEquals(123L, actualSearch.getId());
        assertEquals("Topic", actualSearch.getTopic());
        assertEquals("Search{topic='Topic'}", actualSearch.toString());
    }

    @Test
    void testConstructor3() {
        Search actualSearch = new Search("Topic", "Database");
        actualSearch.setDatabase("Database");
        actualSearch.setId(123L);
        actualSearch.setTopic("Topic");
        assertEquals("Database", actualSearch.getDatabase());
        assertEquals(123L, actualSearch.getId());
        assertEquals("Topic", actualSearch.getTopic());
        assertEquals("Search{topic='Topic'}", actualSearch.toString());
    }

    @Test
    void testConstructor4() {
        Search actualSearch = new Search(123L, "Topic", "Database");

        assertEquals("Database", actualSearch.getDatabase());
        assertEquals("Search{topic='Topic'}", actualSearch.toString());
        assertEquals(123L, actualSearch.getId());
    }

    @Test
    void testConstructor5() {
        Search actualSearch = new Search(new Search());
        assertNull(actualSearch.getDatabase());
        assertEquals("Search{topic='null'}", actualSearch.toString());
    }
}

