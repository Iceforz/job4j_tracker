package ru.job4j.collection;
import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompByNameUp() {
        Comparator<Job> cmpNamePriority = new JobupByName();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 0),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompByPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobupByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 1),
                new Job("B task", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompByPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompCombUp() {
        Comparator<Job> cmpNamePriority = new JobupByName().thenComparing(new JobupByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 1),
                new Job("B task", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompCombDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 2),
                new Job("B task", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}