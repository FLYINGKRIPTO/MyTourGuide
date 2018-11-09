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

public class FunFragment extends Fragment {
    public FunFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_pos,container,false);
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.fun1Name),getString(R.string.fun1Address),getString(R.string.fun1Contact),R.drawable.fun1));
        places.add(new Place(getString(R.string.fun2Name),getString(R.string.fun2Address),getString(R.string.fun2Contact),R.drawable.fun2));
        places.add(new Place(getString(R.string.fun3Name),getString(R.string.fun3address),getString(R.string.fun3Contact),R.drawable.fun3));
        places.add(new Place(getString(R.string.fun4Name),getString(R.string.fun4Address),getString(R.string.fun4Contact),R.drawable.fun4));
        places.add(new Place(getString(R.string.fun5Name),getString(R.string.fun5Address),getString(R.string.fun5Contact),R.drawable.fun5));
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
