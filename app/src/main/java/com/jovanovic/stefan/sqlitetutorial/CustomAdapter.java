package com.jovanovic.stefan.sqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList Product_id, Product_name, Quantity, Price;

    CustomAdapter(Activity activity, Context context, ArrayList Product_id, ArrayList Product_name, ArrayList Quantity,
                  ArrayList Price){
        this.activity = activity;
        this.context = context;
        this.Product_id = Product_id;
        this.Product_name = Product_name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.Product_id_txt.setText(String.valueOf(Product_id.get(position)));
        holder.Product_name_txt.setText(String.valueOf(Product_name.get(position)));
        holder.Quantity_txt.setText(String.valueOf(Quantity.get(position)));
        holder.Price_txt.setText(String.valueOf(Price.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(Product_id.get(position)));
                intent.putExtra("name", String.valueOf(Product_name.get(position)));
                intent.putExtra("Quantity", String.valueOf(Quantity.get(position)));
                intent.putExtra("Price", String.valueOf(Price.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Product_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Product_id_txt, Product_name_txt, Quantity_txt, Price_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Product_id_txt = itemView.findViewById(R.id.book_id_txt);
            Product_name_txt = itemView.findViewById(R.id.book_title_txt);
            Quantity_txt = itemView.findViewById(R.id.book_author_txt);
            Price_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
