package com.example.driverapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.driverapp.ComplaintActivity;
import com.example.driverapp.R;
import com.example.driverapp.TaskActivity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements OnButtonClickListener{

    private List<modelclass> itemlist;
    Context mContext;
    private OnButtonClickListener mListener;

    public Adapter(List<modelclass>itemlist,Context context,OnButtonClickListener listener)
    {
        this.itemlist=itemlist;
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int complaintno=itemlist.get(position).getComplintno();
        String status=itemlist.get(position).getStatus();
        try {
            holder.setData(complaintno, status);
        }
        catch (Exception e){
            Log.d("Error",e.toString());
        }
    }

    @Override
    public int getItemCount()
    {
        return itemlist.size();
    }

    @Override
    public void onButtonClick(int position)
    {
        Intent intent = new Intent(mContext, TaskActivity.class);
        mContext.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView complaint_no,status_c;
        private Button strtbtn;
        View rootview;

        public ViewHolder(@NonNull View itemview)
        {
            super(itemview);
            complaint_no=itemview.findViewById(R.id.c_noo);
            status_c=itemview.findViewById(R.id.displaybtn);
            strtbtn=itemview.findViewById(R.id.displaybtn);

            strtbtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    mListener.onButtonClick(getAdapterPosition());
                }
            });
        }

        public void setData(int resource, String status)
        {
            complaint_no.setText(resource);
            status_c.setText(status);
        }
    }

}
