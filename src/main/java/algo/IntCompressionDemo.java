package algo;

import me.lemire.integercompression.differential.IntegratedIntCompressor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lei
 * @date 08/15/2021 4:10 PM
 */
public class IntCompressionDemo {
    public static void main(String[] args) throws InterruptedException {
        try {
            throw new InterruptedException();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis());
        }
        IntegratedIntCompressor iic = new IntegratedIntCompressor();
        int[] data = {3,5,7,4,3,7,3,67,3,2,6,3,21,4,1,1,11,1,1,1,1,1,1,1,1,1,7,11,5,1,1,1,1,1,1,1,2,6};
        int[] compressed = iic.compress(data);
        int[] recov = iic.uncompress(compressed);

        System.out.println(data.length);
        System.out.println(compressed.length);
        System.out.println(recov.length);

        System.out.println();

        Set<Integer> set = new HashSet<>();
        long m1 = Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 100; i++) {
            set.add(Integer.MAX_VALUE);
            if (i % 10 == 0) {
                long m2 = Runtime.getRuntime().freeMemory();
                System.out.println(m1 - m2);
            }
        }
    }
}