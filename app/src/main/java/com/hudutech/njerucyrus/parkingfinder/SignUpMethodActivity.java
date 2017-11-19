package com.hudutech.njerucyrus.parkingfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lamudi.phonefield.PhoneEditText;
import com.lamudi.phonefield.PhoneInputLayout;

public class SignUpMethodActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_method);

        final PhoneInputLayout phoneInputLayout = (PhoneInputLayout) findViewById(R.id.phoneInputId);
        final  Button button = (Button) findViewById(R.id.btnNext);

        phoneInputLayout.setDefaultCountry("KE");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;

                // checks if the field is valid
                if (phoneInputLayout.isValid()) {
                    phoneInputLayout.setError(null);
                } else {
                    // set error message
                    phoneInputLayout.setError("invalid phone number");
                    valid = false;
                }



                if (valid) {
                    String phoneNumber = phoneInputLayout.getPhoneNumber();
                    Toast.makeText(SignUpMethodActivity.this, "valid phone number "+phoneNumber, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignUpMethodActivity.this, "invalid phone number", Toast.LENGTH_LONG).show();
                }

                // Return the phone number as follows

            }
        });


    }
}
