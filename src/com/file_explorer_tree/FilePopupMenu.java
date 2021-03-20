/**
 *
 */
package com.file_explorer_tree;

import javax.swing.JPopupMenu;
import javax.swing.JTree;

/**
 * @author Eno Gerguri <enogerguri@outlook.com>
 *
 */
public class FilePopupMenu extends JPopupMenu {

    /**
     *
     */
    private static final long serialVersionUID = 5051040621133203815L;

    /**
     * @param tree     The file explorer tree.
     * @param treeNode The node of the explorer that was clicked.
     */
    public FilePopupMenu(final JTree tree, final FileMutableTreeNode treeNode) {
        super();

        final FileNode fileNode = (FileNode) treeNode.getUserObject();
    }
}
