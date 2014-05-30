/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umich.ms.filesupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "umich.ms.filesupport.SomeAction"
)
@ActionRegistration(
        displayName = "#CTL_SomeAction"
)
@ActionReference(path = "Menu/File", position = 0)
@Messages("CTL_SomeAction=Some")
public final class SomeAction implements ActionListener {

    private final String context;

    public SomeAction(String context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        JOptionPane.showMessageDialog(null, context);
    }
}
