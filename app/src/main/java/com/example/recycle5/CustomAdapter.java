package com.example.recycle5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW=0;
    private static final int TYPE_ITEM_LIST=0;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position) {
        if (members.get(position).getMemberSubs()!=null) return TYPE_ITEM_LIST;
        return TYPE_ITEM_VIEW;
    }

    @Override
    public int getItemCount(){return members.size();}

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int viewType){
        if (viewType==TYPE_ITEM_LIST){
            View footer= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_list,viewGroup,false);
            return new CustomListHolder(footer);
        }

        View header= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view,viewGroup,false);
        return new CustomViewHolder(header);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member=members.get(position);

        if (holder instanceof CustomViewHolder){
//        ((CustomViewHolder) holder).name.setText(member.getFirstName());
//        ((CustomViewHolder) holder).last_name.setText(member.getLastName());
        }
        if (holder instanceof CustomListHolder){
            RecyclerView recyclerView=((CustomListHolder)holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

            List<MemberSub> memberSubs=member.getMemberSubs();
            refreshSubAdapter(recyclerView,memberSubs);
        }

    }
    private void refreshSubAdapter(RecyclerView recyclerView,List<MemberSub> memberSubs){
     CustomSubAdapter adapter=new CustomSubAdapter(context,memberSubs);
     recyclerView.setAdapter(adapter);
    }



}


