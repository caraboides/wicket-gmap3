package wicket.contrib.gmap3.api;

import org.apache.wicket.Request;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.TextField;

import wicket.contrib.gmap3.GMapHeaderContributor;

/**
 */
public abstract class GClientGeocoder extends AjaxEventBehavior {

    private static final long serialVersionUID = 1L;

    // the TextField providing the requested address.
    private final TextField<?> _addressField;

    private final GMapHeaderContributor headerContrib;

    /**
     * Construct.
     * 
     * @param event
     */
    public GClientGeocoder( String event, TextField<?> addressField ) {
        super( event );

        this._addressField = addressField;
        this._addressField.setOutputMarkupId( true );

        this.headerContrib = new GMapHeaderContributor();
    }

    @Override
    public void renderHead( IHeaderResponse response ) {
        super.renderHead( response );
        headerContrib.renderHead( response );
    }

    @Override
    protected void onEvent( AjaxRequestTarget target ) {
        Request request = RequestCycle.get().getRequest();

        onGeoCode( target, Integer.parseInt( request.getParameter( "status" ) ), request.getParameter( "address" ),
                LatLng.parse( request.getParameter( "point" ) ) );
    }

    public abstract void onGeoCode( AjaxRequestTarget target, int status, String address, LatLng latLng );

    @Override
    protected CharSequence generateCallbackScript( CharSequence partialCall ) {
        return "Wicket.geocoder.getLatLng('" + getCallbackUrl() + "', '" + _addressField.getMarkupId() + "');" + "return false;";
    }
}
