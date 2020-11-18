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

import com.bankingappsparks.Activities.UserDetailsActivity;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {
    private final Context context;
    private final List<Accounts> accountsList;

    public UsersAdapter(Context context, List<Accounts> accountsList)
    {
        this.context = context;
        this.accountsList=accountsList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     //   Accounts accounts=accountsList.get(position);
        holder.id_txt.setText(String.valueOf(accountsList.get(position).getId1()));
        holder.name_txt.setText(accountsList.get(position).getName());
        holder.email_txt.setText(accountsList.get(position).getEmail());
        holder.balance_txt.setText("Rs "+accountsList.get(position).getBalance()+" /-");

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, UserDetailsActivity.class);
                intent.putExtra("ID",String.valueOf(accountsList.get(position).getId1()));
                intent.putExtra("NAME",accountsList.get(position).getName());
                intent.putExtra("ACNO",accountsList.get(position).getAccount_no());
                intent.putExtra("EMAIL",accountsList.get(position).getEmail());
                intent.putExtra("PHONE",accountsList.get(position).getPhone());
                intent.putExtra("BALANCE",String.valueOf(accountsList.get(position).getBalance()));
                context.startActivity(intent);
            }
        });

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
            id_txt=itemView.findViewById(R.id.id_txt);
            name_txt=itemView.findViewById(R.id.name_txt);
            email_txt=itemView.findViewById(R.id.email_txt);
            balance_txt=itemView.findViewById(R.id.balance_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

        }
    }
}
