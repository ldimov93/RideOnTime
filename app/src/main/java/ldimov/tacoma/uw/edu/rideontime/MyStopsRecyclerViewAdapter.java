package ldimov.tacoma.uw.edu.rideontime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ldimov.tacoma.uw.edu.rideontime.BusStopsListFragment.OnListFragmentInteractionListener;
//import ldimov.tacoma.uw.edu.rideontime.dummy.DummyContent.DummyItem;
import ldimov.tacoma.uw.edu.rideontime.model.Stop;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Stop} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyStopsRecyclerViewAdapter extends RecyclerView.Adapter<MyStopsRecyclerViewAdapter.ViewHolder> {

    private final List<Stop> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyStopsRecyclerViewAdapter(List<Stop> stops, OnListFragmentInteractionListener listener) {
        mValues = stops;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_stop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getStopId());
        holder.mContentView.setText(mValues.get(position).getStopName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Stop mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
