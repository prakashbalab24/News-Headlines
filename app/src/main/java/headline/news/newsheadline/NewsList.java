package headline.news.newsheadline;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import headline.news.newsheadline.adapter.NewsAdapter;
import headline.news.newsheadline.adapter.NewsListAdapter;
import headline.news.newsheadline.data.JsonParser;
import headline.news.newsheadline.model.NewsModel;

public class NewsList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsListAdapter newsAdapter;
    private List<NewsModel> newsSourceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        newsAdapter = new NewsListAdapter(this,newsSourceList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newsAdapter);

        prepareAlbums();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Uri uri = Uri.parse("http://www.opensourceandroid.in");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        return true;
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.github};

        NewsModel a = new NewsModel("Cnn",covers[0]);
        newsSourceList.add(a);

        a = new NewsModel("cnn",covers[0]);
        newsSourceList.add(a);
        a = new NewsModel("bbc-news",covers[0]);
        newsSourceList.add(a);
        a = new NewsModel("bbc-news",covers[0]);
        newsSourceList.add(a);
        a = new NewsModel("cnn",covers[0]);
        newsSourceList.add(a);
        a = new NewsModel("cnn",covers[0]);
        newsSourceList.add(a);


        newsAdapter.notifyDataSetChanged();
    }
}
