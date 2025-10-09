package com.example.calculadora_iker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("LifeCycle", "onCreate");

        //Button b = findViewById(R.id.ButtonOperar);

       // TextView textOp = findViewById(R.id.TextoOperacion);

       /* b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOp.setText(textOp.getText() + "1");
            }
        });

        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }
}