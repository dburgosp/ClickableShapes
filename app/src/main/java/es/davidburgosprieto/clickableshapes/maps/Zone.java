package es.davidburgosprieto.clickableshapes.maps;

import android.view.View;
import android.widget.ImageView;

import es.davidburgosprieto.clickableshapes.polygons.Polygon;

public class Zone {
    private ImageView mImageView;
    private Polygon mPolygon;
    private boolean mVisible;
    private String mName;

    public Zone(ImageView imageView, Polygon polygon, String name, boolean visible) {
        mImageView = imageView;
        mPolygon = polygon;
        mVisible = visible;
        mName = name;
    }

    public Polygon getPolygon() {
        return mPolygon;
    }

    public boolean isVisible() {
        return mVisible;
    }

    public void setVisible(boolean visible) {
        if (visible)
            mImageView.setVisibility(View.VISIBLE);
        else
            mImageView.setVisibility(View.INVISIBLE);
        mVisible = visible;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
