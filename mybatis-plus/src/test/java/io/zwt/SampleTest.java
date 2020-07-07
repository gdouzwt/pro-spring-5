package io.zwt;

import io.zwt.domain.User;
import io.zwt.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = Application.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        // System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        // userList.forEach(System.out::println);
    }

}
