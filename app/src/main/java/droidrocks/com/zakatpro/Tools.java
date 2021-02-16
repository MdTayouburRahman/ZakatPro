package droidrocks.com.zakatpro;

import android.util.Log;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class Tools {

    public Tools() {
    }

    public void CheckEditText (TextInputEditText editText){

        Log.d("TAG", "CheckEditText: isChecked");
        if (editText.getText().toString().matches("")){
            editText.setError("Please Enter this Value");
            editText.requestFocus();
            return;

         }



    }
}
