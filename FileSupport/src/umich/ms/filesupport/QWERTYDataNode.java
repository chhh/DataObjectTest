/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umich.ms.filesupport;

import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author dmitriya
 */
public class QWERTYDataNode extends DataNode {

    public QWERTYDataNode(DataObject dobj) {
        // NOTE: we're not providing our own lookup here, so in this case the
        // DataNode won't have it's own lookup, it will use CookieSet instead.
        super(dobj, Children.LEAF, Lookups.fixed(dobj, dobj.getPrimaryFile()));
    }

    @Override
    public String getHtmlDisplayName() {
        DataObject dobj = getDataObject();
        return dobj.getName() + "_modified_name";
    }
}
