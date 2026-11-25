package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        assertNotNull(userService);
    }

    @Test
    public void testUserRepository() {
        assertNotNull(userService.getUserRepository());

        assertEquals("MySQL",
                userService.getUserRepository().getDbType());
    }

    @Test
    public void testSecurityService() {
        assertNotNull(userService.getSecurityService());
    }

    @Test
    public void testRegisterUser() {
        assertTrue(userService.registerUser(
                "U001", "홍길동", "1234"));

        assertFalse(userService.registerUser(
                "U002", "김철수", null));

        assertFalse(userService.registerUser(
                "U003", "이영희", ""));
    }
}