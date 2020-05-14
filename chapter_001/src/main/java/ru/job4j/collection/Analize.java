package ru.job4j.collection;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        int i = 0;
        for (User user : previous) {
            if (!current.contains(user)) {
                info.deleted++;
            } else {
                if (!current.get(i).name.equals(user.name)) {
                    info.changed++;
                }
                i++;
            }
        }
        for (User user : current) {
            if (!previous.contains(user)) {
                info.added++;
            }
        }
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

