package com.unae.phonie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.unae.phonie.R;
import com.unae.phonie.data.model.Contact;
import com.unae.phonie.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;
    private ContactViewModel vm;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        vm = new ViewModelProvider(this).get(ContactViewModel.class);
        adapter = new ContactAdapter(vm);

        binding.searchRcv.setAdapter(adapter);
        binding.searchRcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                ArrayList<Contact> searched = new ArrayList<>();
                searched.addAll(vm.getByName(text));
                searched.addAll(vm.getByNumber(text));
                adapter.init(searched);

//                Log.d("Hogisim", s + " " + start + " " + before + " " + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}