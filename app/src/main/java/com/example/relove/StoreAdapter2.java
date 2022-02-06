package com.example.relove;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoreAdapter2 extends RecyclerView.Adapter<StoreAdapter2.StoreViewHolder> {
    private ArrayList<StoreItem> storeAdapterArrayList;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_2_item, parent, false);
        return new StoreViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        StoreItem currentItem = storeAdapterArrayList.get(position);
        Picasso.get().load(currentItem.getImageURL()).into(holder.circleImageView);
        holder.type_name.setText(currentItem.getBusiName());
        holder.count.setText((currentItem.getCount()));
    }

    public StoreAdapter2(ArrayList<StoreItem> storeItemsList) {
        storeAdapterArrayList = storeItemsList;

    }
    @Override
    public int getItemCount() {
        return storeAdapterArrayList.size();
    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView circleImageView;
        public TextView type_name;
        public TextView count;
        public StoreViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.profile_image);
            type_name = itemView.findViewById(R.id.busi_name);
            count = itemView.findViewById(R.id.count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
