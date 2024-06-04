package com.example.driverapp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.driverapp.R;
import com.example.driverapp.TaskActivity;
import com.example.driverapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnButtonClickListener{

    Activity context;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<modelclass> itemlist;
    Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        View root =inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = (RecyclerView) root.findViewById(R.id.Recyclerview1);
        initData();
        initRecyclerview();
        return root;
    }

    private void initRecyclerview()
    {
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(itemlist,getActivity(),this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initData() {

        itemlist=new ArrayList<>();
        itemlist.add(new modelclass(102443,"InProgress"));
        itemlist.add(new modelclass(102444,"InProgress"));
        itemlist.add(new modelclass(102445,"Completed"));
        itemlist.add(new modelclass(102446,"Verification"));
        itemlist.add(new modelclass(102447,"InProgress"));
        itemlist.add(new modelclass(102448,"Completed"));
        itemlist.add(new modelclass(102449,"Verification"));
    }
    @Override
    public void onButtonClick(int position) {
        Intent intent = new Intent(getActivity(), TaskActivity.class);
        startActivity(intent);
    }
}