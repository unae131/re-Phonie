package com.unae.phonie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.unae.phonie.R;
import com.unae.phonie.data.model.Contact;
import com.unae.phonie.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;
    private ContactViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);

        Context context = binding.getRoot().getContext();
        vm = new ViewModelProvider(this).get(ContactViewModel.class);

        int id = getIntent().getIntExtra("id", -1);

        vm.getById(id).observe(this, newContact -> binding.setContact(newContact));

        binding.infoIvCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + binding.getContact().getPhoneNum()));
            context.startActivity(intent);
        });

        binding.infoIvMail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + binding.getContact().getPhoneNum()));
            context.startActivity(intent);
        });

        binding.infoIvVideo.setOnClickListener(v -> {
            Intent intent = new Intent("com.android.server.telecom");
            intent.putExtra("videocall", true);
            intent.setData(Uri.parse("tel:" + binding.getContact().getPhoneNum()));
            context.startActivity(intent);
        });
    }
}