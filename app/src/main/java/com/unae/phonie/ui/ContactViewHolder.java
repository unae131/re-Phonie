package com.unae.phonie.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.unae.phonie.data.model.Contact;
import com.unae.phonie.databinding.ItemContactBinding;

class ContactViewHolder extends RecyclerView.ViewHolder {
    private ItemContactBinding binding;

    ContactViewHolder(ItemContactBinding itemContactBinding) {
        super(itemContactBinding.getRoot());
        binding = itemContactBinding;
    }

    public void onBind(Contact contact) {
        Context context = binding.getRoot().getContext();

        binding.setContact(contact);
        binding.constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.constraintHidden.getVisibility() == View.GONE) {
                    binding.constraintHidden.setVisibility(View.VISIBLE);
                } else {
                    binding.constraintHidden.setVisibility(View.GONE);
                }

            }
        });
        binding.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhoneNum()));
                context.startActivity(intent);

            }
        });
        binding.ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + contact.getPhoneNum()));
                context.startActivity(intent);

            }
        });
        binding.ivVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.android.server.telecom");
                intent.putExtra("videocall", true);
                intent.setData(Uri.parse("tel:" + contact.getPhoneNum()));
                context.startActivity(intent);

            }
        });
        binding.ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra("name", contact.getName());
                intent.putExtra("phoneNum", contact.getPhoneNum());
                context.startActivity(intent);

            }
        });
    }
}
