package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void w1() {
        Analize analize = new Analize();
        List<Analize.User> list = new ArrayList<>();
        Analize.User user = new Analize.User(1, "Alex");
        Analize.User user2 = new Analize.User(2, "Oleg");
        list.add(user);
        list.add(user2);
        List<Analize.User> listNext = new ArrayList<>(list);
        listNext.remove(1);
        Analize.Info info = analize.diff(list, listNext);
        Analize.Info ecspected = new Analize.Info(0, 0, 1);
        assertThat(ecspected.added, is(info.added));
        assertThat(ecspected.changed, is(info.changed));
        assertThat(ecspected.deleted, is(info.deleted));

    }

    @Test
    public void w2() {
        Analize analize = new Analize();
        List<Analize.User> list = new ArrayList<>();
        Analize.User user = new Analize.User(1, "Alex");
        Analize.User user2 = new Analize.User(2, "Oleg");
        Analize.User user3 = new Analize.User(3, "Elena");
        list.add(user);
        list.add(user2);
        list.add(user3);
        List<Analize.User> listNext = new ArrayList<>(list);
        listNext.remove(1);
        Analize.User user4 = new Analize.User(4, "Oxsana");
        listNext.add(user4);
        listNext.get(0).name = "Alisa";
        Analize.Info info = analize.diff(list, listNext);
        Analize.Info ecspected = new Analize.Info(1, 0, 1);
        assertThat(ecspected.added, is(info.added));
        assertThat(ecspected.changed, is(info.changed));
        assertThat(ecspected.deleted, is(info.deleted));

    }

}