package com.example.alaba.retrofittest.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alaba.retrofittest.models.DefaultResponse;
import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.api.RetrofitClient;
import com.example.alaba.retrofittest.storage.SPManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    EditText nane, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.editTextEmail);
        findViewById(R.id.buttonSignUp).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (SPManager.getInstance(this).isLogged()){
            Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userSignUp(){
        retrofit2.Call<DefaultResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .createUser("jerrycoalaba@gmail.com", "jerrycomalupet");

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                Toast.makeText(SignUpActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "No Internet", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSignUp:
                Toast.makeText(getApplicationContext(), "HMES", Toast.LENGTH_LONG).show();
                userSignUp();
                break;

            case R.id.textViewLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
