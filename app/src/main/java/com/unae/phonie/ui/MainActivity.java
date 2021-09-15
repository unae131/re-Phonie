package com.unae.phonie.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unae.phonie.R;
import com.unae.phonie.data.model.Contact;
import com.unae.phonie.data.room.database.MyDatabase;
import com.unae.phonie.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel vm;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyDatabase.setInstance(this);

        vm = new ViewModelProvider(this).get(MainViewModel.class);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1001);
        }

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.recyclerview.setAdapter(new ContactAdapter());
        binding.mainFabAdd.setOnClickListener(v ->
                vm.insert(new Contact("" + System.currentTimeMillis(), "0100000000"))
        );

        vm.getAll().observe(this, contacts -> adapter.init(contacts));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }
                else{
                    Toast.makeText(this, "권한 허용이 필요합니다.", Toast.LENGTH_SHORT).show();
                }
        }
    }
}