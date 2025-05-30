package com.anhtlnse170476.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> listFruits;

    public FruitAdapter(Context context, int layout, List<Fruit> listFruits) {
        this.context = context;
        this.layout = layout;
        this.listFruits = listFruits;
    }

    @Override
    public int getCount() {
        return listFruits == null ? 0 : listFruits.size();
    }

    @Override
    public Object getItem(int position) {
        return listFruits == null ? new Fruit() : listFruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout, null);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);
        ImageView ivImage = convertView.findViewById(R.id.ivImage);

        Fruit fruit = listFruits.get(position);
        tvTitle.setText(fruit.getTitle());
        tvDescription.setText(fruit.getDescription());

        Picasso.get()
                .load(fruit.getImageUrl())
                .error(R.drawable.ic_launcher_foreground)
                .into(ivImage);

        return convertView;
    }
}
