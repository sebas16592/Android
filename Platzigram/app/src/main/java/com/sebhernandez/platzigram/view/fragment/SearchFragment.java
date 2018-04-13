package com.sebhernandez.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.SearchView;

import com.sebhernandez.platzigram.R;
import com.sebhernandez.platzigram.adapter.PictureAdapterRecylerView;
import com.sebhernandez.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //SearchView searchView = (SearchView) view.findViewById(R.id.search_view);
        //searchView.setSearchableInfo(getSearchableInfo(getComponentName()));
        //searchView.setIconifiedByDefault(true);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.search_result);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),
                2, GridLayout.VERTICAL, false);

        picturesRecycler.setLayoutManager(gridLayoutManager);

        PictureAdapterRecylerView pictureAdapterRecyclerView =
                new PictureAdapterRecylerView(buildPictures(),
                        R.layout.cardview_search, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlGHaWFIcGWVsIz4y5u7zpHmnfYQ679zrnmQFp56Hw-e0IC3nDlg","Sebastian1 Hernandez","4 días","3 me gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHysjd-Eg2aJ4Y15_CU0TCslvX-maG6vxwHPrdG7UpVLhWO1sK7Q","Sebastian2 Hernandez","4 días","3 me gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhE2RZYhz4O8OOpFpw0V5PLpFbHunwSpzHFnl8Vh-FkqQOazoB","Sebastian3 Hernandez","4 días","3 me gusta"));
        pictures.add(new Picture("http://3.bp.blogspot.com/-871Xcx7wo34/T-On76em9vI/AAAAAAAALoc/HIXwpwiwMlE/w1200-h630-p-k-no-nu/monos-languares.jpg","Sebastian4 Hernandez","4 días","3 me gusta"));

        return pictures;
    }

}
