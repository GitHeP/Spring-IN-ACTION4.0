package kernel.spring.AOP.service;

import kernel.spring.AOP.bean.LoginBean;
import kernel.spring.AOP.dao.UserDao;
import kernel.spring.AOP.model.User;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created by kernel on 2016/6/14.
 */
@Service
public class UserService {

    final static Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public User login(LoginBean loginBean){

        String userName = loginBean.getUserName();
        User dbUser = userDao.findUserByUserName(userName);
        if(null == dbUser){
            logger.warn("用户名 [" + userName + "] 不存在");
            throw new RuntimeException("用户名[" + userName + "]不存在");
        }
        logger.debug("[" + new Date() + "] 用户 [" + userName + "] 正在进行登录操作");
        String loginPassWord = loginBean.getPassWord();
        String dbPassWord = dbUser.getPassWord();
        if(StringUtils.isNotEmpty(loginPassWord) && !loginPassWord.equals(dbPassWord)){
            logger.debug("用户 [" + userName + "] 登录密码[" + loginPassWord + "] 错误");
            throw new RuntimeException("密码错误");
        }
        logger.info("[" + new Date() + "] 用户 [" + userName + "] 登录成功,IP [" + loginBean.getLoginIP() + "]");
        return dbUser;
    }
}
