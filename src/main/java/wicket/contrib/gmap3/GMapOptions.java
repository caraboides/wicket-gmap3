/*
 *
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.contrib.gmap3;

import java.util.Arrays;
import java.util.List;

import wicket.contrib.gmap3.api.LatLng;

/**
 * google.map.MapOptions configuration object for initializing google.maps.Map.
 * 
 * Makes an effort to support all defined options, but does not try too hard:
 * only simple parameter types are supported for now. Extend if needed.
 * 
 * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
 */
public class GMapOptions {

    static final LatLng DEFAULT_CENTER = new LatLng( 37.4419, -122.1419 );

    private String _backgroundColor;
    private LatLng _center = DEFAULT_CENTER; // required 
    private boolean _disableDefaultUI = false;
    private boolean _disableDoubleClickZoom = false;
    private boolean _draggable = true;
    private String _draggableCursor;
    private String _draggingCursor;
    private Long _heading;
    private boolean _keyboardShortcuts = true;
    private boolean _mapMaker = false;
    private boolean _mapTypeControl = true;
    private GMapTypeControlOptions _mapTypeControlOptions = new GMapTypeControlOptions();
    private GMapTypeId _mapTypeId;
    private Long _maxZoom;
    private Long _minZoom;
    private boolean _noClear = false;
    private boolean _overviewMapControl = false;
    // OverviewMapControlOptions overviewMapControlOptions;
    private boolean _panControl = true;
    // PanControlOptions panControlOptions;
    private boolean _rotateControl = true;
    // RotateControlOptions rotateControlOptions;
    private boolean _scaleControl = false;
    // ScaleControlOptions scaleControlOptions;
    private boolean _scrollwheel = true;
    // StreetViewPanorama streetView;
    private boolean _streetViewControl = true;
    // StreetViewControlOptions streetViewControlOptions;
    // private List<MapTypeStyle> styles;
    private Long _tilt;
    private long _zoom = 0;
    private boolean _zoomControl = true;

    // ZoomControlOptions zoomControlOptions;

    public GMapOptions setBackgroundColor( String backgroundColor ) {
        _backgroundColor = backgroundColor;
        return this;
    }

    public GMapOptions setCenter( LatLng center ) {
        _center = center;
        return this;
    }

    public GMapOptions setDisableDefaultUI( boolean disableDefaultUI ) {
        _disableDefaultUI = disableDefaultUI;
        return this;
    }

    public GMapOptions setDisableDoubleClickZoom( boolean disableDoubleClickZoom ) {
        _disableDoubleClickZoom = disableDoubleClickZoom;
        return this;
    }

    public GMapOptions setDraggable( boolean draggable ) {
        _draggable = draggable;
        return this;
    }

    public GMapOptions setDraggableCursor( String draggableCursor ) {
        _draggableCursor = draggableCursor;
        return this;
    }

    public GMapOptions setDraggingCursor( String draggingCursor ) {
        _draggingCursor = draggingCursor;
        return this;
    }

    public GMapOptions setHeading( Long heading ) {
        _heading = heading;
        return this;
    }

    public GMapOptions setKeyboardShortcuts( boolean keyboardShortcuts ) {
        _keyboardShortcuts = keyboardShortcuts;
        return this;
    }

    public GMapOptions setMapMaker( boolean mapMaker ) {
        _mapMaker = mapMaker;
        return this;
    }

    public GMapOptions setMapTypeControl( boolean mapTypeControl ) {
        _mapTypeControl = mapTypeControl;
        return this;
    }

    public GMapOptions setMapTypeControlOptions( GMapTypeControlOptions mapTypeControlOptions ) {
        _mapTypeControlOptions = mapTypeControlOptions;
        return this;
    }

    public GMapOptions setMapTypeId( GMapTypeId mapTypeId ) {
        _mapTypeId = mapTypeId;
        return this;
    }

    public GMapOptions setMaxZoom( Long maxZoom ) {
        _maxZoom = maxZoom;
        return this;
    }

    public GMapOptions setMinZoom( Long minZoom ) {
        _minZoom = minZoom;
        return this;
    }

    public GMapOptions setNoClear( boolean noClear ) {
        _noClear = noClear;
        return this;
    }

    public GMapOptions setOverviewMapControl( boolean overviewMapControl ) {
        _overviewMapControl = overviewMapControl;
        return this;
    }

    public GMapOptions setPanControl( boolean panControl ) {
        _panControl = panControl;
        return this;
    }

    public GMapOptions setRotateControl( boolean rotateControl ) {
        _rotateControl = rotateControl;
        return this;
    }

    public GMapOptions setScaleControl( boolean scaleControl ) {
        _scaleControl = scaleControl;
        return this;
    }

    public GMapOptions setScrollwheel( boolean scrollwheel ) {
        _scrollwheel = scrollwheel;
        return this;
    }

    public GMapOptions setStreetViewControl( boolean streetViewControl ) {
        _streetViewControl = streetViewControl;
        return this;
    }

    public GMapOptions setTilt( Long tilt ) {
        _tilt = tilt;
        return this;
    }

    public GMapOptions setZoom( long zoom ) {
        _zoom = zoom;
        return this;
    }

    public GMapOptions setZoomControl( boolean zoomControl ) {
        _zoomControl = zoomControl;
        return this;
    }

    String toJsProperties() {
        StringBuilder builder = new StringBuilder( "({" );
        if ( _backgroundColor != null ) {
            addObject( builder, "backgroundColor", _backgroundColor );
            builder.append( ',' );
        }
        builder.append( "center" ).append( ':' ).append( _center.getJSconstructor() );
        addBoolean( builder, "disableDefaultUI", _disableDefaultUI );
        addBoolean( builder, "disableDoubleClickZoom", _disableDoubleClickZoom );
        addBoolean( builder, "draggable", _draggable );
        addObject( builder, "draggableCursor", _draggableCursor );
        addObject( builder, "draggingCursor", _draggingCursor );
        addObject( builder, "heading", _heading );
        addBoolean( builder, "keyboardShortcuts", _keyboardShortcuts );
        addBoolean( builder, "mapMaker", _mapMaker );
        addBoolean( builder, "mapTypeControl", _mapTypeControl );
        addObject( builder, "mapTypeControlOptions", _mapTypeControlOptions );
        addObject( builder, "mapTypeId", _mapTypeId );
        addObject( builder, "maxZoom", _maxZoom );
        addObject( builder, "minZoom", _minZoom );
        addBoolean( builder, "noClear", _noClear );
        addBoolean( builder, "overviewMapControl", _overviewMapControl );
        addBoolean( builder, "panControl", _panControl );
        addBoolean( builder, "rotateControl", _rotateControl );
        addBoolean( builder, "scaleControl", _scaleControl );
        addBoolean( builder, "scrollwheel", _scrollwheel );
        addBoolean( builder, "streetViewControl", _streetViewControl );
        addObject( builder, "tilt", _tilt );
        addObject( builder, "zoom", Long.valueOf( _zoom ) );
        addBoolean( builder, "zoomControl", _zoomControl );

        return builder.append( "})" ).toString();
    }

    private static void addBoolean( StringBuilder builder, String name, boolean value ) {
        appendString( builder, name, String.valueOf( value ) );
    }

    private static void addObject( StringBuilder builder, String name, Object o ) {
        if ( o != null ) {
            appendString( builder, name, o.toString() );
        }
    }

    private static void addArray( StringBuilder builder, String name, List<? extends Object> entries ) {
        if ( entries != null ) {
            builder.append( name ).append( ':' ).append( '[' );
            boolean first = true;
            for ( Object e : entries ) {
                if ( first ) {
                    first = false;
                } else {
                    builder.append( ',' );
                }
                builder.append( e.toString() );
            }
            builder.append( ']' );
        }
    }

    private static void appendString( StringBuilder builder, String name, String value ) {
        builder.append( ',' ).append( name ).append( ':' ).append( value );
    }

    /**
     * google.maps.MapTypeControlOptions.
     * 
     * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
     */
    public static class GMapTypeControlOptions {

        private List<GMapTypeId> _mapTypeIds = Arrays.asList( GMapTypeId.ROADMAP, GMapTypeId.SATELLITE );
        private GControlPosition _position = GControlPosition.TOP_RIGHT;
        private GMapTypeControlStyle _style = GMapTypeControlStyle.DEFAULT;

        public GMapTypeControlOptions setMapTypeIds( List<GMapTypeId> mapTypeIds ) {
            _mapTypeIds = mapTypeIds;
            return this;
        }

        public GMapTypeControlOptions setControlPosition( GControlPosition controlPosition ) {
            _position = controlPosition;
            return this;
        }

        public GMapTypeControlOptions setStyle( GMapTypeControlStyle style ) {
            _style = style;
            return this;
        }

        String toJsProperties() {
            StringBuilder builder = new StringBuilder( "({" );
            addArray( builder, "mapTypeIds", _mapTypeIds );
            addObject( builder, "position", _position );
            addObject( builder, "style", _style );
            return builder.append( "})" ).toString();
        }

        @Override
        public String toString() {
            return toJsProperties();
        }
    }

    /**
     * google.maps.MapTypeId.
     * 
     * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
     */
    public enum GMapTypeId {
            HYBRID,
            ROADMAP,
            SATELLITE,
            TERRAIN,

        ;

        @Override
        public String toString() {
            return "google.maps.MapTypeId." + name();
        };
    }

    /**
     * google.maps.ControlPosition.
     * 
     * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
     */
    public enum GControlPosition {
            BOTTOM_CENTER,
            BOTTOM_LEFT,
            BOTTOM_RIGHT,
            LEFT_BOTTOM,
            LEFT_CENTER,
            LEFT_TOP,
            RIGHT_BOTTOM,
            RIGHT_CENTER,
            RIGHT_TOP,
            TOP_CENTER,
            TOP_LEFT,
            TOP_RIGHT;

        @Override
        public String toString() {
            return "google.maps.MapTypeId." + name();
        };
    }

    /**
     * google.maps.MapTypeControlStyle.
     * 
     * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
     */
    public enum GMapTypeControlStyle {
            DEFAULT,
            DROPDOWN_MENU,
            HORIZONTAL_BAR,

        ;

        @Override
        public String toString() {
            return "google.maps.MapTypeId." + name();
        };
    }

}
