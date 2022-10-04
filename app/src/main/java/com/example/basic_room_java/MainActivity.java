package com.example.basic_room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basic_room_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new bgThread().start();
                Toast.makeText(MainActivity.this, "Data Saved!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    class bgThread extends Thread {

        public void run() {
            super.run();

            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_db").build();

            UserDao userDao = db.userDao();
            String firstName = binding.et1.getText().toString();
            String lastName = binding.et2.getText().toString();


            userDao.insertRecord(new User(1, firstName, lastName));

            binding.et1.setText("");
            binding.et2.setText("");

        }

    }

}