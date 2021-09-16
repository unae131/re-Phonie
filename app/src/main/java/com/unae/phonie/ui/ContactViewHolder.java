package com.unae.phonie.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.unae.phonie.data.model.Contact;
import com.unae.phonie.databinding.ItemContactBinding;

import kotlinx.coroutines.GlobalScope;

class ContactViewHolder extends RecyclerView.ViewHolder {
    private ItemContactBinding binding;
    private ContactViewModel vm;

    ContactViewHolder(ItemContactBinding itemContactBinding, ContactViewModel vm) {
        super(itemContactBinding.getRoot());
        binding = itemContactBinding;
        this.vm = vm;
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

        binding.constraint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_LONG).show();
                        vm.delete(contact);
                    }
                });

                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }

                });

                builder.show();
                return true;
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
                intent.putExtra("id", contact.getId());
                context.startActivity(intent);

            }
        });
    }
}
