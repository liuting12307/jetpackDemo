package com.liuting.jetpack.jetpackdemo.ui.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.databinding.ItemTopNewsBinding;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 作者:admin on 2020/10/18 14:42
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.dashboard.adapter
 * TODO:
 */
public class NewsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private List<NewsBean> mList;

    public NewsAdapter(Context context, List<NewsBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //这里的第四个参数必须为 false 这在Google
        ItemTopNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_top_news, parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewsBean bean=mList.get(position);
        ItemTopNewsBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.tvTime.setText(bean.getDate());
        binding.tvAuthor.setText(bean.getAuthor_name());
        binding.tvTitle.setText(bean.getTitle());
        Glide.with(mContext).load(bean.getThumbnail_pic_s()).into(binding.ivThubmail);

    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }
    public void addList(List<NewsBean> list){
        if(list!=null&&!list.isEmpty()){
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }
}
    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
