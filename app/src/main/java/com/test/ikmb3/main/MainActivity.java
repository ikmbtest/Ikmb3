package com.test.ikmb3.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.test.ikmb3.R;
import com.test.ikmb3.giphy.GifsAdapter;
import com.test.ikmb3.Utils.ItemOffsetDecoration;
import com.test.ikmb3.giphy.GifList;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView recyclerViewGifs;
    RecyclerView.LayoutManager layoutManager;
    GifsAdapter adapter;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewGifs = (RecyclerView) findViewById(R.id.recyclerViewGifs);

        presenter = new MainPresenterImpl(this, new LoadGifsInteractorImpl());

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void setGifs(GifList list) {
        adapter = new GifsAdapter(MainActivity.this, list);
        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerViewGifs.setLayoutManager(layoutManager);
        recyclerViewGifs.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGifs.setAdapter(adapter);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerViewGifs.addItemDecoration(itemDecoration);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
