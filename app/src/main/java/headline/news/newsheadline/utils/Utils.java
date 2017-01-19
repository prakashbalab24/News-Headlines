package headline.news.newsheadline.utils;

import android.util.Log;

/**
 * Created by prakash-bala on 19/1/17.
 */

public class Utils {
    private static String apiKey="c4b530e1fe0f401daa7a236257a865c0";

    public static String urlToHit(String source){
        String url="https://newsapi.org/v1/articles?source="+source+"&sortBy=top&apiKey="+apiKey;

        return url;
    }
}
