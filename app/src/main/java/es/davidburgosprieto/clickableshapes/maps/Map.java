package es.davidburgosprieto.clickableshapes.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import es.davidburgosprieto.clickableshapes.polygons.Point;

public class Map {

    public interface Listener {
        void onMapTouched(Zone zone);
    }

    private ImageView mImageView;
    private ArrayList<Zone> mZones;
    private Listener mListener;

    @SuppressLint("ClickableViewAccessibility")
    public Map(ImageView imageView, Listener listener, Zone... zone) {
        mImageView = imageView;
        mListener = listener;
        mZones = new ArrayList<>();
        Collections.addAll(mZones, zone);

        // Add OnTouchListener to the map, in order to know the touch coordinates.
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Point point = new Point(event.getRawX(), event.getRawY());
/*
                String text = event.getRawX() + ", " + event.getRawY();
                Toast.makeText((Context) mListener, text, Toast.LENGTH_SHORT).show();
*/
                boolean found = false;
                int i = 0;
                Zone zone;
                while (i < mZones.size() && !found) {
                    zone = mZones.get(i);
                    if (zone.getPolygon().contains(point)) {
                        // The touched coordinates are inside the current zone.
                        zone.setVisible(!zone.isVisible());
                        mListener.onMapTouched(zone);
                        found = true;
                    }
                    i++;
                }
                return false;
            }
        });
    }

    public ArrayList<Zone> getZones() {
        return mZones;
    }
}
