package com.bdtask.mvvmpractice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bdtask.mvvmpractice.R;
import com.bdtask.mvvmpractice.model.UserResponse;
import com.bdtask.mvvmpractice.viewmodel.MainActivityViewModel;
import com.google.gson.Gson;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    EditText editText1, editText2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getAllUserData().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                Log.d("Testing", "onChanged: "+userResponse.getResponse().getMessage());
            }
        });

        /*editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String resultText=mainActivityViewModel.additionFunction(editText1.getText().toString(),editText2.getText().toString());
//                Toast.makeText(MainActivity.this, resultText, Toast.LENGTH_SHORT).show();

//                mainActivityViewModel.additionFunction(editText1.getText().toString(),editText2.getText().toString()).observe(
//                        MainActivity.this, new Observer<String>() {
//                            @Override
//                            public void onChanged(String s) {
//                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );


            }
        });*/
    }
}
