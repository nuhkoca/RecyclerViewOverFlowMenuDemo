package com.nuhkoca.android.recyclerviewoverflowmenudemo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.nuhkoca.android.recyclerviewoverflowmenudemo.R;
import com.nuhkoca.android.recyclerviewoverflowmenudemo.model.SimpleDataModel;

import java.util.List;

/**
 * Created by nuhkoca on 28.11.2017.
 */

public class SimpleDataAdapter extends RecyclerView.Adapter<SimpleDataAdapter.ViewHolder> {

    private List<SimpleDataModel> mSimpleDataModel;
    private final Context mContext;

    public SimpleDataAdapter(List<SimpleDataModel> mSimpleDataModel, Context mContext) {
        this.mSimpleDataModel = mSimpleDataModel;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view_holder, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDataModel simpleDataModel = mSimpleDataModel.get(position);

        holder.bind(simpleDataModel);
        holder.bindImage(simpleDataModel, mContext);
        holder.overFlowMenu();
    }

    @Override
    public int getItemCount() {
        return mSimpleDataModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_item_title, tv_item_date, tv_item_description, tv_item_author;
        private ImageView iv_item_image, iv_overflow;
        private RelativeLayout pb_item_loading;

        ViewHolder(View itemView) {
            super(itemView);

            tv_item_title = itemView.findViewById(R.id.tv_item_title);
            tv_item_date = itemView.findViewById(R.id.tv_item_date);
            tv_item_description = itemView.findViewById(R.id.tv_item_description);
            tv_item_author = itemView.findViewById(R.id.tv_item_author);
            iv_item_image = itemView.findViewById(R.id.iv_item_image);
            iv_overflow = itemView.findViewById(R.id.iv_overflow);
            pb_item_loading = itemView.findViewById(R.id.pb_item_loading);
            iv_overflow = itemView.findViewById(R.id.iv_overflow);
            pb_item_loading = itemView.findViewById(R.id.pb_item_loading);
        }

        void bind(SimpleDataModel simpleDataModels) {
            tv_item_title.setText(simpleDataModels.getTitle());
            tv_item_description.setText(simpleDataModels.getDescription());
            tv_item_author.setText(simpleDataModels.getAuthor());
            tv_item_date.setText(simpleDataModels.getDate());
        }

        void bindImage(SimpleDataModel simpleDataModels, Context context) {
            RequestOptions requestOptions = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .centerCrop();

            Glide.with(context)
                    .load(simpleDataModels.getImageId())
                    .apply(requestOptions)
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                            iv_item_image.setImageDrawable(resource);
                            pb_item_loading.setVisibility(View.GONE);
                        }
                    });

        }

        void overFlowMenu() {
            iv_overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopupMenu(iv_overflow);
                }
            });
        }
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.overflow_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.share_quickly:

                    Toast infoToast = Toast.makeText(mContext, "Clicked Instant Share", Toast.LENGTH_LONG);
                    infoToast.show();

                    return true;
                case R.id.open_in_browser_quickly:
                    infoToast = Toast.makeText(mContext, "Clicked Open in Browser", Toast.LENGTH_LONG);
                    infoToast.show();

                    return true;
                default:
            }
            return false;
        }
    }
}
