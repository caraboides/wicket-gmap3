package wicket.contrib.gmap3.api;

import org.apache.wicket.Component;
import org.apache.wicket.Request;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.RepeatingView;

import wicket.contrib.gmap3.GMap;

/**
 * Represents an Google Maps API's <a href=
 * "http://www.google.com/apis/maps/documentation/reference.html#GInfoWindow"
 * >GInfoWindow</a>.
 */
public class GInfoWindow extends WebMarkupContainer {
    /**
     * Default serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private GInfoWindowTab[] _tabs;

    private LatLng _latLng;

    private GMarker _marker;

    private final RepeatingView content = new RepeatingView( "content" );

    public GInfoWindow() {
        super( "infoWindow" );

        setOutputMarkupId( true );
        add( content );
    }

    /**
     * Update state from a request to an AJAX target.
     */
    public void update() {
        Request request = RequestCycle.get().getRequest();

        if ( Boolean.parseBoolean( request.getParameter( "infoWindow.hidden" ) ) ) {
            // Attention: don't use close() as this might result in an
            // endless AJAX request loop
            setTabs( new GInfoWindowTab[0] );
            _marker = null;
            _latLng = null;
        }
    }

    public final String getJSinit() {
        if ( _latLng != null ) {
            return getJSopen( _latLng, _tabs );
        }

        if ( _marker != null ) {
            return getJSopen( _marker, _tabs );
        }

        return "";
    }

    private void setTabs( GInfoWindowTab[] tabs ) {
        content.removeAll();

        this._tabs = tabs;
        for ( GInfoWindowTab tab : tabs ) {
            content.add( tab.getContent() );
        }
    }

    /**
     * Open an info window.
     * 
     * @param content
     *            content to open in info window
     * @return This
     */
    public GInfoWindow open( LatLng latLng, Component content ) {
        return open( latLng, new GInfoWindowTab( content ) );
    }

    /**
     * Open an info window.
     * 
     * @param content
     *            content to open in info window
     * @return This
     */
    public GInfoWindow open( GMarker marker, Component content ) {
        return open( marker, new GInfoWindowTab( content ) );
    }

    public GInfoWindow open( LatLng latLng, GInfoWindowTab... tabs ) {
        setTabs( tabs );

        this._latLng = latLng;
        this._marker = null;

        if ( AjaxRequestTarget.get() != null ) {
            AjaxRequestTarget.get().appendJavascript( getJSopen( latLng, tabs ) );
            AjaxRequestTarget.get().addComponent( this );
        }

        return this;
    }

    public GInfoWindow open( GMarker marker, GInfoWindowTab... tabs ) {
        setTabs( tabs );

        this._latLng = null;
        this._marker = marker;

        if ( AjaxRequestTarget.get() != null ) {
            AjaxRequestTarget.get().appendJavascript( getJSopen( marker, tabs ) );
            AjaxRequestTarget.get().addComponent( this );
        }

        return this;
    }

    public boolean isOpen() {
        return ( _latLng != null || _marker != null );
    }

    public void close() {
        setTabs( new GInfoWindowTab[0] );

        _marker = null;
        _latLng = null;

        if ( AjaxRequestTarget.get() != null ) {
            AjaxRequestTarget.get().appendJavascript( getJSclose() );
            AjaxRequestTarget.get().addComponent( this );
        }
    }

    private String getJSopen( LatLng latLng, GInfoWindowTab[] tabs ) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( "openInfoWindowTabs(" );
        buffer.append( latLng.getJSconstructor() );
        buffer.append( ",[" );

        boolean first = true;
        for ( GInfoWindowTab tab : tabs ) {
            if ( !first ) {
                buffer.append( "," );
            }
            buffer.append( tab.getJSconstructor() );
            first = false;
        }

        buffer.append( "])" );

        return getGMap2().getJSinvoke( buffer.toString() );
    }

    private String getJSopen( GMarker marker, GInfoWindowTab[] tabs ) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( "openMarkerInfoWindowTabs('" );
        buffer.append( marker.getId() );
        buffer.append( "',[" );

        boolean first = true;
        for ( GInfoWindowTab tab : tabs ) {
            if ( !first ) {
                buffer.append( "," );
            }
            buffer.append( tab.getJSconstructor() );
            first = false;
        }

        buffer.append( "])" );

        return getGMap2().getJSinvoke( buffer.toString() );
    }

    private String getJSclose() {
        return getGMap2().getJSinvoke( "closeInfoWindow()" );
    }

    private GMap getGMap2() {
        return findParent( GMap.class );
    }

}