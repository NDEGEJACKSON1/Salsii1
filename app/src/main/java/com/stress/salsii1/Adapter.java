package com.stress.salsii1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> userlist;
    private OnItemClickListener onItemClickListener; // Item click listener

    public Adapter(List<Model> userlist) {
        this.userlist = userlist;
    }

    // Setter method for item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements com.stress.salsii1.ViewHolder, View.OnClickListener {

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

            // Set click listener for the item view
            itemView.setOnClickListener(this);
        }

        public void setData(int resource, String name, String time, String msg) {
            imageView.setImageResource(resource);
            textView.setText(name);
            timeView.setText(time);
            messageView.setText(msg);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                Model model = userlist.get(position);
                onItemClickListener.onItemClick(model);
            }
        }
    }

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(Model model);
    }
}
