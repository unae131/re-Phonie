package com.unae.phonie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.unae.phonie.R;
import com.unae.phonie.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        Context context = binding.getRoot().getContext();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phoneNum = intent.getStringExtra("phoneNum");

        binding.infoTvName.setText(name);
        binding.infoTvPhone.setText(phoneNum);

        binding.infoIvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
                context.startActivity(intent);

            }
        });
        binding.infoIvMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNum));
                context.startActivity(intent);

            }
        });
        binding.infoIvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.android.server.telecom");
                intent.putExtra("videocall", true);
                intent.setData(Uri.parse("tel:" + phoneNum));
                context.startActivity(intent);

            }
        });
    }
}