package com.unae.phonie.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.unae.phonie.R;
import com.unae.phonie.data.model.Contact;
import com.unae.phonie.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {
    private ActivityAddBinding binding;
    private ContactViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);

        Context context = binding.getRoot().getContext();
        vm = new ViewModelProvider(this).get(ContactViewModel.class);

        binding.addEtName.requestFocus();
        binding.addEtCall.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        binding.addTvCancel.setOnClickListener(v -> { finish();});
        binding.addTvSave.setOnClickListener(v -> {
            Contact contact = new Contact(binding.addEtName.getText().toString(), binding.addEtCall.getText().toString().replace("-", ""));
            vm.insert(contact);
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}
