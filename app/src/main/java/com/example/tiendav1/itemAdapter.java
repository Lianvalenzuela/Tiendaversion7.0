package com.example.tiendav1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHolder> {
    private List<item> ItemList;
    private Context context;
    public itemAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<item> itemList){
        this.ItemList = itemList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        item Item = ItemList.get(position);
        holder.imageView.setImageResource(Item.getImage());
        holder.textView.setText(Item.getTittle());
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.image_list);
            textView = itemView.findViewById(R.id.tittle);
        }
    }
}
