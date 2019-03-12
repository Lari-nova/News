package com.hfad.news.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hfad.news.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView text;
    private View view;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        imageView = view.findViewById(R.id.info_image);
        text = view.findViewById(R.id.info_text);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getText() {
        return text;
    }
}
