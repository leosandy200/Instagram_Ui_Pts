package com.example.instagram_ui_pts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

    private List<RecyclerModel> dataList;
    private OnItemClickListener mListener;
    private Context mContext;

    //    Bikin interface OnItemClick biar nanti Adapternya bisa dipake di Activity sebagai method onClick
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecyclerAdapter(Context mContext, List<RecyclerModel> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_list, parent, false);
        return new ListViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
//        Menerapkan data dari arrayList ke tv_name, tv_desc, dan img_list
        holder.tv_name.setText(dataList.get(position).getName());
        holder.tv_desc.setText(dataList.get(position).getDesc());

//        Load data ke img_list menggunakan Picasso
        Picasso.get().load(dataList.get(position).getImage()).fit().into(holder.img_list);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
//        Mendefinisikan variabel dari recyler_list.xml
        private TextView tv_name, tv_desc;
        private ImageView img_list;

        public ListViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name_list);
            tv_desc = itemView.findViewById(R.id.tv_desc_list);
            img_list = itemView.findViewById(R.id.img_list);
            RelativeLayout relativeLayout = itemView.findViewById(R.id.relative_recycler);

//            Mendefinisikan method onClick apabila relativeLayout diklik
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
