package droidrocks.com.zakatpro;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;

public class PersonalPropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "";
    private String page_title;
    private Toolbar topAppBar;
    private TextInputEditText nisab, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editTextExcludeMoney;
    private TextView totalAmountTextView, totalAmountZakat;
    private Button calculation, share, copy,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_property);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topBar();
        init();


    }

    private void init() {

        nisab = findViewById(R.id.ETNisab);
        editText1 = findViewById(R.id.ET1);
        editText2 = findViewById(R.id.ET2);
        editText3 = findViewById(R.id.ET3);
        editText4 = findViewById(R.id.ET4);
        editText5 = findViewById(R.id.ET5);
        editText6 = findViewById(R.id.ET6);
        editText7 = findViewById(R.id.ET7);
        editText8 = findViewById(R.id.ET8);
        editTextExcludeMoney = findViewById(R.id.ET9);

        calculation = findViewById(R.id.calculationID);
        copy = findViewById(R.id.copyButton);
        share = findViewById(R.id.shareButton);
        reset = findViewById(R.id.resetID);

        calculation.setOnClickListener(this);
        copy.setOnClickListener(this);
        share.setOnClickListener(this);
        reset.setOnClickListener(this);




        totalAmountTextView = findViewById(R.id.totalAmountTextView);
        totalAmountZakat = findViewById(R.id.totalAmountZakat);


    }

    public void zakatData() {
        // checking editText if its empty
        if (nisab.getText().toString().matches("")) {
            nisab.setError("  নিম্নে নিসাবের পরিমান উল্লেখ করুন (টাকায়)।");
            nisab.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText1.getText().toString().matches("")) {
            editText1.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText1.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText2.getText().toString().matches("")) {
            editText2.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText2.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText3.getText().toString().matches("")) {
            editText3.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText3.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText4.getText().toString().matches("")) {
            editText4.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText4.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText5.getText().toString().matches("")) {
            editText5.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText5.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText6.getText().toString().matches("")) {
            editText6.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText6.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText7.getText().toString().matches("")) {
            editText7.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText7.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editText8.getText().toString().matches("")) {
            editText8.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editText8.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }
        if (editTextExcludeMoney.getText().toString().matches("")) {
            editTextExcludeMoney.setError(" নিম্নে আপনার সম্পদের পরিমান উল্লেখ করুন (টাকায়)। সম্পদ না থাকলে শূন্য '০' দিন।");
            editTextExcludeMoney.requestFocus();
            Log.d(TAG, "zakatData:checked");
            return;
        }


        //--------------------------
        String nisabvalue = nisab.getText().toString();
        String data1 = editText1.getText().toString();
        String data2 = editText2.getText().toString();
        String data3 = editText3.getText().toString();
        String data4 = editText4.getText().toString();
        String data5 = editText5.getText().toString();
        String data6 = editText6.getText().toString();
        String data7 = editText7.getText().toString();
        String data8 = editText8.getText().toString();
        String excluedData = editTextExcludeMoney.getText().toString();


        ZakatCalculation zakatCalculation = new ZakatCalculation();
        double zakatAmmoutn = zakatCalculation.PersonalPropertyCalculation( this,nisabvalue, data1, data2,
                data3, data4, data5,data6, data7, data8, excluedData);

        DecimalFormat df = new DecimalFormat("00.00");

        if (zakatAmmoutn == 0) {
            try {
                totalAmountZakat.setText("নিসাব পরিমাণ সম্পদ নেই।");

            }catch (Exception e){
                Log.d(TAG, "zakatData: "+e.getMessage());
            }


        } else {
            totalAmountZakat.setText(String.valueOf(df.format(zakatAmmoutn) + " Taka"));
        }


        int totalZakatProperty = zakatCalculation.TotalZakatProperty(data1, data2, data3, data4, data5, data6, data7, data8, excluedData);
        totalAmountTextView.setText(String.valueOf(df.format(totalZakatProperty) + "Taka"));
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

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.calculationID){
            zakatData();

        }
        if (v.getId()==R.id.copyButton){

            if (totalAmountTextView.getText().toString().matches("")) {
                totalAmountTextView.setError("No Text Found");
                totalAmountTextView.requestFocus();
                Log.d(TAG, "zakatData:checked");
                return;
            }

            if (totalAmountZakat.getText().toString().matches("")) {
                totalAmountZakat.setError("No Text Found");
                totalAmountZakat.requestFocus();
                Log.d(TAG, "zakatData:checked");
                return;
            }

            String data1 = totalAmountTextView.getText().toString();
            String data2 = totalAmountZakat.getText().toString();

            try {
                ClipboardManager clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("", "সমস্ত সম্পদের পরিমান = "+data1 +"\n"+"২.৫% হারে আপনার মোট যাকাতের পরিমাণ = "+data2);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(this, "Copied!", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }

        }
        if (v.getId()==R.id.shareButton){

            if (totalAmountTextView.getText().toString().matches("")) {
                totalAmountTextView.setError("No Text Found");
                totalAmountTextView.requestFocus();
                Log.d(TAG, "zakatData:checked");
                return;
            }

            if (totalAmountZakat.getText().toString().matches("")) {
                totalAmountZakat.setError("No Text Found");
                totalAmountZakat.requestFocus();
                Log.d(TAG, "zakatData:checked");
                return;
            }

            String data1 = totalAmountTextView.getText().toString();
            String data2 = totalAmountZakat.getText().toString();

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareSub = this.getPackageName() + "\n";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "সমস্ত সম্পদের পরিমান = "+data1 +"\n"+"২.৫% হারে আপনার মোট যাকাতের পরিমাণ = "+data2);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));



        }
        if (v.getId()==R.id.resetID){

            totalAmountTextView.setText("");
            totalAmountZakat.setText("");
            nisab.setText("");
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            editText6.setText("");
            editText7.setText("");
            editText8.setText("");
            editTextExcludeMoney.setText("");

        }


    }
}