package com.example.paolac.lolcounterselect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


public class TierListsActivity extends Activity {

    public static void start(HomeActivity context) {
        Intent intent = new Intent(context, TierListsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tier_lists);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ArrayList<String> itemsData = new ArrayList<String>();
        itemsData.add("Solo Queue Tier List");
        itemsData.add("Competitive Tier List");
        itemsData.add("Top Tier List");
        itemsData.add("Mid Tier List");
        itemsData.add("Jungle Tier List");
        itemsData.add("Support Tier List");
        itemsData.add("ADC Tier List");

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        TierListsAdapter mAdapter = new TierListsAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tier_lists, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
