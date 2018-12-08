/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null)
        {
            HeadPartFragment headFragment = new HeadPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            LegPartFragment legFragment =  new LegPartFragment();

            // Set the list of image id's and set the position for head
            headFragment.setmImageids(AndroidImageAssets.getHeads());
            headFragment.setlistIndex(0);

            // Set the list of image id's and set the position for body
            bodyFragment.setmImageids(AndroidImageAssets.getBodies());
            bodyFragment.setlistIndex(0);

            // Set the list of image id's and set the position for leg
            legFragment.setmImageids(AndroidImageAssets.getLegs());
            legFragment.setlistIndex(0);

            // FragmentManager and transaction to add fragment to the screen
            // transcations can be Add, Remove, Replace
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
