package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.id, user);
        }
        for (int l = 0; l < previous.size(); l++) {
            if (!currentMap.containsKey(previous.get(l).id)) {
                info.deleted++;
            }
            if (currentMap.containsKey(previous.get(l).id) && !currentMap.get(previous.get(l).id).name.equals(previous.get(l).name)) {
                info.changed++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}

