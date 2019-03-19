package com.renyu.weixinedittext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renyu.weixinedittext.MainActivityJ;
import com.renyu.weixinedittext.R;
import com.renyu.weixinedittext.bean.AbstractBean;
import com.renyu.weixinedittext.bean.NormalBean;
import com.renyu.weixinedittext.bean.TopBean;

import java.util.List;

/**
 * Created by taochen on 19-3-19.
 * Mail：935612713@qq.com
 */

public class MainAdapterJ extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_TOP = 0;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_BOTTOM = 2;

    private Context mContext;
    private List<AbstractBean> mBeanList;
    private int mBottomHeight;

    public MainAdapterJ(Context context, List<AbstractBean> beanList) {
        mContext = context;
        mBeanList = beanList;
    }

    @Override
    public int getItemViewType(int position) {
        if (mBeanList.get(position) instanceof TopBean)
            return TYPE_TOP;
        else if (mBeanList.get(position) instanceof NormalBean)
            return TYPE_NORMAL;
        else
            return TYPE_BOTTOM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_TOP:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_top, parent, false);
                return new TopViewHolder(view);
            case TYPE_NORMAL:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_normal, parent, false);
                return new NormalViewHolder(view);
            case TYPE_BOTTOM:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_bottom, parent, false);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = mBottomHeight;
                return new BottomHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_NORMAL:
                ((NormalViewHolder) holder).tv_msg.setText(((NormalBean) mBeanList.get(position)).getMsg());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    public List<AbstractBean> getBeanList() {
        return mBeanList;
    }

    public void setBottomHeight(int bottomHeight) {
        mBottomHeight = bottomHeight;
    }

    private static class TopViewHolder extends RecyclerView.ViewHolder {

        public TopViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {

        TextView tv_msg;

        public NormalViewHolder(final View itemView) {
            super(itemView);
            tv_msg = itemView.findViewById(R.id.tv_title);
            itemView.findViewById(R.id.tv_comment).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这里将整个 itemView 传递过去，position 没用到，留着没什么影响 :)
                    ((MainActivityJ) mContext).showInputDialog(itemView, getAdapterPosition());
                }
            });
        }
    }

    private class BottomHolder extends RecyclerView.ViewHolder {

        public BottomHolder(final View itemView) {
            super(itemView);
        }
    }
}
