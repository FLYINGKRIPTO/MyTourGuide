package com.example.dell.mytourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    public HistoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_pos,container,false);
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.history1name),getString(R.string.history1address),getString(R.string.history1Contact),R.drawable.history1));
        places.add(new Place(getString(R.string.history2Name),getString(R.string.history2Address),getString(R.string.history2Contact),R.drawable.history2));
        places.add(new Place(getString(R.string.history3Name),getString(R.string.history3Address),getString(R.string.history3Contact),R.drawable.history3));
        places.add(new Place(getString(R.string.history4Name),getString(R.string.history4Address),getString(R.string.history4Contact),R.drawable.history4));
        places.add(new Place(getString(R.string.history5Name),getString(R.string.history5address),getString(R.string.history5Contact),R.drawable.history5));
        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);
        ListView listView  = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Place place = places.get(position);
                String url = getString(R.string.mapUrl)+place.getPlaceName()+ " " + place.getPlaceAddress() ;
                Intent i  = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });


        return rootView;
    }
}
