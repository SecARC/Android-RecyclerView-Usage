package com.example.week13_lab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private ListElement[] mDataset;
    private final String TAG = "PersonAdapter";

    public PersonAdapter(Context context, ListElement[] mDataset) {
        this.context = context;
        this.mDataset = mDataset;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void bind(ListElement data){
            textView.setText(data.getTitle());
        }
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvEmail;
        ImageView imageView;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public void bind(ListElement data, Context context){
            tvName.setText(data.getFullName());
            tvEmail.setText(data.getEmail());
            Glide.with(context)
                    .load(data.getPicture_url())
                    .centerCrop()
                    .into(imageView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        Log.d(TAG, "onCreateViewHolder: " + viewType);

        switch (viewType) {
            case 0: //header
                View list_header = layoutInflater.inflate(R.layout.list_header, parent, false);
                RecyclerView.ViewHolder headerViewHolder = new HeaderViewHolder(list_header);
                return headerViewHolder;
            case 1: //person
                View list_person = layoutInflater.inflate(R.layout.list_person, parent, false);
                RecyclerView.ViewHolder personViewHolder = new PersonViewHolder(list_person);
                return personViewHolder;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (mDataset[position].getElement_type().getValue()){
            case 0:
                ((HeaderViewHolder) holder).bind(mDataset[position]);
                break;
            case 1:
                ((PersonViewHolder) holder).bind(mDataset[position], context);
                break;
            default:
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataset[position].getElement_type().getValue();
    }
}
