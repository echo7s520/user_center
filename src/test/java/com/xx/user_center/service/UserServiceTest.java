package com.xx.user_center.service;
import java.util.Date;

import com.xx.user_center.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void addTest() {
        User user = new User();
        user.setUsername("ye");
        user.setUserAccount("123");
        user.setAvatarUrl("https://i0.hdslb.com/bfs/tag/843c35fa8c197a7a56e723d3bed6ee400cc52d01.png");
        user.setGender(0);
        user.setUserPassword("0");
        user.setPhone("456");
        user.setEmail("789");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "ye111";
        String userPassword = "";
        String checkPassword = "12345678";
        //测试是否为空
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试账户长度是否 不小于 4 位
        userAccount = "ye";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试密码长度是否 不小于 8 位
        userAccount = "ye111";
        userPassword = "1234567";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试账户不能重复
        userAccount = "1234";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试账户不能包含特殊字符
        userAccount = "123 4";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试密码和校验密码是否相同
        userPassword = "12345678";
        checkPassword = "12345679";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试结果正确
        userAccount = "ye111";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result>0);
    }
}