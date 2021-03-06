/*
 * Copyright 2014 Hippo B.V. (http://www.onehippo.com)
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

package org.onehippo.cms7.essentials.dashboard.event;

/**
 * @version "$Id$"
 */
public class DisplayEvent extends MessageEvent {

    private static final long serialVersionUID = 1L;

    /**
     * Flag that indicates event is selected for certain task (e.g. rollback)
     */
    private boolean selected;

    private DisplayType displayType = DisplayType.P;

    /**
     * Flag which indicates item will be placed as first in the queue
     */
    private boolean addAsFirst;

    public DisplayEvent(final String message, final DisplayType type, final boolean addFirst) {
        this(message, type);
        this.addAsFirst = addFirst;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }

    public DisplayEvent(final String message) {
        super(message);
    }

    public DisplayEvent(final String message, final DisplayType displayType) {
        super(message);
        this.displayType = displayType;
    }

    public DisplayEvent(final String message, final boolean addAsFirst) {
        super(message);
        this.addAsFirst = addAsFirst;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(final DisplayType displayType) {
        this.displayType = displayType;
    }

    public boolean isAddAsFirst() {
        return addAsFirst;
    }

    public enum DisplayType {
        A, P, PRE, DIV, H1, H2, H3, H4, H5, STRONG, BR
    }

}
