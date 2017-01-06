package headline.news.newsheadline.browser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import headline.news.newsheadline.R;

public class FullNews extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);
        webView = (WebView)findViewById(R.id.webView);
        progressBar = (ProgressBar)findViewById(R.id.fullNewsPB);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {

                setTitle("Please Wait...");
                setProgress(progress * 100);
                if(progress >= 80) {
                    progressBar.setVisibility(View.GONE);
                    setTitle(R.string.toolbar_title);
                }

            }
        });
        webView.canGoBack();
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String sourceUrl = intent.getStringExtra("sourceUrl");
        if(sourceUrl!=null){
            webView.loadUrl(sourceUrl);
        }
    }

}
