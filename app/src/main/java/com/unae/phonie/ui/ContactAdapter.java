package com.unae.phonie.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.unae.phonie.data.model.Contact;
import com.unae.phonie.data.room.database.MyDatabase;
import com.unae.phonie.databinding.ItemContactBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> itemList = Collections.emptyList();
    private ContactViewModel vm;

    public ContactAdapter(ContactViewModel vm){
        this.vm = vm;
    }

    public void init(List<Contact> list) {
        itemList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactViewHolder viewHolder = new ContactViewHolder(
                ItemContactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false),
                vm
        );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.onBind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
