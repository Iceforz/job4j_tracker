package ru.job4j.lambda;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        Comparator comparator;
        comparator = (o1, o2) -> {
            Attachment left = (Attachment) o1;
            Attachment right = (Attachment) o2;
            return left.getSize() - right.getSize();
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> res = (o1, o2) -> o2.getSize() - o1.getSize();
        attachments.sort(res);
        System.out.println(attachments);
    }
}
