package concurrent.executeService.invokeAll;

import java.util.List;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class Test {

    public static void main(String[] args) {
//        double random = Math.random()*10;
//        int i = (int) random;
//        System.out.println(i);
//        System.out.println(random);
        TaskService taskService = new TaskService();
        List<Data> res = taskService.execute();
        for (Data re : res) {
            if (re != null) {
                System.out.println("getData "+re.getId());
            }
        }

        taskService.shutdown();
    }

}
