/**
 *
 */
package com.file_explorer_tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/**
 * @author Eno Gerguri <enogerguri@outlook.com>
 *
 */
public class FileExplorerMouseAdapter extends MouseAdapter {

    /**
     * @param event The mouse event that is a popup trigger.
     *
     * @Since 1.0
     */
    private void popupEvent(final MouseEvent event) {
        final int nodeXPosition = event.getX();
        final int nodeYPosition = event.getY();
        final JTree fileExplorerTree = (JTree) event.getSource();
        final TreePath pathToPopupTriggerNode = fileExplorerTree
                .getPathForLocation(nodeXPosition, nodeYPosition);
        if (pathToPopupTriggerNode == null) {
            return;
        }

        fileExplorerTree.setSelectionPath(pathToPopupTriggerNode);

        final FileNode popupTriggerNode =
                (FileNode) ((FileMutableTreeNode) pathToPopupTriggerNode
                        .getLastPathComponent()).getUserObject();

        final File popupTriggerNodeFile = popupTriggerNode.getFile();

        final JPopupMenu popupMenu =
                popupTriggerNodeFile.isDirectory() ?
                        new DirectoryPopupMenu(popupTriggerNode) :
                        new FilePopupMenu(
                                fileExplorerTree,
                                (FileMutableTreeNode) pathToPopupTriggerNode
                                        .getLastPathComponent()
                        );
        popupMenu.show(fileExplorerTree, nodeXPosition, nodeYPosition);
    }

    @Override
    public void mousePressed(final MouseEvent event) {
        if (event.isPopupTrigger()) {
            this.popupEvent(event);
        }
    }

    @Override
    public void mouseReleased(final MouseEvent event) {
        if (event.isPopupTrigger()) {
            this.popupEvent(event);
        }
    }

}
