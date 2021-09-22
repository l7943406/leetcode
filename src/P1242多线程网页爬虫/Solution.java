package P1242多线程网页爬虫;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

interface HtmlParser {
    public List<String> getUrls(String url);
}

class Solution implements Runnable{
    private static ConcurrentHashMap<String,Object> concurrentHashMap;
    private static HtmlParser htmlParser;
    private static String baseUrl;
    private static List<String> ans;
    private static ThreadPoolExecutor executor;
    private String startUrl;

    public Solution(){

    }
    public Solution(String startUrl){
        this.startUrl = startUrl;
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Solution.concurrentHashMap = new ConcurrentHashMap<>();
        Solution.baseUrl = getBaseUrl(startUrl);
        Solution.htmlParser = htmlParser;
        Solution.ans = new LinkedList<>();
        Solution.executor = new ThreadPoolExecutor(32
                , 1000
                , 1
                , TimeUnit.DAYS
                , new LinkedBlockingQueue<>(32));
        ans.add(startUrl);
        concurrentHashMap.put(startUrl, startUrl);
        this.startUrl = startUrl;
        executor.execute(this);
        return ans;
    }
    private String getBaseUrl(String url){
        for (int i = 7; i < url.length(); i++) {
            if(url.charAt(i) == '/'){
                return url.substring(0,i);
            }
        }
        return url;
    }
    private boolean isBase(String url){
        if(url.length() < baseUrl.length()){
            return false;
        }
        for (int i = 0; i < baseUrl.length(); i++) {
            if(baseUrl.charAt(i) != url.charAt(i)){
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        List<String> urls = htmlParser.getUrls(startUrl);
        for (String url : urls) {
           if(isBase(url) && !concurrentHashMap.containsKey(url)){
               System.out.println(url);
               concurrentHashMap.put(url, url);
               ans.add(url);
               Solution solution= new Solution(url);
               executor.execute(solution);
           }
        }
    }

}