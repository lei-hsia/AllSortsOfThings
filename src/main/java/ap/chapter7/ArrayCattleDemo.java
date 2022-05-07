package ap.chapter7;

import ap.chapter3.Cattle;

/**
 * @author lei
 * @date 01/07/2022 10:20 AM
 */
public class ArrayCattleDemo {
    public static void main(String[] args) {
        Cattle cow = new Cattle(400,10,false,"cow");
        Cattle steer = new Cattle(1000, 8, true, "steer");
        Cattle[] cattle = {cow, steer};
        /*
         *  objects:
         *       enhanced for loop: modify: same reason, doesn't work
         * */
        for (Cattle c: cattle) {
            if ("cow".equals(c.getType())){
                c = new Cattle();
            }
        }
        for (Cattle c: cattle) {
            System.out.println(c);
        }
        System.out.println();
        /*
         *  objects:
         *       for i loop: modify
         * */
        for (int i = 0; i < cattle.length; i++) {
            if ("cow".equals(cattle[i].getType())){
                cattle[i] = new Cattle();
            }
        }
        for (Cattle c: cattle) {
            System.out.println(c);
        }
        System.out.println();
        /*
         * objects:
         *   enhanced for loop : can modify object fields
         *   and : change object fields
         * */
        for (Cattle c: cattle) {
            if (c.getWeight() < 500) {
                c.setWeight(500);
            }
        }
        for (Cattle c: cattle) {
            System.out.println(c);
        }
        System.out.println();
    }
}
