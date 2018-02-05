import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
    @Test
    public void TestList() {
        testArrayList();
        System.out.println();
        testLinkedList();
    }

    private void testArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        int maxTestCount = 100000;

        System.out.println(maxTestCount + " 条数据");
        //测试添加
        long start = System.currentTimeMillis();

        for (int i = 0; i < maxTestCount; i++) {
            list.add(0, String.valueOf(i));
        }

        long end = System.currentTimeMillis();

        System.out.println("ArrayList 新增耗时 :" + (end - start));
        //测试查询
        start = System.currentTimeMillis();

        for (int i = 0; i < maxTestCount; i++) {
            list.get(i);
        }

        end = System.currentTimeMillis();

        System.out.println("ArrayList 查询耗时 :" + (end - start));

        //测试查询
        start = System.currentTimeMillis();

        for (int i = maxTestCount; i > 0; i--) {
            list.remove(0);
        }

        end = System.currentTimeMillis();
        System.out.println("ArrayList 删除耗时 :" + (end - start));
    }


    private void testLinkedList() {
        LinkedList<String> list = new LinkedList<String>();
        int maxTestCount = 50000;

        //测试添加
        long start = System.currentTimeMillis();

        System.nanoTime();

        for (int i = 0; i < maxTestCount; i++) {
            list.add(0, String.valueOf(i));
        }

        long end = System.currentTimeMillis();
        System.out.println("LinkedList 新增耗时:" + (end - start));

        //测试查询
        start = System.currentTimeMillis();

        for (int i = 0; i < maxTestCount; i++) {
            list.get(i);
        }

        end = System.currentTimeMillis();

        System.out.println("LinkedList 查询耗时:" + (end - start));

        //测试查询
        start = System.currentTimeMillis();

        for (int i = maxTestCount; i > 0; i--) {
            list.remove(0);
        }

        end = System.currentTimeMillis();

        System.out.println("LinkedList 删除耗时:" + (end - start));
    }
}
