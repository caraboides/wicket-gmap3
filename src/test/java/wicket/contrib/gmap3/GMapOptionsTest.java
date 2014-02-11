/*
 * (c) Copyright 2014 freiheit.com technologies GmbH
 *
 * Created on Feb 11, 2014 by Axel Mannhardt (axel.mannhardt@freiheit.com)
 *
 * This file contains unpublished, proprietary trade secret information of
 * freiheit.com technologies GmbH. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * freiheit.com technologies GmbH.
 */
package wicket.contrib.gmap3;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Axel Mannhardt (axel.mannhardt@freiheit.com) (initial creation)
 */
public class GMapOptionsTest {

    @Test
    public void testMapOptions() {
        assertContains( new GMapOptions(), "draggable", "true" );
        assertContains( new GMapOptions().setStreetViewControl( false ), "streetViewControl", "false" );
    }

    @Test
    public void testTypeControlOptions() {
        assertContains( new GMapOptions(), "mapTypeControlOptions",
                "({mapTypeIds:[google.maps.MapTypeId.ROADMAP,google.maps.MapTypeId.SATELLITE]" );
    }

    private static void assertContains( GMapOptions options, String key, String value ) {
        Assert.assertTrue( options.toJsProperties().contains( key + ":" + value ) );
    }

}
