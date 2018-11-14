package concurrent.executeService.completionService;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class Info {

    private String info;

    public Info(String info) {
        this.info = info;
    }


    public InfoData downloadInfo() throws InterruptedException {

        System.out.println(info+"---downloading infodata!");
        Thread.sleep(1500);

        System.out.println(info+"--get");
        return new InfoData(info + " data");

    }

}
