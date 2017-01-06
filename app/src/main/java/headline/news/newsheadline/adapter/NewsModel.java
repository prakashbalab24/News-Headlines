package headline.news.newsheadline.adapter;

/**
 * Created by prakash-bala on 14/12/16.
 */

public class NewsModel {
    private String title;
    private String thumbnail;
    private String sourceUrl;

    public NewsModel() {
    }

    public NewsModel(String title, String thumbnail,String sourceUrl) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}