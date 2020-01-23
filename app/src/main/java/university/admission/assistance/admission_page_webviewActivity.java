package university.admission.assistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class admission_page_webviewActivity extends AppCompatActivity {
    private WebView webView;
    private String ADMISSION_URL="https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_page_webview);
        loadAll();
    }
    private void loadAll(){
        loadIntentData();
        webView=(WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(ADMISSION_URL);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    private void loadIntentData(){
        ADMISSION_URL=getIntent().getExtras().getString(Dbcontract.ADMISSION_UNIT_LINK_KEY);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }
}