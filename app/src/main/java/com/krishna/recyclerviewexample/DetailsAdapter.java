package com.krishna.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    Context mContext;
    List<DetailsModelCls> mDetailList;

    public DetailsAdapter(Context mContext, List<DetailsModelCls> mDetailList) {
        this.mContext = mContext;
        this.mDetailList = mDetailList;
    }

    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View detailView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_layout, parent, false);
        return new ViewHolder(detailView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position) {
        DetailsModelCls detail = mDetailList.get(position);
        Log.d("gg","name= "+detail.getName());
        holder.name.setText(detail.getName());
        holder.email.setText(detail.getEmail());
        holder.mobile.setText(detail.getMob());
        holder.address.setText(detail.getAddress());
        holder.dob.setText(detail.getDob());
    }

    @Override
    public int getItemCount() {
        return mDetailList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView name;
        TextView email;
        TextView mobile;
        TextView address;
        TextView dob;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nm);
            email=itemView.findViewById(R.id.email);
            mobile=itemView.findViewById(R.id.mob);
            address=itemView.findViewById(R.id.address);
            dob=itemView.findViewById(R.id.dob);
            cv=itemView.findViewById(R.id.cView);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DetailsModelCls details = mDetailList.get(getAdapterPosition());

                    Intent intent = new Intent(mContext,DisplayInfo.class);
//                    intent.putExtra("mName",name.getText().toString().trim());
//                    intent.putExtra("mMobile",mobile.getText().toString().trim());
//                    intent.putExtra("mEmail",email.getText().toString().trim());
//                    intent.putExtra("mAddress",address.getText().toString().trim());
//                    intent.putExtra("mDOB",dob.getText().toString().trim());

                    intent.putExtra("data",details);
                    mContext.startActivity(intent);
                }
            });

        }
    }

}
