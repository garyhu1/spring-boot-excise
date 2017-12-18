package com.garyhu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.garyhu.pojo.User;

@Service
public class UserService {

	private List<User> users;
	
	// Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().
        		filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    
    // Init some users for testing
    @PostConstruct//在servlet初始化的时候调用，在servlet构造函数之后，init函数之前
    //(被@PreConstruct修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。
    //被@PreConstruct修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前)
    private void iniDataForTesting() {
        users = new ArrayList<User>();
        User user1 = new User();
        user1.setUsername("maxsu");
        user1.setPassword("password111");
        user1.setEmail("maxsu@yahoo.com");
        User user2 = new User();
        user2.setUsername("yiflow");
        user2.setPassword("password222");
        user2.setEmail("yflow@yahoo.com");
        User user3 = new User();
        user3.setUsername("minaxu");
        user3.setPassword("password333");
        user3.setEmail("minaxu@yahoo.com");
        User user4 = new User();
        user4.setUsername("minalee");
        user4.setPassword("password444");
        user4.setEmail("minalee@yahoo.com");
        User user5 = new User();
        user5.setUsername("yiiflow");
        user5.setPassword("password555");
        user5.setEmail("yiiflow@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }
}
