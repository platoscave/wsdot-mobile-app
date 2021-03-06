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

package gov.wa.wsdot.mobile.client.activities.socialmedia.twitter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.googlecode.mgwt.ui.client.widget.list.celllist.Cell;
import gov.wa.wsdot.mobile.client.css.AppBundle;

public abstract class TwitterCell<T> implements Cell<T> {

	private static Template TEMPLATE = GWT.create(Template.class);

	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div  role=\"button\" tabindex=\"0\"> <div class=\"{0}\"> <div><img class=\"{1}\" src=\"{2}\" onload=\"refreshPanel();\"></div></div> <div class=\"{3}\"><div class=\"{4}\"></div><div class=\"{5}\"><div>{6}</div><div>{7}</div><div>{8}</div></div></div></div>")
		SafeHtml content(String class1, String class2, String mediaImage, String class3, String cellImage, String class4, String cellContents, SafeHtml description, String lastUpdated);
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, final T model) {
		SafeHtml content = TEMPLATE.content(
				AppBundle.INSTANCE.css().cameraImage(),
				AppBundle.INSTANCE.css().img(),
				SafeHtmlUtils.htmlEscape(getMediaUrl(model)),
				AppBundle.INSTANCE.css().cellImage(),
				getDisplayImage(model),
				AppBundle.INSTANCE.css().cellDetails(),
				SafeHtmlUtils.htmlEscape(getDisplayString(model)),
				SafeHtmlUtils.fromTrustedString(getDisplayDescription(model)),
				SafeHtmlUtils.htmlEscape(getDisplayLastUpdated(model)));

		SafeHtml contentNoCameraImage = TEMPLATE.content(
				AppBundle.INSTANCE.css().cameraImageHidden(),
				AppBundle.INSTANCE.css().img(),
				SafeHtmlUtils.htmlEscape(getMediaUrl(model)),
				AppBundle.INSTANCE.css().cellImage(),
				getDisplayImage(model),
				AppBundle.INSTANCE.css().cellDetails(),
				SafeHtmlUtils.htmlEscape(getDisplayString(model)),
				SafeHtmlUtils.fromTrustedString(getDisplayDescription(model)),
				SafeHtmlUtils.htmlEscape(getDisplayLastUpdated(model)));
		
		if (getMediaUrl(model) != "") {
			safeHtmlBuilder.append(content);
		} else {
			safeHtmlBuilder.append(contentNoCameraImage);
		}
	}

	public abstract String getMediaUrl(T model);
	
	public abstract String getDisplayString(T model);
	
	public abstract String getDisplayImage(T model);
	
	public abstract String getDisplayDescription(T model);
	
	public abstract String getDisplayLastUpdated(T model);

	@Override
	public boolean canBeSelected(T model) {
		return false;
	}

}
