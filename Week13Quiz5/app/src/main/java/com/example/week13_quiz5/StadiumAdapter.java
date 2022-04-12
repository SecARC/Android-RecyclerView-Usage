package com.example.week13_quiz5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder>{
    private final Context context;
    private final ArrayList<StadiumData> StadiumDataArrayList;

    public StadiumAdapter(ArrayList<StadiumData> StadiumDataArrayList, Context mContext) {
        this.context = mContext;
        this.StadiumDataArrayList = StadiumDataArrayList;
    }

    @NonNull
    @Override
    public StadiumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_stadium, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StadiumAdapter.ViewHolder holder, int position) {
        StadiumData stadium = StadiumDataArrayList.get(position);
        holder.tvName.setText(stadium.getName());
        holder.tvLocation.setText(stadium.getLocation());
        holder.tvCapacity.setText(stadium.getCapacity());
        Glide.with(context)
                .load(stadium.getPicture_url())
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (StadiumDataArrayList == null) ? 0 : StadiumDataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvName, tvLocation, tvCapacity;
        private final ImageView imageView;
        private final ImageButton likeButton;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);
            tvCapacity = (TextView) itemView.findViewById(R.id.tvCapacity);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            likeButton = (ImageButton) itemView.findViewById(R.id.likeButton);

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText( view.getContext(), "You liked " + tvName.getText() + ".Hope to see you there.", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
