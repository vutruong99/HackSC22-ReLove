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

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.StoreViewHolder> {
    private ArrayList<Owner> storeAdapterArrayList;
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
        Owner currentItem = storeAdapterArrayList.get(position);
        Picasso.get().load(currentItem.getImage()).into(holder.circleImageView);
        holder.type_name.setText(currentItem.getOwner_name());
        holder.count.setText((String.valueOf(currentItem.getNum_orders())));
    }

    public OwnerAdapter(ArrayList<Owner> storeItemsList) {
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
