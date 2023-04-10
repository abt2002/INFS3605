package com.example.infs3605.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.R;
import com.example.infs3605.model.Link;
import com.example.infs3605.model.Message;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.MyViewHolder>{

    Context context;

    List<Link> linkList;

    public SettingAdapter(Context context, List<Link> linkList) {
        this.linkList = linkList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, null);
        return new SettingAdapter.MyViewHolder(mainItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Link link = linkList.get(position);
        holder.itemTv.setText(link.getName());
        holder.url = link.getUrl();
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTv;

        String url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.itemTv);

            itemTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(url);
                    intent.setData(content_url);
                    context.startActivity(intent);
                }
            });
        }
    }
}
