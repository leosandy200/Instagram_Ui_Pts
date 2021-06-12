package com.example.instagram_ui_pts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

    private List<RecyclerModel> dataList;
    private OnItemClickListener mListener;
    int posku;
    View viewku;

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

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        //        Mendefinisikan variabel dari recyler_list.xml
        private TextView tv_name, tv_desc;
        private ImageView img_list;
        private CardView cardView;

        public ListViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            viewku = itemView;
            tv_name = itemView.findViewById(R.id.tv_name_list);
            tv_desc = itemView.findViewById(R.id.tv_desc_list);
            img_list = itemView.findViewById(R.id.img_list);
            cardView = itemView.findViewById(R.id.id_cardview);

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

//            Nge-set context menu bakal muncul kalo nge-klik relativeLayout
            relativeLayout.setOnCreateContextMenuListener(this);
        }

//        Ngebikin item di context menunya
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku = getAdapterPosition();
            Edit.setOnMenuItemClickListener(onlickcontextmenu);
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }

//        Ngedefinisiin apa yg bakal terjadi kalo item context menunya di-klik
        private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case 1:
                        //Do stuff
                        Toast.makeText(viewku.getContext(), "Edit data di posisi " + posku, Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        //Delete data, butuh konfirmasi dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                        builder.setMessage("Are you sure you want to delete data?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dataList.remove(posku);
                                        notifyDataSetChanged();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                                //Set your icon here
                                .setTitle("Delete data")
                                .setIcon(R.mipmap.ic_launcher);
                        AlertDialog alert = builder.create();
                        alert.show();//showing the dialog

                        break;
                }
                return true;
            }
        };
    }
}
