package tw.org.iii.iiiand13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        initWebView();
    }

    private void initWebView(){
        WebViewClient webViewCliet = new WebViewClient();
        webView.setWebViewClient(webViewCliet);//用戶端的角色


        WebSettings webSettings = webView.getSettings();
        //webSettings.setUseWideViewPort(true);
        //webSettings.setLoadWithOverviewMode(true);

        webSettings.setJavaScriptEnabled(true); //呈現javascript
        //webSettings.setSupportZoom(true);
        //webSettings.setBuiltInZoomControls(true);
        //webSettings.setDisplayZoomControls(true);
        webView.loadUrl("file:///android_asset/brad.html");//檔案系統的通訊協定,講一個東西,資產不要加s



        //與網頁溝通,需要用js
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.v("brad","keyCode" + keyCode);

        if(keyCode == 4 && webView.canGoBack()){ //欲返回上一頁
            webView.goBack();
            //webView.goForward();
            //webView.reload();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //onBackPressed由//super.onKeyDown(keyCode, event);觸發
    //饅頭按鈕不能作用, web view沒有支援javascript, 預設是沒有提供,允許設定在 initWebView()

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v("brad","BackPress");
    }
}
