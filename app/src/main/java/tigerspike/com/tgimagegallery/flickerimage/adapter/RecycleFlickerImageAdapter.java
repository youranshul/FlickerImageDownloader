package tigerspike.com.tgimagegallery.flickerimage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tigerspike.flickerimage.model.FlickerImageData;

import butterknife.Bind;
import butterknife.ButterKnife;
import tigerspike.com.tgimagegallery.R;
import tigerspike.com.tgimagegallery.flickerimage.OnImageClickListener;

public class RecycleFlickerImageAdapter extends
        RecyclerView.Adapter<RecycleFlickerImageAdapter.RecipeViewHolder> {

    private OnImageClickListener onImageClickListener;
    private FlickerImageData flickerImageData;

    public RecycleFlickerImageAdapter(FlickerImageData flickerImageData) {
        this.flickerImageData = flickerImageData;
    }

    public void setOnImageClickListener(OnImageClickListener listener) {
        this.onImageClickListener = listener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_content,
                parent, false);
        return new RecipeViewHolder(view, onImageClickListener);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {

        holder.PicName.setText(flickerImageData.getAuthorName(position));
        holder.PicTitle.setText(flickerImageData.getImageTitle(position));
        Picasso.with(holder.pic.getContext()).load(flickerImageData.getImageLink(position)).into(
                holder.pic);
        holder.pic.setTag(position);
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null) {
                    onImageClickListener.onImageClick(flickerImageData.getImageLink(
                            (Integer) v.getTag()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return flickerImageData.getItemsSize();
    }

    public void refreshData(FlickerImageData flickerImageData) {
        this.flickerImageData = flickerImageData;
        this.notifyDataSetChanged();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {

        private final OnImageClickListener onImageClickListener;
        @Bind(R.id.pic)
        ImageView pic;
        @Bind(R.id.pic_name)
        TextView PicName;
        @Bind(R.id.pic_title)
        TextView PicTitle;

        RecipeViewHolder(View itemView, OnImageClickListener onImageClickListener) {
            super(itemView);
            this.onImageClickListener = onImageClickListener;
            ButterKnife.bind(this, itemView);
        }
    }
}
