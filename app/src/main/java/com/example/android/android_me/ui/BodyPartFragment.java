package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // Final Strings to store state information about the list of images and list index
    public static final String Image_Id_List = "image_ids";
    public static final String List_Index = "list_index";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageids;
    private int mlistIndex;

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Load the saved state if there is any
        if(savedInstanceState != null){
            mImageids = savedInstanceState.getIntegerArrayList(Image_Id_List);
            mlistIndex = savedInstanceState.getInt(List_Index);
        }

        // Inflate the fragment layout
        View rootview = inflater.inflate(R.layout.fragement_body_part, container, false);

        // Reference to ImageView
        final ImageView imageView = (ImageView) rootview.findViewById(R.id.body_part_Image_view);


        //set image resource to display
        if(mImageids != null){
            imageView.setImageResource(mImageids.get(mlistIndex));
        }
        //imageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        // set a click listener on the image view
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mlistIndex < mImageids.size()-1)
                {
                    mlistIndex++;
                }
                else {
                    mlistIndex = 0;
                }
                //set image resource to display
                imageView.setImageResource(mImageids.get(mlistIndex));
            }
        });

        // return root view
        return rootview;
    }

    // Setter methods for keeping track of the list images this fragment can display
    // and which image in the list is currently being displayed

    public void setmImageids(List<Integer> imageids){
        mImageids = imageids;
    }

    public void setlistIndex(int index){
        mlistIndex = index;
    }

    // Override onSaveInstanceState and save the current state of this fragment
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(Image_Id_List, (ArrayList<Integer>) mImageids);
        currentState.putInt(List_Index, mlistIndex);
    }
}
