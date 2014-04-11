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

package org.onehippo.cms7.essentials.tools.rest;

import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.junit.Test;
import org.onehippo.cms7.essentials.BaseRepositoryTest;
import org.onehippo.cms7.essentials.TestPluginContext;
import org.onehippo.cms7.essentials.dashboard.rest.NodeRestful;
import org.onehippo.cms7.essentials.dashboard.utils.EssentialConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * @version "$Id$"
 */

public class FSUtilsTest extends BaseRepositoryTest {

    private static Logger log = LoggerFactory.getLogger(FSUtilsTest.class);


    @Test
    public void testWriting() throws Exception {
        final TestPluginContext context = (TestPluginContext) getContext();


        Session session = context.createSession();
        // create hst nodes
        createHstRootConfig();
        String path = "/hst:hst/hst:configurations/" + getContext().getProjectNamespacePrefix() + "/hst:templates";
        final Node templateNode = session.getNode(path);
        final Node myFirstNode = templateNode.addNode("myFirstNode", "hst:template");
        myFirstNode.setProperty("hst:script", "<#FREEMARKER>");
        final Node mySecondNode = templateNode.addNode("mySecondNode", "hst:template");
        mySecondNode.setProperty("hst:script", "<#FREEMARKER>");
        log.info("templateNode {}", templateNode);
        session.save();
        final NodeRestful scriptNodes = FSUtils.getScriptNodes(context);
        assertEquals(2, scriptNodes.getNodes().size());
        final String freemarkerPath = (String) context.getTestContextPlaceholders().get(EssentialConst.PLACEHOLDER_SITE_FREEMARKER_ROOT);

        final Map<String, String> map = FSUtils.writeFreemarkerFiles(context, freemarkerPath, scriptNodes);
        assertEquals(2, map.size());

        session.logout();
    }
}
