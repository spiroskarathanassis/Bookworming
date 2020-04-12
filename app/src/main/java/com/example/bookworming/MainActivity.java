package com.example.bookworming;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.AdminLibraryManagement;
import com.example.bookworming.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.onClickListener() {
            @Override
            public void onClick(View v) {
                openLibraryManagementActivity();
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }


    }

    public void openLibraryManagementActivity() {
        Intent intent = new Intent(this, AdminLibraryManagement.class);
        startActivity(intent);
    }
}
