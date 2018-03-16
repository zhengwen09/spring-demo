
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zhengw on 2018/3/12.
 */
public class Application {
    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("config/beans.xml");
        UserService userService = context.getBean(UserService.class);

        User user = userService.getUserById(1);
        if (user != null) {
            System.out.println(user.getName());
        }

    }

}