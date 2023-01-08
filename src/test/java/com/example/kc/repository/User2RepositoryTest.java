package com.example.kc.repository;

import com.example.kc.entity.Person;
import com.example.kc.entity.User2;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

class User2RepositoryTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private TestEntityManager testEntityManager;

    @Test
    public void addUserTest() {
        var user = new User2();
        var person = new Person();

        user.setId(1L);
        user.setEmail("maria@gmail.com");
        person.setFirstName("Maria");
        person.setId(1L);
        person.setLastName("Kuruczova");
        person.setAddressId(1L);


        var savedUser = userRepository.save(user);
        var foundUser = testEntityManager.find(User2.class, savedUser.getId());

        assertThat(foundUser.getEmail()).isEqualTo(savedUser.getEmail());
    }

    @Test
    public void findUserByEmailTest() {
        String email = "mariakuruczova7@gmail.com";
        User2 user2 = userRepository.findUser2ByEmail(email);

        assertThat(user2).isNotNull();
        assertThat(user2.getEmail()).isEqualTo(email);
    }
}