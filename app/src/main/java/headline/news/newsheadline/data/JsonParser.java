package headline.news.newsheadline.data;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import headline.news.newsheadline.utils.Utils;
import headline.news.newsheadline.model.NewsModel;
import headline.news.newsheadline.adapter.NewsAdapter;


/**
 * Created by prakash-bala on 14/12/16.
 */

public class JsonParser extends AsyncTask<Void, Void, Void> {
    private NewsAdapter newsAdapter;
    private  String source;
    private List<NewsModel> newsList;
    private ProgressBar progressBar;
   // private  String url = "https://newsapi.org/v1/articles?source="+source+"&sortBy=top&apiKey="+apiKey;

    String url ;


    public JsonParser(NewsAdapter newsAdapter,List<NewsModel> newsList,ProgressBar progressBar,String source)
    {
        this.newsAdapter = newsAdapter;
        this.newsList = newsList;
        this.progressBar = progressBar;
        this.source = source;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    protected Void doInBackground(Void... arg0) {
        RequestHandler sh = new RequestHandler();
        Log.i("urlString",source);
        String jsonStr = sh.makeServiceCall(Utils.urlToHit(source));
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray lArr = jsonObj.optJSONArray("articles");

                for (int i = 0; i < lArr.length(); i++) {

                    JSONObject c = lArr.getJSONObject(i);

                        String title = c.getString("title");
                        String imageUrl = c.getString("urlToImage");
                        String sourceUrl = c.getString("url");
                    Log.i("newstitle",title+" "+imageUrl);
                    NewsModel news = new NewsModel(title,imageUrl,sourceUrl);
                    newsList.add(news);


                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("myinfo", "> " + e);
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        newsAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}