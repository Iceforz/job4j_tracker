package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String z : value) {
            rsl += 1;
            if (z.equals(key)) {
                return rsl;
            }

        }
        throw new ElementNotFoundException("There's no such element");
    }

    public static void main(String[] args) {
        try {
            int result = indexOf(new String[]{"a", "b", "c", "d"}, "c");
            System.out.println(result);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
