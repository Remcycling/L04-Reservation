package sg.edu.rp.c346.id22045554.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;

    Button btnSubmit;
    Button btnReset;

    RadioGroup smoke;
    RadioButton smoking;
    RadioButton nonsmoking;

    EditText name;
    EditText phone;
    EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.mobile);
        num = findViewById(R.id.people);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.submit);
        btnReset = findViewById(R.id.reset);
        smoke = findViewById(R.id.zone);
        smoking = findViewById(R.id.smoking);
        nonsmoking = findViewById(R.id.nonsmoking);



        tp.setHour(19);
        tp.setMinute(30);
        dp.updateDate(2023,05,01);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hour = "" + tp.getHour();
                String min = "" + tp.getMinute();
                String setTime = " Time: " + hour +":"+ min;


                String year = "" + dp.getYear();
                String month = "" + (dp.getMonth()+1);
                String day = "" + dp.getDayOfMonth();
                String setDate = " Date: " + day + "/" + month + "/"  + year;



                String message = "";
                int smokeChecked = smoke.getCheckedRadioButtonId();
                if (smokeChecked == R.id.smoking) {
                    message = "Smoking";
                }
                else {
                    message = "Non-Smoking";
                }

                String nameText = "Name: "+ name.getText();
                String mobileText = " Mobile no: "+ phone.getText();
                String numText = " No. of people: "+ num.getText();
                String zoneOP = " Area: "+ message;




                Toast.makeText(MainActivity.this, nameText + mobileText + numText + setDate + setTime + zoneOP,
                        Toast.LENGTH_LONG).show();




            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setHour(19);
                tp.setMinute(30);
                dp.updateDate(2023,05,01);

                name.setText("");
                phone.setText("");
                num.setText("");

                smoking.setChecked(false);
                nonsmoking.setChecked(false);



            }
        });






    }
}