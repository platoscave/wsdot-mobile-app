/*
 * Copyright (c) 2014 Washington State Department of Transportation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package gov.wa.wsdot.mobile.client.activities.ferries.vesselwatch;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.gwtphonegap.client.geolocation.Position;
import gov.wa.wsdot.mobile.shared.CameraItem;
import gov.wa.wsdot.mobile.shared.VesselWatchItem;

import java.util.List;

public interface VesselWatchMapView extends IsWidget {
	
	public void setPresenter(Presenter presenter);

	void addMapMarker(Position position);

	public interface Presenter {
		
		public void onBackButtonPressed();
		
		public void onCameraButtonPressed(boolean showCameras);
		
		public void onGoToLocationButtonPressed();
		
		public void onCameraSelected(int cameraId);
		
		public void onFerrySelected(VesselWatchItem vessel);
		
		public void onLocateButtonPressed();
		
		public void onMapIsIdle();
		
	}
	
	public void showProgressIndicator();

	public void hideProgressIndicator();
	
	public LatLngBounds getViewportBounds();
	
	public MapWidget getMapWidget();
	
	public void hideCameras();
	
	public void showCameras();
	
	public void deleteCameras();
	
	public void hideFerries();
	
	public void showFerries();
	
	public void deleteFerries();
	
	public void drawCameras(List<CameraItem> cameras);
	
	public void drawFerries(List<VesselWatchItem> vessels);
	
	public void setTitle(String title);

	public void setMapLocation(double latitude, double longitude, int zoom);
	
	public void setMapLocation();
	
}