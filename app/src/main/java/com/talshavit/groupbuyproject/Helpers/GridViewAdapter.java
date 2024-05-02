package com.talshavit.groupbuyproject.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.talshavit.groupbuyproject.R;
import com.talshavit.groupbuyproject.models.CategoriesModel;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<CategoriesModel> {

    public GridViewAdapter(@NonNull Context context, ArrayList<CategoriesModel> categoriesModels) {
        super(context, 0, categoriesModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       HolderView holderView;

       if(convertView == null){
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,false);
       holderView = new HolderView(convertView);
       convertView.setTag(holderView);
       }

       else{
           holderView = (HolderView) convertView.getTag();
       }

       CategoriesModel model = getItem(position);
       holderView.textView.setText(model.getCategoryName());

        return convertView;
    }

    private static class HolderView{
        private final TextView textView;

        public HolderView(View view){
            textView = view.findViewById(R.id.text_item);
        }
    }
}
