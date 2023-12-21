package com.example.ck_room;


import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;


public class Paypal extends AppCompatActivity {

    private static final String TAG = "PayPalActivity";

    // Replace with your own PayPal client ID
    private static final String PAYPAL_CLIENT_ID = "AZeZl8wi8CIspbP-gDFg66Lzn-fFG7WQ78jUJ-VFW_Q7GJRny6Fa1G8ZILsv00iGV9jFb2Dc2V8UCbi-";

    private static final int PAYPAL_REQUEST_CODE = 7171;

    private PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK) // Use sandbox for testing
            .clientId(PAYPAL_CLIENT_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

        makePayment();
    }

    private void makePayment() {
        Intent i = getIntent();

        double money = Double.parseDouble( i.getStringExtra("money"));

        PayPalPayment payPalPayment = new PayPalPayment(

                new BigDecimal(money), "USD", " Payment",
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        Log.i(TAG, "onActivityResult: " + confirmation.toJSONObject().toString(4));

                        // Handle successful payment here
                        Intent payIntent = new Intent(this, User_page.class);
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                        startActivity(payIntent);
                    } catch (JSONException e) {
                        Log.e(TAG, "onActivityResult: Error: " + e.getMessage());
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.i(TAG, "onActivityResult: Payment canceled");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(TAG, "onActivityResult: Invalid payment");
            }
        }
    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}
