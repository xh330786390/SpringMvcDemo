import com.tengxh.entity.User;
import com.tengxh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserTest {
    @Autowired
    public UserService userInfoService;

    @Test
    public void selectUser() {

        List<User> list = userInfoService.selectUser();

    }
}
