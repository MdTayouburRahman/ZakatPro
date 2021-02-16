package droidrocks.com.zakatpro;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class ZakatCalculation {
    double retunZakat = 0;


    public ZakatCalculation() {
    }

    public double PersonalPropertyCalculation(Context context, String nisab, String s1, String s2,
                                              String s3, String s4, String s5,
                                              String s6, String s7, String s8,
                                              String excludeMoney) {

        try {

            int data1 = Integer.parseInt(s1);
            int data2 = Integer.parseInt(s2);
            int data3 = Integer.parseInt(s3);
            int data4 = Integer.parseInt(s4);
            int data5 = Integer.parseInt(s5);
            int data6 = Integer.parseInt(s6);
            int data7 = Integer.parseInt(s7);
            int data8 = Integer.parseInt(s8);

            int totalMoney = data1 + data2 + data3 + data4 + data5 + data6 + data7 + data8;
            int currentNisab = Integer.parseInt(nisab);
            int excludeValue = Integer.parseInt(excludeMoney);
            int zakatProperty = totalMoney - excludeValue;

            if (zakatProperty > currentNisab) {
                retunZakat = zakatProperty * 0.025;
            } else {
                Log.d("TAG", "PersonalPropertyCalculation: Zakat not foroz");
            }

        } catch (Exception e) {
            Log.d("TAG", "PersonalPropertyCalculation: Exception is "+e.getMessage());
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

        }
        return retunZakat;
    }


    public double BusinessPropertyCalculation(Context context, String nisab, String s1, String s2,
                                              String s3, String s4, String s5,
                                              String s6, String s8,
                                              String excludeMoney) {

        try {

            int data1 = Integer.parseInt(s1);
            int data2 = Integer.parseInt(s2);
            int data3 = Integer.parseInt(s3);
            int data4 = Integer.parseInt(s4);
            int data5 = Integer.parseInt(s5);
            int data6 = Integer.parseInt(s6);
            int data8 = Integer.parseInt(s8);

            int totalMoney = data1 + data2 + data3 + data4 + data5 + data6 + data8;
            int currentNisab = Integer.parseInt(nisab);
            int excludeValue = Integer.parseInt(excludeMoney);
            int zakatProperty = totalMoney - excludeValue;

            if (zakatProperty > currentNisab) {
                retunZakat = zakatProperty * 0.025;
            } else {
                Log.d("TAG", "PersonalPropertyCalculation: Zakat not foroz");
            }

        } catch (Exception e) {
            Log.d("TAG", "PersonalPropertyCalculation: Exception is "+e.getMessage());
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

        }
        return retunZakat;
    }






    public int TotalZakatProperty(String s1,String s2,
                                              String s3,String s4,String s5,
                                              String s6,String s7,String s8,
                                              String excludeMoney) {

        int data1 = Integer.parseInt(s1);
        int data2 = Integer.parseInt(s2);
        int data3 = Integer.parseInt(s3);
        int data4 = Integer.parseInt(s4);
        int data5 = Integer.parseInt(s5);
        int data6 = Integer.parseInt(s6);
        int data7 = Integer.parseInt(s7);
        int data8 = Integer.parseInt(s8);

        int totalMoney = data1 + data2 + data3 + data4 + data5 + data6 + data7 + data8;
        int excludeValue = Integer.parseInt (excludeMoney);
        int zakatProperty = totalMoney - excludeValue;
        return zakatProperty;
    }

    public int TotalBusinessZakatProperty(String s1,String s2,
                                  String s3,String s4,String s5,
                                  String s6,String s8,
                                  String excludeMoney) {

        int data1 = Integer.parseInt(s1);
        int data2 = Integer.parseInt(s2);
        int data3 = Integer.parseInt(s3);
        int data4 = Integer.parseInt(s4);
        int data5 = Integer.parseInt(s5);
        int data6 = Integer.parseInt(s6);
        int data8 = Integer.parseInt(s8);

        int totalMoney = data1 + data2 + data3 + data4 + data5 + data6 + data8;
        int excludeValue = Integer.parseInt (excludeMoney);
        int zakatProperty = totalMoney - excludeValue;
        return zakatProperty;
    }
}
