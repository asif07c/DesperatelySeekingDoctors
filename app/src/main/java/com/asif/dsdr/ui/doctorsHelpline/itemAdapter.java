package com.asif.dsdr.ui.doctorsHelpline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;

/**
 * Created by Asif on 17-Apr-20
 */
public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> {
    private ArrayList<itemResource> mitemResource;
    private MyClickListener mlistener;

    itemAdapter(ArrayList<itemResource> itemResources) {
        mitemResource = itemResources;
    }

    void setOnItemClickListener(MyClickListener listener) {
        mlistener = listener;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_doctor, viewGroup, false);
        return new itemViewHolder(view, mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder viewHolder, int i) {
        itemResource itemResource = mitemResource.get(i);

        viewHolder.textView1.setText(itemResource.getText1());
        viewHolder.textView2.setText(itemResource.getText2());
    }

    @Override
    public int getItemCount() {
        return mitemResource.size();
    }

    public interface MyClickListener {
        void onPhoneCall(int p);

        void onWhatsapp(int p);
    }

    static class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView2;
        ImageView imageView3;
        TextView textView1;
        TextView textView2;


        MyClickListener listener;

        itemViewHolder(@NonNull View itemView, MyClickListener listener) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.imageView2);
            imageView3 = itemView.findViewById(R.id.imageView_wp);
            textView1 = itemView.findViewById(R.id.d_name);
            textView2 = itemView.findViewById(R.id.d_no);

            //i = itemView.findViewById(R.id.imageView2);
            imageView2.setOnClickListener(this);
            imageView3.setOnClickListener(this);

            this.listener = listener;


        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.imageView2) {
                listener.onWhatsapp(this.getLayoutPosition());
            }
            if (v.getId() == R.id.imageView_wp) {
                listener.onPhoneCall(this.getLayoutPosition());
            }
        }
    }


}
