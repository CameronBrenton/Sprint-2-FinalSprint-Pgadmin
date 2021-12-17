package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Objects;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("Toadstool@marioland.com");
        user.setPassword("toady22445");
        user.setFirstName("Toad");
        user.setLastName("Stool");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        Assertions.assertEquals(user.getEmail(), existUser.getEmail());

    }


}
