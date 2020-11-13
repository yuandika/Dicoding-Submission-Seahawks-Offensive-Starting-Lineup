package com.yuandika.seahawksoffensivestartinglineup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlayer;
    private ArrayList<Player> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);


        rvPlayer = findViewById(R.id.rv_player);
        rvPlayer.setHasFixedSize(true);

        list.addAll(PlayerData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvPlayer.setLayoutManager(new LinearLayoutManager(this));
        HalamanUtamaAdapter halamanUtamaAdapter = new HalamanUtamaAdapter(list);
        rvPlayer.setAdapter(halamanUtamaAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(moveIntent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.halaman_utama:
                title = "Halaman Utama";
                showRecyclerList();
                break;
            case R.id.about:
                title = "About";

                break;
        }
        setActionBarTitle(title);
    }



    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}