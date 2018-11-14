package concurrent.executeService.completionService;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kaiscript on 2017/5/13.
 */
public class Renderer {

    public void renderInfo() {
        List<Info> infos = getInfos();
        CompletionService service = new CompletionService();
        for (final Info info : infos) {
            service.submit(() -> {
                return info.downloadInfo();
            });

        }
        executeText();
        for (Info info : infos) {
            try {
                Future<InfoData> f = service.take();
                InfoData infoData = f.get();
                renderInfoData(infoData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        service.shutdown();
    }

    private void renderInfoData(InfoData infoData) {
        System.out.println("renderInfoData:"+infoData.getData());
    }

    private void executeText() {
        System.out.println("executeText");
    }


    private List<Info> getInfos() {
        Info info = new Info("1");
        Info info1 = new Info("2");
        Info info2 = new Info("3");
        List<Info> result = Lists.newArrayList(info, info1, info2);
        return result;
    }

}
