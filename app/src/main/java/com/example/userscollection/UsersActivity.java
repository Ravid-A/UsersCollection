package com.example.userscollection;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userscollection.recycleviewer.UserRecyclerViewAdapter;
import com.example.userscollection.usersDB.UserDao;
import com.example.userscollection.usersDB.UserDatabase;

public class UsersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_users);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.usersList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );

        // Set the adapter for the RecyclerView
        UserDatabase userDatabase = UserDatabase.getInstance(this);
        UserDao userDao = userDatabase.userDao();
        UserRecyclerViewAdapter userRecyclerViewAdapter = new UserRecyclerViewAdapter(userDao.getAll());

        recyclerView.setAdapter(userRecyclerViewAdapter);
    }
}