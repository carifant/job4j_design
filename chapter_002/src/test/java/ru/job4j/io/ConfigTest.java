package ru.job4j.io;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("C:\\projects\\job4j_design\\app.properties");
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
    }

    @Test
    public void whenPairWithtComment() {
        Config config = new Config("C:\\projects\\job4j_design\\app.properties");
        config.load();
        assertThat(
                config.value("hiber"),
                IsNull.nullValue(null)
        );
    }
}