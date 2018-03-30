package com.marx.amit.gamerground.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marx.amit.gamerground.R;
import com.marx.amit.gamerground.model.ConsoleSell;
import com.marx.amit.gamerground.model.GameSell;

import java.util.ArrayList;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSellAdapter extends RecyclerView.Adapter<ConsoleSellAdapter.ViewHolder>{
    private final ArrayList<ConsoleSell> consoleSells;
    private final OnListFragmentInteractionListener mListener;
    private Context context;
    private ConsoleSell consoleSell;

    private static DatabaseReference mDatabase;
    private static DatabaseReference consoleSellRef;



    public ConsoleSellAdapter(ArrayList<ConsoleSell> consoleSells) {
        this.consoleSells = consoleSells;
    }

    public ConsoleSellAdapter(OnListFragmentInteractionListener listener, Context context) {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.consoleSellRef = mDatabase.getDatabase().getReference("consoleSell");
        this.consoleSells = new ArrayList<>();
        getAllConsoleSells();
        this.mListener = listener;
        this.context = context;
    }



    public void getAllConsoleSells() {

        consoleSellRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                GameSell gameSell = dataSnapshot.getValue(GameSell.class);
                consoleSells.add(consoleSell);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                final ConsoleSell consoleSell = dataSnapshot.getValue(ConsoleSell.class);
                try {
                    //int position = 0;
                    for (int i = 0; i < consoleSells.size(); i++) {
                        String crntIdTime = consoleSells.get(i).getId() + consoleSells.get(i).getTimeStamp();
                        assert consoleSell != null;
                        String consoleIdTime = consoleSell.getId() + consoleSell.getTimeStamp();
                        if (consoleIdTime.equals(crntIdTime)) {
                            consoleSells.remove(i);
                            consoleSells.add(i, consoleSell);
                            break;
                        }
                    }
                    notifyDataSetChanged();
                } catch (Exception e) {
                    //
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




    @Override
    public ConsoleSellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gamesell_item, parent, false);
        return new ConsoleSellAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConsoleSellAdapter.ViewHolder holder, int position) {



        holder.consoleSell = consoleSells.get(position);
        this.consoleSell = consoleSells.get(position);
        Picasso.with(context).load(holder.consoleSell.getPlatform().getCover()).into(holder.ivGi);
        holder.tvGiName.setText(holder.consoleSell.getPlatform().getName());
        holder.tvGiPrice.setText(holder.consoleSell.getPrice());


        holder.btnGiContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: contact
            }
        });

        holder.btnGiFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: favorite
            }
        });





    }

    @Override
    public int getItemCount() {
        return consoleSells.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        final ImageView ivGi;
        final TextView tvGiName, tvGiPrice;
        Button btnGiContact, btnGiFavorite;
        ConsoleSell consoleSell;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivGi = view.findViewById(R.id.ivGi);
            tvGiName = view.findViewById(R.id.tvGiName);
            tvGiPrice = view.findViewById(R.id.tvGiPrice);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvGiName.getText() + "," + tvGiPrice + "'";
        }
    }
}
