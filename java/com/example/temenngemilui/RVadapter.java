package com.example.temenngemilui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RVadapter extends RecyclerView.Adapter<RVadapter.MyViewHolder> {
    String nama[],desc[];
    int image[];
    Context context;

    public RVadapter(Context ct, String nm[],String dc[],int img[]){
        context = ct;
        nama = nm;
        desc = dc;
        image = img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtname.setText(nama[position]);
        holder.txtdesc.setText(desc[position]);
        holder.img.setImageResource(image[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.getAdapterPosition()==0){
                    Intent intent = new Intent(context, UI_Basrengpds.class);
                    context.startActivity(intent);
                }else {
                    Intent intent = new Intent(context, UI_Ususpds.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtname,txtdesc;
        ImageView img;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.name);
            txtdesc = itemView.findViewById(R.id.desc);
            img = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

