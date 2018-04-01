//package com.marx.amit.gamerground.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AutoCompleteTextView;
//import android.widget.BaseAdapter;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.TextView;
//
//import com.android.volley.VolleyError;
//import com.igdb.api_android_java.callback.onSuccessCallback;
//import com.igdb.api_android_java.model.APIWrapper;
//import com.igdb.api_android_java.model.Parameters;
//import com.marx.amit.gamerground.R;
//import com.marx.amit.gamerground.model.Game;
//
//import org.json.JSONArray;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by amit on 3/31/18.
// */
//
//public class GameAutoCompleteAdapter extends BaseAdapter implements Filterable {
//
//    private static final int MAX_RESULTS = 10;
//    private Context mContext;
//    private List<Game> resultList = new ArrayList<Game>();
//    private Game game = new Game();
//
//    private AutoCompleteTextView search;
//
//
//    public GameAutoCompleteAdapter(Context context) {
//        mContext = context;
//    }
//
//    @Override
//    public int getCount() {
//        return resultList.size();
//    }
//
//    @Override
//    public Game getItem(int index) {
//        return resultList.get(index);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) mContext
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.simple_dropdown_item_2line, parent, false);
//            search = findViewById(R.id.actvProduct);
//        }
//
//        ((TextView) convertView.findViewById(R.id.text1)).setText(getItem(position).getName());
//
//        ((TextView) convertView.findViewById(R.id.text2)).setText(getItem(position).getReleaseDateFormat());
//
//        return convertView;
//    }
//
//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//            @Override
//            protected FilterResults performFiltering (CharSequence constraint) {
//                FilterResults filterResults = new FilterResults();
//                if (constraint != null) {
//                    List<Game> games = findGames(mContext, constraint.toString());
//
//                    // Assign the data to the FilterResults
//                    filterResults.values = games;
//                    filterResults.count = games.size();
//                }
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                if (results != null && results.count > 0) {
//                    resultList = (List<Game>) results.values;
//                    notifyDataSetChanged();
//                } else {
//                    notifyDataSetInvalidated();
//                }
//            }};
//        return filter;
//    }
//
//    private List<Game> findGames(Context context, String gameName) {
//
//        APIWrapper wrapper = new APIWrapper(context,"833c28f5d38906f156741a609002c0ed");
//        Parameters findGames = new Parameters().addSearch()
//        return wrapper.keywords(gameName);
//    }
//
//}
//
//
//
//        //http://makovkastar.github.io/blog/2014/04/12/android-autocompletetextview-with-suggestions-from-a-web-service/
