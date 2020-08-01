package com.movieapp.abeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.movieapp.abeer.databinding.ActivityMainBinding;
import com.movieapp.abeer.models.UserModel;

public class MainActivity extends AppCompatActivity {
    private UserModel userModel = new UserModel();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        userModel.setUsername("john22@gmail.com");
        binding.setUserModel(userModel);
    }

    public class OnClickHandler {
        public void onClickSignin(View view) {
            Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
        }
    }

}