package wicket.contrib.examples.gmap.custompoint;

import org.apache.wicket.ResourceReference;

import wicket.contrib.examples.WicketExamplePage;
import wicket.contrib.gmap3.GMap;
import wicket.contrib.gmap3.api.GIcon;
import wicket.contrib.gmap3.api.GMarker;
import wicket.contrib.gmap3.api.GMarkerOptions;
import wicket.contrib.gmap3.api.GOverlay;
import wicket.contrib.gmap3.api.GPoint;
import wicket.contrib.gmap3.api.GSize;
import wicket.contrib.gmap3.api.LatLng;

/**
 * SimplePage for the wicket-contrib-gmap2 project
 */
public class CustomPointPage extends WicketExamplePage {

    private static final long serialVersionUID = 1L;

    public CustomPointPage() {
        GMap map = new GMap( "map" );
        map.setCenter( new LatLng( 52.37649, 4.888573 ) );
        add( map );

        GIcon icon =
                new GIcon( urlFor( new ResourceReference( CustomPointPage.class, "image.gif" ) ).toString(), urlFor(
                        new ResourceReference( CustomPointPage.class, "shadow.png" ) ).toString() ).iconSize( new GSize( 64, 64 ) ).shadowSize(
                        new GSize( 64, 64 ) ).iconAnchor( new GPoint( 19, 40 ) ).infoWindowAnchor( new GPoint( 9, 2 ) ).infoShadowAnchor(
                        new GPoint( 18, 25 ) );

        GOverlay marker = new GMarker( new LatLng( 52.37649, 4.888573 ), new GMarkerOptions( "My Title", icon ) );

        map.addOverlay( marker );
    }
}