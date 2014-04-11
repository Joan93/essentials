/*
 * Copyright 2013 Hippo B.V. (http://www.onehippo.com)
 */

package org.onehippo.cms7.essentials.components.info;

import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

/**
 * @version "$Id: EssentialsDocumentListComponentInfo.java 164011 2013-05-11 14:05:01Z mmilicevic $"
 */
/*@FieldGroupList({
        @FieldGroup(
                titleKey = "group.constraints",
                value = {"docType", "tags"}
        ),
        @FieldGroup(
                titleKey = "group.display",
                value = {"pageSize"}
        )
})*/
public interface EssentialsDocumentListComponentInfo extends EssentialsPageable, EssentialsSortable {


    @Parameter(name = "path", required = false, displayName = "Documents path")
    @JcrPath(
            isRelative = true,
            pickerConfiguration = "cms-pickers/documents",
            pickerSelectableNodeTypes = {"hippostd:folder"},
            pickerInitialPath = "/content/documents"
    )
    String getPath();


    @Parameter(name = "includeSubtypes", required = false, displayName = "Include document subtypes")
    Boolean getIncludeSubtypes();


    @Parameter(name = "documentTypes", required = true, displayName = "Document types (comma separated)")
    String getDocumentTypes();



}
