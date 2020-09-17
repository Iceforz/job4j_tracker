package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        Address address = new Address("Moscow", "M.Filevskaya", 27, 59);
        List<Profile> profile = Collections.singletonList(new Profile(address));
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profile).get(0), is(address));
    }
}