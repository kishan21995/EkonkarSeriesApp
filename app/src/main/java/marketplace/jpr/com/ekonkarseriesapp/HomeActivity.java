package marketplace.jpr.com.ekonkarseriesapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class HomeActivity extends AppCompatActivity {
    ActionBar toolbar;
    WebView webView;
    private Toolbar homeToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeToolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(homeToolbar);
        homeToolbar.setTitle("Home");

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        webView = findViewById(R.id.webview);
        webView.loadUrl("http://ekonkarseries.org/");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
      /*  if (item.getItemId() == R.id.edit_user) {
            Intent intent = new Intent(ProfileActivity.this, UpdateActivity.class);
            startActivity(intent);
            finish();
            return true;
        }*/
        return super.onOptionsItemSelected(item);


    }

}
