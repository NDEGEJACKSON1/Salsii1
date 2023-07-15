package com.stress.salsii1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements Adapter.OnItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    Activity context;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Model>userlist;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView); // Find the RecyclerView by ID


        initData();
        initRecyclerView();

        return view;
    }

    private void initData() {

        userlist = new ArrayList<>();
        userlist.add(new Model(R.drawable.salsiilogo, "Salsii.com", "22:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "lighters-studio.com", "12:30Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "lighters.com", "22:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "ipush.com", "22:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "medcognit.com", "22:54Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "heartms.com", "23:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "iCardiosys.com", "00:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "Sartify.com", "02:53Pm", "Automated stress detection using natural language processing and machine learning"));
        userlist.add(new Model(R.drawable.salsiilogo, "Caf.com", "12:53Pm", "Automated stress detection using natural language processing and machine learning"));
    }

    private void initRecyclerView() {
        recyclerView.findViewById(R.id.recyclerView);
        Context context = requireContext();
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userlist);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this); // Set the item click listener
        adapter.notifyDataSetChanged();
    }

//    create on start function for tell me button
    public void onStart(){
        super.onStart();
        Button btn = (Button) context.findViewById(R.id.tellMe);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, recommandation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(Model model) {
        // Handle item click event here
        String name = model.getMessageView();

        // Update the desired layout or TextView with the message
        // For example, if you have a TextView with id 'messageTextView' in your fragment layout
        TextView messageTextView = requireView().findViewById(R.id.predict);
        messageTextView.setText(name);
    }
}