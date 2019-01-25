/*
 * Clickable Galicia Map, using Polygon class from https://github.com/sromku/polygon-contains-point
 */

package es.davidburgosprieto.clickableshapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import es.davidburgosprieto.clickableshapes.maps.Map;
import es.davidburgosprieto.clickableshapes.maps.Zone;
import es.davidburgosprieto.clickableshapes.polygons.Point;
import es.davidburgosprieto.clickableshapes.polygons.Polygon;

public class MainActivity extends AppCompatActivity implements Map.Listener {

    final Polygon mPolygon1 = Polygon.Builder()
            .addVertex(new Point(177, 1258))
            .addVertex(new Point(94, 1054))
            .addVertex(new Point(164, 924))
            .addVertex(new Point(215, 894))
            .addVertex(new Point(449, 871))
            .addVertex(new Point(451, 796))
            .addVertex(new Point(552, 720))
            .addVertex(new Point(700, 710))
            .addVertex(new Point(640, 881))
            .addVertex(new Point(561, 1151))
            .build();
    final Polygon mPolygon2 = Polygon.Builder()
            .addVertex(new Point(710, 721))
            .addVertex(new Point(919, 821))
            .addVertex(new Point(866, 916))
            .addVertex(new Point(985, 1042))
            .addVertex(new Point(939, 1112))
            .addVertex(new Point(996, 1160))
            .addVertex(new Point(909, 1265))
            .addVertex(new Point(850, 1424))
            .addVertex(new Point(773, 1392))
            .addVertex(new Point(704, 1404))
            .addVertex(new Point(583, 1324))
            .addVertex(new Point(615, 1234))
            .addVertex(new Point(557, 1579))
            .addVertex(new Point(621, 958))
            .build();
    final Polygon mPolygon3 = Polygon.Builder()
            .addVertex(new Point(172, 1638))
            .addVertex(new Point(183, 1512))
            .addVertex(new Point(254, 1424))
            .addVertex(new Point(208, 1430))
            .addVertex(new Point(281, 1374))
            .addVertex(new Point(222, 1351))
            .addVertex(new Point(233, 1249))
            .addVertex(new Point(289, 1229))
            .addVertex(new Point(442, 1155))
            .addVertex(new Point(550, 1163))
            .addVertex(new Point(559, 1302))
            .addVertex(new Point(411, 1346))
            .addVertex(new Point(434, 1513))
            .addVertex(new Point(284, 1557))
            .build();
    final Polygon mPolygon4 = Polygon.Builder()
            .addVertex(new Point(446, 1364))
            .addVertex(new Point(587, 1326))
            .addVertex(new Point(702, 1401))
            .addVertex(new Point(802, 1395))
            .addVertex(new Point(848, 1468))
            .addVertex(new Point(904, 1378))
            .addVertex(new Point(1007, 1391))
            .addVertex(new Point(1024, 1453))
            .addVertex(new Point(925, 1584))
            .addVertex(new Point(854, 1680))
            .addVertex(new Point(748, 1704))
            .addVertex(new Point(659, 1652))
            .addVertex(new Point(460, 1684))
            .addVertex(new Point(497, 1558))
            .addVertex(new Point(475, 1484))
            .build();

    private Toast mToast;
    private Map mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map zones.
        ImageView zone1 = findViewById(R.id.zona1);
        ImageView zone2 = findViewById(R.id.zona2);
        ImageView zone3 = findViewById(R.id.zona3);
        ImageView zone4 = findViewById(R.id.zona4);
        Zone mZone1 = new Zone(zone1, mPolygon1, "La Coruña", true);
        Zone mZone2 = new Zone(zone2, mPolygon2, "Pontevedra", true);
        Zone mZone3 = new Zone(zone3, mPolygon3, "Lugo", true);
        Zone mZone4 = new Zone(zone4, mPolygon4, "Orense", true);

        // Map. We add this activity as a listener for receiving OnTouch events from the Map
        // instance.
        ImageView map = findViewById(R.id.map);
        mMap = new Map(map, this, mZone1, mZone2, mZone3, mZone4);
    }

    /**
     * This method implements the listener for receiving OnTouch events from the {@link Map}
     * global object mMap. This callback method is called when user has touched into one of the
     * zones defined into the map.
     *
     * @param zone is the clicked {@link Zone} object.
     */
    @Override
    public void onMapTouched(Zone zone) {
        String state = zone.isVisible() ? "ON" : "OFF";
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(this, zone.getName() + " " + state, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
