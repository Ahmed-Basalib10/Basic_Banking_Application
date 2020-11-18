package com.bankingappsparks.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bankingappsparks.Activities.TransferActivity;
import com.bankingappsparks.Activities.UserDetailsActivity;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;
import com.bankingappsparks.model.Transactions;

import java.util.List;

public class UsersAdapter2 extends RecyclerView.Adapter<UsersAdapter2.MyViewHolder> {
    private final Context context;
    private final List<Transactions> accountsList;

    public UsersAdapter2(Context context, List<Transactions> accountsList)
    {
        this.context = context;
        this.accountsList=accountsList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trans_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_txt.setText(accountsList.get(position).getTime()+"      "+accountsList.get(position).getDate());
        holder.email_txt.setText("From  "+accountsList.get(position).getSender_acc()+"  to  "+accountsList.get(position).getRec_acc());
        holder.balance_txt.setText(accountsList.get(position).getStstus());


    }


    @Override
    public int getItemCount() {
        return accountsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id_txt, name_txt, email_txt, balance_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt=itemView.findViewById(R.id.name_txt);
            email_txt=itemView.findViewById(R.id.email_txt);
            balance_txt=itemView.findViewById(R.id.balance_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

        }
    }
}
