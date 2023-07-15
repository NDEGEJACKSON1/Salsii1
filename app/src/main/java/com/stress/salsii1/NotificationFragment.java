package com.stress.salsii1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
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
    List<Model> userlist;
    Adapter adapter;

//    private RequestQueue requestQueue;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_notification, container, false);
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = view.findViewById(R.id.recyclerView); // Find the RecyclerView by ID

        // API testing to display the recent posted by user
        // Create the RequestQueue
//        requestQueue = Volley.newRequestQueue(requireContext());

        // Make the API request
//        makeApiRequest();
    initData();
    initRecyclerView();

        return view;
}

//    private void makeApiRequest() {
//        TextView tv = (TextView) context.findViewById(R.id.hello);
//        String url = "https://jsonplaceholder.typicode.com/todos/1"; // Replace with your API endpoint
//
//        // Create a JsonObjectRequest with your API URL
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // Handle the API response
//                        // Parse the JSON response and update your data accordingly
//                       tv.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Handle API error
//                // Display an error message or handle the error case
//                tv.setText("Error");
//            }
//        });
//
//        // Add the request to the RequestQueue
//        requestQueue.add(request);
//    }

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
        adapter.notifyDataSetChanged();
    }
}