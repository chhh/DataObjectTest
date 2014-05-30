/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package umich.ms.filesupport;

import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author dmitriya
 */
public class QWERTYDataNode extends DataNode {

    public QWERTYDataNode(DataObject dobj) {
        this(dobj,new InstanceContent());
    }

    private QWERTYDataNode(DataObject dobj, InstanceContent ic) {
        super(dobj, Children.LEAF, new ProxyLookup(dobj.getLookup(), new AbstractLookup(ic)));
        ic.add("hello world");
    }

    @Override
    public String getHtmlDisplayName() {
        DataObject dobj = getDataObject();
        return dobj.getName() + "_modified_name";
    }

}

