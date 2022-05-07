package googleguavademo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei
 * @date 11/29/2021 3:21 PM
 */
public class ListPartitionDemo {
    public static void main(String[] args) {
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(277L); ids.add(278L); ids.add(279L); ids.add(280L); ids.add(281L);

        List<List<Long>> lists = Lists.partition(ids, 3);
        for (List<Long> list: lists){
            for (Long e : list) {
                System.out.println(e);
            }
            System.out.println(" >>> ");
        }

    }
}
