package wicket.contrib.examples.gmap.listen.overlay.simple;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

import wicket.contrib.examples.GMapExampleApplication;
import wicket.contrib.examples.WicketExamplePage;
import wicket.contrib.gmap3.GMap;
import wicket.contrib.gmap3.api.GControl;
import wicket.contrib.gmap3.api.GEvent;
import wicket.contrib.gmap3.api.GEventHandler;
import wicket.contrib.gmap3.api.LatLng;
import wicket.contrib.gmap3.api.GMarker;
import wicket.contrib.gmap3.api.GMarkerOptions;

/**
 * Example HomePage for the wicket-contrib-gmap2 project
 */
public class HomePage extends WicketExamplePage {

    private static final long serialVersionUID = 1L;

    public HomePage() {
        final GMap topMap = new GMap( "topPanel", GMapExampleApplication.get().getGoogleMapsAPIkey() );
        topMap.addControl( GControl.GLargeMapControl );
        add( topMap );

        GMarkerOptions options = new GMarkerOptions().draggable( true );
        final GMarker marker = new GMarker( topMap.getCenter(), options );
        final Label label = new Label( "label", new PropertyModel<LatLng>( marker, "latLng" ) );
        label.setOutputMarkupId( true );
        add( label );
        marker.addListener( GEvent.dragend, new GEventHandler() {
            private static final long serialVersionUID = 1L;

            @Override
            public void onEvent( AjaxRequestTarget target ) {
                target.addComponent( label );
            }
        } );
        topMap.addOverlay( marker );
    }
}
