/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.filesupport;

import java.io.IOException;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@Messages({
    "LBL_QWERTY_LOADER=Files of QWERTY"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_QWERTY_LOADER",
        mimeType = "application/x-qwerty",
        extension = {"qwerty"}
)
@DataObject.Registration(
        mimeType = "application/x-qwerty",
        iconBase = "umich/ms/filesupport/spectrum_viewer_icon.gif",
        displayName = "#LBL_QWERTY_LOADER",
        position = 300
)
@ActionReferences({

    @ActionReference(
            path = "Loaders/application/x-qwerty/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    ),
    @ActionReference(
            path = "Loaders/application/x-qwerty/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 500,
            separatorAfter = 550
    ),
    @ActionReference(
            path = "Loaders/application/x-qwerty/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class QWERTYDataObject extends MultiDataObject {

    public QWERTYDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("application/x-qwerty", true);
    }

    @Override
    protected Node createNodeDelegate() {
        return new QWERTYDataNode(this);
    }



    @Override
    protected int associateLookup() {
        return 1;
    }

    @MultiViewElement.Registration(
            displayName = "#LBL_QWERTY_EDITOR",
            iconBase = "umich/ms/filesupport/spectrum_viewer_icon.gif",
            mimeType = "application/x-qwerty",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "QWERTY",
            position = 1000
    )
    @Messages("LBL_QWERTY_EDITOR=Source")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new MultiViewEditorElement(lkp);
    }

}
