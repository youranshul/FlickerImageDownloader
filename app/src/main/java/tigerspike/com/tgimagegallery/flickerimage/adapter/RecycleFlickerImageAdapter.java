package tigerspike.com.tgimagegallery.flickerimage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tigerspike.flickerimage.model.FlickerImageData;

import butterknife.Bind;
import butterknife.ButterKnife;
import tigerspike.com.tgimagegallery.R;

public class RecycleFlickerImageAdapter extends
        RecyclerView.Adapter<RecycleFlickerImageAdapter.RecipeViewHolder> {

    private final FlickerImageData flickerImageData;

    public RecycleFlickerImageAdapter(FlickerImageData flickerImageData) {
        this.flickerImageData = flickerImageData;
    }


    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_content,
                parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {

        holder.PicName.setText(flickerImageData.getAuthorName(position));
        holder.PicTitle.setText(flickerImageData.getImageTitle(position));
    }

    @Override
    public int getItemCount() {
        return flickerImageData == null ? 0 : flickerImageData.getItemsSize();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pic)
        ImageView pic;
        @Bind(R.id.pic_name)
        TextView PicName;
        @Bind(R.id.pic_title)
        TextView PicTitle;

        RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
