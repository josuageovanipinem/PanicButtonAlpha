package panic.com.panicbuttonalpha;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Livechat extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livechat);
        WebView liveChat = (WebView) findViewById(R.id.live_chat);
            liveChat.loadUrl("https://servicedesk.bppt.go.id/livechat/index.php");
            liveChat.setWebViewClient(new WebViewClient());
            liveChat.getSettings().setJavaScriptEnabled(true);
            //#todo membuat cache aktif memungkinkan xsss vulnerability
            liveChat.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }
}
