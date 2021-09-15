package com.unae.phonie.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unae.phonie.data.model.Contact;
import com.unae.phonie.data.room.database.MyDatabase;
import com.unae.phonie.databinding.ItemContactBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> itemList = Collections.emptyList();

    ContactAdapter(){
//        itemList.add(new Contact("윤혜원", "010-6218-1172"));
//        itemList.add(new Contact("곽용우", "010-3744-0834"));
    }

    public void init(List<Contact> list) {
        itemList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactViewHolder viewHolder = new ContactViewHolder(
                ItemContactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
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