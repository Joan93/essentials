/*
 * Copyright 2013 Hippo B.V. (http://www.onehippo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onehippo.cms7.essentials.components;

import java.util.ArrayList;
import java.util.List;

import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.onehippo.cms7.essentials.components.info.EssentialsCarouselComponentInfo;
import org.onehippo.cms7.essentials.components.paging.DefaultPagination;

/**
 * HST component used for rendering of Carousel items
 *
 * @version "$Id$"
 */
@ParametersInfo(type = EssentialsCarouselComponentInfo.class)
public class EssentialsCarouselComponent extends CommonComponent {


    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) {
        final EssentialsCarouselComponentInfo componentInfo = getComponentParametersInfo(request);
        final List<HippoDocument> items = getCarouselItems(componentInfo);
        request.setAttribute(REQUEST_ATTR_PAGEABLE, new DefaultPagination<>(items));
        setCarouselOptions(request, componentInfo);
    }

    /**
     * Sets options like effects, speed, etc. of selected carousel component
     *
     * @param request       HstRequest instance
     * @param componentInfo Carousel component annotation
     */
    public void setCarouselOptions(final HstRequest request, final EssentialsCarouselComponentInfo componentInfo) {
        request.setAttribute("interval", componentInfo.getInterval());
        request.setAttribute("cycle", componentInfo.getCycle());
        request.setAttribute("pause", componentInfo.getPause());
        request.setAttribute("showNavigation", componentInfo.getShowNavigation());
        request.setAttribute("carouselHeight", componentInfo.getCarouselHeight());
        request.setAttribute("carouselWidth", componentInfo.getCarouselWidth());
        request.setAttribute("carouselBackgroundColor", componentInfo.getCarouselBackgroundColor());
    }

    /**
     * Populates a list of carousel documents
     *
     * @param componentInfo Carousel component annotation
     * @return list of documents to be populated
     */
    public List<HippoDocument> getCarouselItems(final EssentialsCarouselComponentInfo componentInfo) {
        final List<HippoDocument> beans = new ArrayList<>();
        addBeanForPath(componentInfo.getCarouselItem1(), beans);
        addBeanForPath(componentInfo.getCarouselItem2(), beans);
        addBeanForPath(componentInfo.getCarouselItem3(), beans);
        addBeanForPath(componentInfo.getCarouselItem4(), beans);
        addBeanForPath(componentInfo.getCarouselItem5(), beans);
        addBeanForPath(componentInfo.getCarouselItem6(), beans);
        return beans;
    }


}
