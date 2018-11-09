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

public class HotelFragment extends Fragment {
    public HotelFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_pos,container,false);
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.hotel1name),getString(R.string.hotel1address),getString(R.string.hotel1contact),R.drawable.hotel1));
        places.add(new Place(getString(R.string.hotel2name),getString(R.string.hotel2address),getString(R.string.hotel2Contact),R.drawable.hotel2));
        places.add(new Place(getString(R.string.hotel3name),getString(R.string.hotel3address),getString(R.string.hotel3contact),R.drawable.hotel3));
        places.add(new Place(getString(R.string.hotel4name),getString(R.string.hotel4address),getString(R.string.hotel4contact),R.drawable.hotel4));
        places.add(new Place(getString(R.string.hotel5name),getString(R.string.hotel5address),getString(R.string.hotel5contact),R.drawable.hotel5));
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
