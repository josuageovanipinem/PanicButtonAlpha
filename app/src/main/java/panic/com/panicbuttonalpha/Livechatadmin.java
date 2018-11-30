package panic.com.panicbuttonalpha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Livechatadmin extends AppCompatActivity {

    String unencodedHtml = "https://servicedesk.bppt.go.id/livechat/index.php/site_admin/user/login";
    String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
            Base64.NO_PADDING);

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livechatadmin);
        WebView liveChat = (WebView) findViewById(R.id.live_chat);
        liveChat.loadData(encodedHtml, "text/html", "base64");
        liveChat.setWebViewClient(new WebViewClient());
        liveChat.getSettings().setJavaScriptEnabled(true);
        //#todo membuat cache aktif memungkinkan xsss vulnerability
        liveChat.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        liveChat.loadUrl(unencodedHtml);

    }
}