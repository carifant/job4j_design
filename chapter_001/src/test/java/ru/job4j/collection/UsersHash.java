package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UsersHash {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Helen");
        user.setChildren(2);
        User user2 = new User();
        user2.setName("Helen");
        user2.setChildren(2);

        Map<User,Object> map = new HashMap<>();
        map.put(user,new Object());
        map.put(user2, new Object());

        System.out.println(map);

    }
}
