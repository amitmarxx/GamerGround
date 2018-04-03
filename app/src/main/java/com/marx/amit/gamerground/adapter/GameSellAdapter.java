package com.marx.amit.gamerground.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marx.amit.gamerground.R;
import com.marx.amit.gamerground.model.GameSell;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class GameSellAdapter extends RecyclerView.Adapter<GameSellAdapter.ViewHolder> {

    private final ArrayList<GameSell> gameSells;
    //private final OnListFragmentInteractionListener mListener;
    private Context context;
    private GameSell gameSell;

    private static DatabaseReference mDatabase;
    private static DatabaseReference gameSellRef;


    public GameSellAdapter(ArrayList<GameSell> gameSells) {
        this.gameSells = gameSells;
    }

    public GameSellAdapter(/*OnListFragmentInteractionListener listener,*/ Context context) {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.gameSellRef = mDatabase.getDatabase().getReference("gameSell");
        this.gameSells = new ArrayList<>();
        getAllGameSells();
        //this.mListener = listener;
        this.context = context;
    }


    public void getAllGameSells() {

        gameSellRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                GameSell gameSell = dataSnapshot.getValue(GameSell.class);
                gameSells.add(gameSell);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                final GameSell gameSell = dataSnapshot.getValue(GameSell.class);
                try {
                    //int position = 0;
                    for (int i = 0; i < gameSells.size(); i++) {
                        //String crntId = gameSells.get(i).getId() + gameSells.get(i).getTimeStamp();
                        String crntId = gameSells.get(i).getSellId();
                        assert gameSell != null;
                        String gameIdTime = gameSell.getSellId();
                        if (gameIdTime.equals(crntId)) {
                            gameSells.remove(i);
                            gameSells.add(i, gameSell);
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
    public GameSellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gamesell_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameSellAdapter.ViewHolder holder, int position) {

        holder.gameSell = gameSells.get(position);
        this.gameSell = gameSells.get(position);
        Picasso.get().load(holder.gameSell.getGame().getCover().getUrl()).into(holder.ivGi);
        holder.tvGiName.setText(holder.gameSell.getGame().getName());
        holder.tvGiPrice.setText(holder.gameSell.getPrice());


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
        return gameSells.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        final ImageView ivGi;
        final TextView tvGiName, tvGiPrice;
        Button btnGiContact, btnGiFavorite;
        GameSell gameSell;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivGi = view.findViewById(R.id.ivGi);
            tvGiName = view.findViewById(R.id.tvGiName);
            tvGiPrice = view.findViewById(R.id.tvGiPrice);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", ivGi=" + ivGi +
                    ", tvGiName=" + tvGiName +
                    ", tvGiPrice=" + tvGiPrice +
                    ", btnGiContact=" + btnGiContact +
                    ", btnGiFavorite=" + btnGiFavorite +
                    ", gameSell=" + gameSell +
                    ", itemView=" + itemView +
                    '}';
        }
    }
}
