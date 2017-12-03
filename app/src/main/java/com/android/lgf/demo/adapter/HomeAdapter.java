package com.android.lgf.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lgf.demo.R;

import java.util.List;

/**
 * Created by lgf on 17-12-3.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    private List<String> nameList;
    private OnItemClickListener onItemClickListener;
    public HomeAdapter(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (nameList != null && nameList.size() > 0) {
            HomeViewHolder viewHolder = (HomeViewHolder) holder;
            String name = nameList.get(position);
            if (!TextUtils.isEmpty(name)) {
                viewHolder.tvName.setText(name);
            }

            if (onItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, position);
                    }
                });
                viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemClickListener.onItemLongClick(v, position);
                        return true;
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (nameList != null) {
            return nameList.size();
        }

        return 0;
    }

    public void remove(int position) {
        if (nameList != null) {
            if (position > nameList.size()) {
                throw new IllegalArgumentException("position is out of index");
            }

            nameList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void setOnItemClick(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    private static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public HomeViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

}
