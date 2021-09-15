package com.unae.phonie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.unae.phonie.R;
import com.unae.phonie.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);

    }
}