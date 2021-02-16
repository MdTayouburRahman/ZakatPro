package droidrocks.com.zakatpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class ZakatInfoActivity extends AppCompatActivity {

    private PDFView pdfViewer;
    private TextView pageNumber;
    private ProgressDialog progress;
    private Toolbar topAppBar;
    private String page_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_info);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //  Fixed Portrait orientation
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //remove the notifcation bar

        topBar();

        pdfViewer = findViewById(R.id.pdfView);
        pageNumber = findViewById(R.id.pageNumber);



        pdfWork();
    }

    private void pdfWork() {


        progress = new ProgressDialog(this);
        progress.setTitle("Loading PDF");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        // To dismiss the dialog

        pdfViewer.fromAsset("zakat.pdf")


                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {

                        progress.dismiss();
                    }
                })
                // allows to draw something on the current page, usually visible in the middle of the screen
                .onPageChange(new OnPageChangeListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPageChanged(int page, int pageCount) {

                        pageNumber.setText("Page -" + page + "/" + pageCount);

                    }
                })
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(ZakatInfoActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                })
                .onPageError(new OnPageErrorListener() {
                    @Override
                    public void onPageError(int page, Throwable t) {
                        Toast.makeText(ZakatInfoActivity.this, "Error Page" + page, Toast.LENGTH_SHORT).show();
                    }
                })

                .password(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(true) // snap pages to screen boundaries
                .load();


    }

    private void topBar() {

        Intent intentData = getIntent();
        page_title = intentData.getStringExtra("pageTitle");

        topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setTitle(page_title);


        topAppBar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.about) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            }

            return false;
        });

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}