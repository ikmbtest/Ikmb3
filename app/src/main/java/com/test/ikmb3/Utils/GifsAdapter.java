package com.test.ikmb3.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.test.ikmb3.R;
import com.test.ikmb3.giphy.GifList;

/**
 * Created by mmc on 16/3/17.
 */

public class GifsAdapter extends RecyclerView.Adapter<GifsAdapter.ViewHolder> {

    private GifList gifs;
    private Context context;

    public GifsAdapter(Context context, GifList gifs) {
        this.context = context;
        this.gifs = gifs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gif_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String originalGifUrl = gifs.getGifs().get(position).getImages().getOriginal().getUrl();
        holder.progressBar.setVisibility(View.VISIBLE);

        Glide
                .with(context)
                .load(originalGifUrl)
                .diskCacheStrategy( DiskCacheStrategy.ALL )
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .crossFade()
                .into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return gifs.getGifs().size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public SquareImageView iv;
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            this.iv = (SquareImageView) itemView.findViewById(R.id.squareImageView);
            this.progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }

    }

}
