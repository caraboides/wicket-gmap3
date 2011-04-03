/*
 * $Id$
 * $Revision$
 * $Date$
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
package wicket.contrib.gmap3.api;

import java.util.Iterator;
import java.util.List;

/**
 * Represents an Google Maps API's
 * http://code.google.com/apis/maps/documentation/reference.html#GIcon
 * 
 * @author Robert Jacolin, Gregory Maes, Vincent Demay, Anyware Technologies
 */
public class GIcon implements GValue, Cloneable {

    private static final long serialVersionUID = 1714038753187423501L;

    private String _image;
    private String _shadow;
    private GSize _iconSize = null;
    private GSize _shadowSize = null;
    private GPoint _iconAnchor = null;
    private GPoint _infoWindowAnchor = null;
    private GPoint _infoShadowAnchor = null;

    /**
     * http://code.google.com/intl/de/apis/maps/documentation/reference.html#
     * GIcon.imageMap
     */
    private List<Integer> _imageMap = null;

    public GIcon() {
        _image = "http://www.google.com/mapfiles/marker.png";
        _shadow = "http://www.google.com/mapfiles/shadow50.png";

    }

    public GIcon( final String image ) {
        _image = image;
        _shadow = "http://www.google.com/mapfiles/shadow50.png";
    }

    public GIcon( final String image, final String shadow ) {
        this._image = image;
        this._shadow = shadow;
    }

    public GIcon( final String image, final String shadow, final GSize iconSize, final GSize shadowSize, final GPoint iconAnchor,
            final GPoint infoWindowAnchor, final GPoint infoShadowAnchor ) {
        _image = image;
        _shadow = shadow;
        _iconSize = iconSize;
        _shadowSize = shadowSize;
        _iconAnchor = iconAnchor;
        _infoWindowAnchor = infoWindowAnchor;
        _infoShadowAnchor = infoShadowAnchor;
    }

    @Override
    public GIcon clone() {
        try {
            return (GIcon) super.clone();
        } catch ( final CloneNotSupportedException e ) {
            throw new Error( e );
        }
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final GIcon other = (GIcon) obj;
        if ( _iconAnchor == null ) {
            if ( other._iconAnchor != null ) {
                return false;
            }
        } else if ( !_iconAnchor.equals( other._iconAnchor ) ) {
            return false;
        }
        if ( _iconSize == null ) {
            if ( other._iconSize != null ) {
                return false;
            }
        } else if ( !_iconSize.equals( other._iconSize ) ) {
            return false;
        }
        if ( _image == null ) {
            if ( other._image != null ) {
                return false;
            }
        } else if ( !_image.equals( other._image ) ) {
            return false;
        }
        if ( _imageMap == null ) {
            if ( other._imageMap != null ) {
                return false;
            }
        } else if ( !_imageMap.equals( other._imageMap ) ) {
            return false;
        }
        if ( _infoShadowAnchor == null ) {
            if ( other._infoShadowAnchor != null ) {
                return false;
            }
        } else if ( !_infoShadowAnchor.equals( other._infoShadowAnchor ) ) {
            return false;
        }
        if ( _infoWindowAnchor == null ) {
            if ( other._infoWindowAnchor != null ) {
                return false;
            }
        } else if ( !_infoWindowAnchor.equals( other._infoWindowAnchor ) ) {
            return false;
        }
        if ( _shadow == null ) {
            if ( other._shadow != null ) {
                return false;
            }
        } else if ( !_shadow.equals( other._shadow ) ) {
            return false;
        }
        if ( _shadowSize == null ) {
            if ( other._shadowSize != null ) {
                return false;
            }
        } else if ( !_shadowSize.equals( other._shadowSize ) ) {
            return false;
        }
        return true;
    }

    public GPoint getIconAnchor() {
        return _iconAnchor;
    }

    public GSize getIconSize() {
        return _iconSize;
    }

    public String getId() {
        return "icon" + String.valueOf( System.identityHashCode( this ) );
    }

    public String getImage() {
        return _image;
    }

    public List<Integer> getImageMap() {
        return _imageMap;
    }

    public GPoint getInfoShadowAnchor() {
        return _infoShadowAnchor;
    }

    public GPoint getInfoWindowAnchor() {
        return _infoWindowAnchor;
    }

    @Override
    public String getJSconstructor() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append( "(function() {\n" );
        buffer.append( "var icon = new GIcon();\n" );
        buffer.append( "icon.image = \"" ).append( _image ).append( "\";\n" );
        if ( _shadow != null ) {
            buffer.append( "icon.shadow = \"" ).append( _shadow ).append( "\";\n" );
        }

        if ( _iconSize != null ) {
            buffer.append( "icon.iconSize = " ).append( _iconSize.getJSconstructor() ).append( ";\n" );
        }

        if ( _shadowSize != null ) {
            buffer.append( "icon.shadowSize = " ).append( _shadowSize.getJSconstructor() ).append( ";\n" );
        }
        if ( _imageMap != null ) {
            buffer.append( "icon.imageMap  = [" );
            final Iterator<Integer> imit = _imageMap.iterator();
            while ( imit.hasNext() ) {
                buffer.append( imit.next().toString() );
                if ( imit.hasNext() ) {
                    buffer.append( ", " );
                }
            }
            buffer.append( "];\n" );
        }
        if ( _iconAnchor != null ) {
            buffer.append( "icon.iconAnchor = " ).append( _iconAnchor.getJSconstructor() ).append( ";\n" );
        }

        if ( _infoWindowAnchor != null ) {
            buffer.append( "icon.infoWindowAnchor = " ).append( _infoWindowAnchor.getJSconstructor() ).append( ";\n" );
        }

        if ( _infoShadowAnchor != null ) {
            buffer.append( "icon.infoShadowAnchor = " ).append( _infoShadowAnchor.getJSconstructor() ).append( ";\n" );
        }

        buffer.append( "return icon;\n" );
        buffer.append( "})()\n" );
        return buffer.toString();
    }

    public String getShadow() {
        return _shadow;
    }

    public GSize getShadowSize() {
        return _shadowSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( _iconAnchor == null
            ? 0
            : _iconAnchor.hashCode() );
        result = prime * result + ( _iconSize == null
            ? 0
            : _iconSize.hashCode() );
        result = prime * result + ( _image == null
            ? 0
            : _image.hashCode() );
        result = prime * result + ( _imageMap == null
            ? 0
            : _imageMap.hashCode() );
        result = prime * result + ( _infoShadowAnchor == null
            ? 0
            : _infoShadowAnchor.hashCode() );
        result = prime * result + ( _infoWindowAnchor == null
            ? 0
            : _infoWindowAnchor.hashCode() );
        result = prime * result + ( _shadow == null
            ? 0
            : _shadow.hashCode() );
        result = prime * result + ( _shadowSize == null
            ? 0
            : _shadowSize.hashCode() );
        return result;
    }

    public GIcon iconAnchor( final GPoint iconAnchor ) {
        final GIcon clone = clone();
        clone._iconAnchor = iconAnchor;
        return clone;
    }

    public GIcon iconSize( final GSize iconSize ) {
        final GIcon clone = clone();
        clone._iconSize = iconSize;
        return clone;
    }

    public GIcon infoShadowAnchor( final GPoint infoShadowAnchor ) {
        final GIcon clone = clone();
        clone._infoShadowAnchor = infoShadowAnchor;
        return clone;
    }

    public GIcon infoWindowAnchor( final GPoint infoWindowAnchor ) {
        final GIcon clone = clone();
        clone._infoWindowAnchor = infoWindowAnchor;
        return clone;
    }

    public void setIconAnchor( final GPoint iconAnchor ) {
        this._iconAnchor = iconAnchor;
    }

    public void setIconSize( final GSize iconSize ) {
        this._iconSize = iconSize;
    }

    public void setImage( final String image ) {
        this._image = image;
    }

    public void setImageMap( final List<Integer> imageMap ) {
        _imageMap = imageMap;
    }

    public void setInfoShadowAnchor( final GPoint infoShadowAnchor ) {
        this._infoShadowAnchor = infoShadowAnchor;
    }

    public void setInfoWindowAnchor( final GPoint infoWindowAnchor ) {
        this._infoWindowAnchor = infoWindowAnchor;
    }

    public void setShadow( final String shadow ) {
        this._shadow = shadow;
    }

    public void setShadowSize( final GSize shadowSize ) {
        this._shadowSize = shadowSize;
    }

    public GIcon shadowSize( final GSize shadowSize ) {
        final GIcon clone = clone();
        clone._shadowSize = shadowSize;
        return clone;
    }

    public void setSchema( final String schema ) {
        final String regex = "https?";
        _image.replaceFirst( regex, schema );
        if ( _shadow != null ) {
            _shadow.replaceFirst( regex, schema );
        }
    }

}