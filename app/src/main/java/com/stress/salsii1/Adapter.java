package com.stress.salsii1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> userlist;

    public Adapter(List<Model> userlist) {
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource = userlist.get(position).getImageView1();
        String name = userlist.get(position).getTextView();
        String time = userlist.get(position).getTimeView();
        String msg = userlist.get(position).getMessageView();

        holder.setData(resource, name, time, msg);

    }


    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView timeView;
        private TextView messageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            textView = itemView.findViewById(R.id.textView);
            timeView = itemView.findViewById(R.id.timeView);
            messageView = itemView.findViewById(R.id.messageView);
        }

        public void setData(int resource, String name, String time, String msg) {
            imageView.setImageResource(resource);
            textView.setText(name);
            timeView.setText(time);
            messageView.setText(msg);
        }
    }
}
