package headline.news.newsheadline.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import headline.news.newsheadline.browser.FullNews;
import headline.news.newsheadline.R;
import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * Created by prakash-bala on 14/12/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<NewsModel> newsList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }


    public NewsAdapter(Context context,List<NewsModel> newsList) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NewsModel news = newsList.get(position);
        holder.title.setText(news.getTitle());
        Picasso.with(context)
                .load(news.getThumbnail())
                .transform(new BlurTransformation(context))
                .into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sourceUrl = news.getSourceUrl();
                Intent intent = new Intent(context, FullNews.class);
                intent.putExtra("sourceUrl",sourceUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}