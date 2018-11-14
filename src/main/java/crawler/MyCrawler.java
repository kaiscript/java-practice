package crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by chenkai on 2018/3/14.
 */
public class MyCrawler extends WebCrawler {

    StringBuilder sb = new StringBuilder();
    PrintWriter writer = new PrintWriter("E:/Coding/robotName.txt","UTF-8");


    /**
     * 正则表达式匹配指定的后缀文件
     */
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp4|zip|gz))$");

    public MyCrawler() throws FileNotFoundException, UnsupportedEncodingException {
    }

    /**
     * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
     * 第一个参数referringPage封装了当前爬取的页面信息 第二个参数url封装了当前爬取的页面url信息
     * 在这个例子中，我们指定爬虫忽略具有css，js，git，...扩展名的url，只接受以“http://www.ics.uci.edu/”开头的url。
     * 在这种情况下，我们不需要referringPage参数来做出决定。
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();// 得到小写的url
        return !FILTERS.matcher(href).matches() // 正则匹配，过滤掉我们不需要的后缀文件
                && href.startsWith("http://www.nibaku.com") && href.contains("wangming");//
    }

    /**
     * 当一个页面被提取并准备好被你的程序处理时，这个函数被调用。
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();// 获取url
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {// 判断是否是html数据
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();//// 强制类型转换，获取html数据对象
            String text = htmlParseData.getText();//获取页面纯文本（无html标签）
            Set<WebURL> links = htmlParseData.getOutgoingUrls();// 获取页面输出链接

            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html, "UTF-8");
            Elements elements = doc.select("#content");
            for (Element element : elements) {
                Elements p = element.select("p");
                for (Element e : p) {
                    System.out.println(e.html());
                    sb.append(e.html()).append("\r\n");
                }
            }
            writer.print(sb.toString());
            writer.flush();
        }

    }

}
