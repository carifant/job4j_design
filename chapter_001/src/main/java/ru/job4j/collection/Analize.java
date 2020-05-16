package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.id, user);
        }

        for (int l = 0; l < current.size(); l++) {
            if (previousMap.containsKey(current.get(l).id)) {
                if (!previousMap.get(current.get(l).id).name.equals(current.get(l).name)) {
                    info.changed++;
                }
            }
            previousMap.remove(current.get(l).id);
        }
        info.deleted = previousMap.size();

        int i1 = previous.size() - info.deleted;
        info.added = current.size() - i1;
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

