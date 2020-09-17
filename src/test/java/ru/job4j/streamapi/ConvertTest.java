package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvertTest {

    @Test
    public void whenMatrixToList() {
        Convert convert = new Convert();
        Integer[][] num = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = convert.swapToList(num);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}