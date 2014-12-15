package com.example.paolac.lolcounterselect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ChampionSelectActivity extends Activity implements ChampionSelectAdapter.OnChampionClickedListener {

//    private final OkHttpClient client = new OkHttpClient();

    public static void start(HomeActivity context) {
        Intent intent = new Intent(context, ChampionSelectActivity.class);
        context.startActivity(intent);
    }

//    public void run() throws Exception {
//        Request request = new Request.Builder()
//                .url("https://prototype-api.herokuapp.com/champions.json")
//                .build();
//        Response response = client.newCall(request).execute();
//        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//        Headers responseHeaders = response.headers();
//        for (int i = 0; i < responseHeaders.size(); i++) {
//            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//        }
//
//        System.out.println(response.body().string());

//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                System.out.println(e);
//            }
//
//            @Override public void onResponse(Response response) throws IOException {
//                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//
//                System.out.println(response.body().string());
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_select);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.champion_recycler_view);

        ArrayList<String> itemsData = new ArrayList<String>();
        itemsData.add("Solo Queue Tier List");
        itemsData.add("Competitive Tier List");
        itemsData.add("Top Tier List");
        itemsData.add("Mid Tier List");
        itemsData.add("Jungle Tier List");
        itemsData.add("Support Tier List");
        itemsData.add("ADC Tier List");

        try {
            JSONArray mockChampions = new JSONArray(MockChampionJson.MOCK_CHAMPION_JSON);
            for (int i = 0; i < mockChampions.length(); i++) {
                Champion champion = new Champion((JSONObject) mockChampions.get(i));
                itemsData.add(champion.getName());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        ChampionSelectAdapter mAdapter = new ChampionSelectAdapter(itemsData);
        mAdapter.setOnChampionClickedListener(this);
        mAdapter.roboto = Typeface.createFromAsset(this.getBaseContext().getAssets(),"Gotham-Medium.otf");
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.champion_select, menu);
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

    @Override
    public void onChampionItemClicked(String champion) {
        ChampionCounters.start(this);

    }
}
