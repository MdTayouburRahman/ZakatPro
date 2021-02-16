package droidrocks.com.zakatpro;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        topBar();
        SetupNavDrawer();
        RateAppAlert();
    }

    private void init() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        MaterialCardView classOne = findViewById(R.id.card1);
        MaterialCardView classTwo = findViewById(R.id.card2);
        MaterialCardView classThree = findViewById(R.id.card3);
        MaterialCardView classFour = findViewById(R.id.card4);


        classOne.setOnClickListener(this);
        classTwo.setOnClickListener(this);
        classThree.setOnClickListener(this);
        classFour.setOnClickListener(this);


    }

    private void topBar() {

        topAppBar = findViewById(R.id.topAppBar);


        topAppBar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.about) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            }


            return false;
        });
    }

    private void SetupNavDrawer() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, topAppBar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.MoreApp) {

                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Droid+Rocks")));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/developer?id=Droid+Rocks")));
                    }

                }


                if (item.getItemId() == R.id.feedbackid) {

                    Intent Email = new Intent(Intent.ACTION_SEND);
                    Email.setType("text/email");
                    Email.putExtra(Intent.EXTRA_EMAIL, new String[]{"tayoburrahman119@gmail.com"});
                    Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback About " + getPackageName());
                    Email.putExtra(Intent.EXTRA_TEXT, "Hello..\n" + "");
                    startActivity(Intent.createChooser(Email, "Send Feedback:"));

                }
                if (item.getItemId() == R.id.about) {
                    startActivity(new Intent(MainActivity.this, AboutActivity.class));
                }
                if (item.getItemId() == R.id.shareid) {
                    Uri url = Uri.parse("http://play.google.com/store/apps/details?id=" + Objects.requireNonNull(getApplicationContext()).getPackageName());

                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Download " + R.string.app_name + " from this Url";
                    String shareSub = String.valueOf(R.string.app_name);
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody + url);
                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                }
                if (item.getItemId() == R.id.rateAppid) {
                    Uri uri = Uri.parse("market://details?id=" + Objects.requireNonNull(getApplicationContext()).getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    // To count with Play market backstack, After pressing back button,
                    // to taken back to our application, we need to add following flags to intent.
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                    }
                }
                if (item.getItemId() == R.id.exitid) {

                    AlertDialog.Builder alertDialogBuilder;
                    alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setIcon(R.drawable.alerticon);
                    alertDialogBuilder.setTitle("do you want to exit application?");
                    alertDialogBuilder.setMessage("Press 'Yes' if you want to exit the app.\n" +
                            " If you do not want to leave the app, press 'No'.");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> {
                        finish();
                        System.exit(0);
                    });

                    alertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }


                return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {

            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setIcon(R.drawable.alerticon);
            alertDialogBuilder.setTitle("Do you want to exit application?");
            alertDialogBuilder.setMessage("Press 'Yes' if you want to exit the app.If you do not want to leave the app, press 'No'.");

            alertDialogBuilder.setCancelable(false);


            alertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> {
                finish();
                System.exit(0);
            });

            alertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.card1) {
           Intent intent = new Intent(MainActivity.this,PersonalPropertyActivity.class);
           intent.putExtra("pageTitle","ব্যাক্তিগত সম্পদের যাকাত");
           startActivity(intent);
        }
        if (v.getId() == R.id.card2) {
            startActivity(new Intent(MainActivity.this,BusinessPropertyActivity.class)
                    .putExtra("pageTitle","ব্যবসায়িক সম্পদের যাকাত"));

        }
        if (v.getId() == R.id.card3) {
            startActivity(new Intent(MainActivity.this,SharedBusinessPropertyActivity.class)
                    .putExtra("pageTitle","যৌথ মালিকানার ব্যবসায়িক সম্পদের যাকাত"));
        }
        if (v.getId() == R.id.card4) {
            startActivity(new Intent(MainActivity.this,ZakatInfoActivity.class).putExtra("pageTitle","যাকাত সম্পর্কিত তথ্য।"));
        }


    }

    public void RateAppAlert() {

        AppRate.with(this)
                .setInstallDays(1) // default 10, 0 means install day.
                .setLaunchTimes(2) // default 10
                .setRemindInterval(2) // default 1
                .setShowLaterButton(true) // default true
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);


    }
}

