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

public class FoodFragment extends Fragment {
    public FoodFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.list_pos,container,false);

       final ArrayList<Place> places = new ArrayList<>();
       places.add(new Place(getString(R.string.food1name),getString(R.string.food1Address),getString(R.string.food1Contact),R.drawable.food1));
       places.add(new Place(getString(R.string.food2name),getString(R.string.food2Address),getString(R.string.food2Contact),R.drawable.food2));
       places.add(new Place(getString(R.string.food3Name),getString(R.string.food3Address),getString(R.string.food3Contact),R.drawable.food3));
       places.add(new Place(getString(R.string.food4Name),getString(R.string.food4address),getString(R.string.food4Contact),R.drawable.food4));
       places.add(new Place(getString(R.string.food5Name),getString(R.string.food5Address),getString(R.string.food5Contact),R.drawable.food5));

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
