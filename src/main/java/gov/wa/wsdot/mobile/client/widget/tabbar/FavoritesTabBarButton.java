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

package gov.wa.wsdot.mobile.client.widget.tabbar;

import com.google.gwt.dom.client.Style.Unit;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import gov.wa.wsdot.mobile.client.widget.tabbar.resources.LocalTabBarImageHolder;

public class FavoritesTabBarButton extends TabBarButton {

	public FavoritesTabBarButton() {
		this(TabPanel.DEFAULT_APPEARANCE);
	}
	
	public FavoritesTabBarButton(TabBarAppearance appearance) {
        super(appearance, LocalTabBarImageHolder.get().star());
        if (!MGWT.getOsDetection().isAndroid()) {
            setText("Favorites");
        }
        text.getStyle().setTop(1, Unit.PX);
	}
	
}
