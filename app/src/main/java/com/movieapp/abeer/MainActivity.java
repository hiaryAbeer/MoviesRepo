package com.movieapp.abeer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.movieapp.abeer.databinding.ActivityMainBinding;
import com.movieapp.abeer.models.UserModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    private UserModel userModel = new UserModel();
    private ActivityMainBinding binding;
    private OnClickHandler onClickHandler;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        userModel.setUsername("abeer@gmail.com");//john22
        onClickHandler = new OnClickHandler();
        mAuth = FirebaseAuth.getInstance();

        binding.setUserModel(userModel);
        binding.setClickHandler(onClickHandler);

    }

    public class OnClickHandler {
        public void onClickSignin(View view) {
            if (!TextUtils.isEmpty(userModel.getUsername()))
                if (!TextUtils.isEmpty(userModel.getPassword())) {
                    mAuth.signInWithEmailAndPassword(userModel.getUsername(), userModel.getPassword())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                        {
                                            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                                            startActivity(intent);
                                        }
                                    else
                                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

                                }
                            });
                }

        }
    }

}