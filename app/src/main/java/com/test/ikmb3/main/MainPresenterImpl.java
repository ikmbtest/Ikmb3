package com.test.ikmb3.main;

import com.test.ikmb3.giphy.GifList;

/**
 * Created by mmc on 21/3/17.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private LoadGifsInteractor loadGifsInteractor;

    public MainPresenterImpl(MainView mainView, LoadGifsInteractor loadGifsInteractor) {
        this.mainView = mainView;
        this.loadGifsInteractor = loadGifsInteractor;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            loadGifsInteractor.loadGifs(new LoadGifsInteractor.OnFinishedListener() {
                @Override
                public void onFinished(GifList gifs) {
                    mainView.setGifs(gifs);
                }

                @Override
                public void onFinishedError(String error) {
                    mainView.showError(error);
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        this.mainView = null;
    }
}
