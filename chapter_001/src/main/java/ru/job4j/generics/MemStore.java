package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    int indexOf(String id) {
        int index = 0;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
            } else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (indexOf(id) == -1) {
            return false;
        } else {
            mem.add(indexOf(id), model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        if (indexOf(id) == -1) {
            return false;
        } else {
            mem.remove(indexOf(id));
            return true;
        }
    }


    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}