package com.tolet.sajib.retrofitgetparttwo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tolet.sajib.retrofitgetparttwo.R;
import com.tolet.sajib.retrofitgetparttwo.modelclass.ModelTwo;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> implements Filterable {
    private ArrayList<ModelTwo> listitem;
    Context context;
    private ArrayList<ModelTwo> mFilteredList;
    private static final int EMPTY_VIEW = 10;

    public AdapterClass(ArrayList<ModelTwo> listitem, Context context) {
        this.listitem = listitem;
        this.mFilteredList = new ArrayList<>(listitem);
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        //holder.textViewHead.setText(listItem.get(position).getKitchenName());
        if(holder instanceof ViewHolder){
            ViewHolder viewHolder= (ViewHolder) holder;
            String pi = String.valueOf(mFilteredList.get(position));
        }
//        ModelTwo listItem = mFilteredList.get(position);
//
//        holder.foofname.setText(listitem.get(position).getKitchenName());
//        holder.category.setText(listitem.get(position).getCuisine());
//        holder.rating.setText(String.format("%.2f", listitem.get(position).getRating()));
        if(holder instanceof ViewHolder){
            ViewHolder viewHolder= (ViewHolder) holder;
            String pi = String.valueOf(mFilteredList.get(position));
        }
        ModelTwo listItem = mFilteredList.get(position);

        holder.foofname.setText(listItem.getKitchenName());
        holder.category.setText(listItem.getCuisine());
        holder.rating.setText(String.format("%.2f",listItem.getRating()));
        String mImage = "http://www.fnstatic.co.uk/images/content/recipe/quiz-can-you-guess-which-fast-food-item-has-more-calories-.jpeg";
        if (!listitem.get(position).getKitchenImage().isEmpty()) {
            mImage = listitem.get(position).getKitchenImage();
        }
        Glide.with(context)
                .load(mImage)
                .centerCrop()
                .placeholder(R.drawable.logo)
                .crossFade()
                .into(holder.imageView1);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }




    @Override
    public Filter getFilter() {
     return new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {

             String charString = constraint.toString();

             if (charString.isEmpty()) {

                 mFilteredList = listitem;
             } else {

                 ArrayList<ModelTwo> filteredList = new ArrayList<>();

                 for (ModelTwo kitchen : listitem) {

                     if (kitchen.getAreaName().toLowerCase().contains(charString) || kitchen.getDetAddress().toLowerCase().contains(charString)
                             || kitchen.getCuisine().toLowerCase().contains(charString)|| kitchen.getKitchenName().toLowerCase().contains(charString)
                             || String.valueOf(kitchen.getKitchenId()).toLowerCase().contains(charString)) {

                         filteredList.add(kitchen);
                     }
                 }
                 mFilteredList.clear();
                 mFilteredList.addAll(filteredList);
                 mFilteredList = filteredList;
             }

             FilterResults filterResults = new FilterResults();
             filterResults.values = mFilteredList;
             filterResults.count = mFilteredList.size();
             return filterResults;
         }

         @Override
         protected void publishResults(CharSequence constraint, FilterResults results) {
             mFilteredList = (ArrayList<ModelTwo>) results.values;
             notifyDataSetChanged();
         }
     };
    }
    @Override
    public int getItemViewType(int position) {
        if(mFilteredList.size()==0){
            return EMPTY_VIEW;
        }
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView foofname, rating, category;
         ImageView imageView1;

        public ViewHolder(View itemView) {
            super(itemView);
            foofname = itemView.findViewById(R.id.textFoodName);
            rating = itemView.findViewById(R.id.textFoodRating);
            imageView1 = itemView.findViewById(R.id.imageView);
            category = itemView.findViewById(R.id.textFoodCat);
        }
    }
}
