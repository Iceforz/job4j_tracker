package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
   Predicate<Attachment>  att = new Predicate<Attachment>() {
    @Override
    public boolean test(Attachment attachment) {
       boolean rsl = false;
        if (attachment.getSize() > 100) {
            rsl = true;
        }
        return rsl;
    }
};
return filter(list, att);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> att = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                boolean rsl = false;
                if (attachment.getName().contains("bug")) {
                    rsl = true;
                }
return rsl;
            }
        };
        return filter(list, att);
    }

    public static List<Attachment> filter(List<Attachment> att, Predicate<Attachment> pr) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment item : att) {
            if (pr.test(item)) {
                rsl.add(item);
            }
        }
        return rsl;
    }
}
