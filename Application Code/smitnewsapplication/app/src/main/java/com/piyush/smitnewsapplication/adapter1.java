package com.piyush.smitnewsapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.piyush.smitnewsapplication.R;
import com.piyush.smitnewsapplication.users;

import java.util.List;

public class adapter1 extends RecyclerView.Adapter<adapter1.githolder> {






    private Context context;
    private users[] data;
    private githolder holder;
    private int position;




    public adapter1(Context context, users[] data)
    {
        this.data= data;
        this.context = context;
    }



    @NonNull
    @Override
    public adapter1.githolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.newslayout,parent,false);

        return new githolder(v);
    }




    @Override
    public void onBindViewHolder(@NonNull final adapter1.githolder holder, int position) {
        this.holder = holder;
        this.position = position;

        final users user = data[position];
        holder.nameofusers.setText(user.getLogin());
        Glide.with(holder.imgofusers.getContext()).load(user.getAvatarUrl()).into(holder.imgofusers);
      //  Glide.with(holder.smallimageofuser.getContext()).load(user.getAvatarUrl()).into(holder.smallimageofuser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = "OPENING PROFILE...";
                Toast.makeText(context,value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,newsprofile.class);
                intent.putExtra("Image",user.getAvatarUrl());
                intent.putExtra("username11",user.getLogin());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class githolder extends RecyclerView.ViewHolder {

        public ImageView smallimageofuser;
        private ImageView imgofusers;
        private TextView nameofusers;

        public githolder(@NonNull View itemView) {
            super(itemView);

            imgofusers = itemView.findViewById(R.id.imgofuser);
          //  smallimageofuser = itemView.findViewById(R.id.smallimageofuser);
            nameofusers = itemView.findViewById(R.id.nameofusers);

        }
    }


}
