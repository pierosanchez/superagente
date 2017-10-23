package com.example.ctorres.superagentemovil3.dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ctorres.superagentemovil3.R;
import com.example.ctorres.superagentemovil3.entity.ClubsEntity;
import com.example.ctorres.superagentemovil3.entity.EmpresasServiciosEntity;

import java.util.ArrayList;

/**
 * Created by CTORRES on 18/05/2017.
 */

public class ClubesAdapter extends BaseAdapter {

    ArrayList<ClubsEntity> items;
    Context context;
    LayoutInflater layoutInflater = null;

    public ClubesAdapter(ArrayList<ClubsEntity> items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(items == null){
            return 0;
        }else {
            return items.size();
        }
    }

    @Override
    public ClubsEntity getItem(int position) {
        if(items == null){
            return null;
        }else{
            return items.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= new ViewHolder();
        View view = layoutInflater.inflate(R.layout.row_clubes,null);

        viewHolder.tv_clubes = (TextView) view.findViewById(R.id.tv_clubes);

        viewHolder.tv_clubes.setText(String.valueOf(getItem(position).getDes_club()));

        ClubsEntity data = getItem(position);

        if(data!=null){
            viewHolder.tv_clubes.setText(data.getDes_club());
        } else {
            viewHolder.tv_clubes.setText("");
        }

        return view;
    }

    public static final class ViewHolder{
        TextView tv_clubes;
    }

    public void setNewListClubes(ArrayList<ClubsEntity> listBeneficiario){
        items = listBeneficiario;
    }
}
