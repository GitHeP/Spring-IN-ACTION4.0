package kernel.spring.AOP.dao;

import kernel.spring.AOP.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kernel on 2016/6/14.
 */
@Repository
public class UserDao {

    private static Map<String,Object> db = new HashMap<String,Object>();

    static {
        User user_1 = new User();
        user_1.setPhone("13752258197");
        user_1.setContactAddress("天朝帝都");
        user_1.setEmail("anonymou_s@163.com");
        user_1.setGender("男");
        user_1.setNickName("当时年少春衫薄");
        user_1.setSignInDate(new Date(2016,5,3));
        user_1.setPassWord("123");
        db.put(user_1.getNickName(),user_1);
    }

    public User findUserByUserName(String userName){
        Assert.notNull(userName);
        return (User) db.get(userName);
    }
}
