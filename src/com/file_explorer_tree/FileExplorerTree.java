/**
 *
 */
package com.file_explorer_tree;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author Eno Gerguri <enogerguri@outlook.com>
 *
 */
public class FileExplorerTree extends JTree {

    /**
     *
     */
    private static final long serialVersionUID = 7686097321397124908L;
    /**
     * The root node to the FileExplorerTree.
     */
    private static DefaultMutableTreeNode treeRootNode;

    /**
     * @param rootDirectory The root directory for the file explorer tree to
     *                      display.
     *
     */
    public FileExplorerTree(final File rootDirectory) {
        super(createTreeModel(rootDirectory));
        this.setShowsRootHandles(true);
        this.setEditable(true);
        this.createChildNodes(rootDirectory, treeRootNode);

        this.addMouseListener(new FileExplorerMouseAdapter());
    }

    /**
     * @param rootDirectory The directory of the current layer of the file
     *                      explorer tree.
     * @param treeNode      The tree node of the current later of the file
     *                      directory on the tree.
     *
     * @Since 1.0
     */
    private void createChildNodes(
            final File rootDirectory,
            final DefaultMutableTreeNode treeNode
    ) {
        final File[] directoryFiles = rootDirectory.listFiles();
        if (directoryFiles == null) {
            return;
        }

        for (final File file : directoryFiles) {
            final FileMutableTreeNode childNode = new FileMutableTreeNode(file);
            treeNode.add(childNode);
            if (file.isDirectory()) {
                this.createChildNodes(file, childNode);
            }
        }
    }

    /**
     * @param rootDirectory The root directory for the file explorer tree to
     *                      display.
     *
     * @return Tree model of the file explorer.
     *
     * @Since 1.0
     */
    private static DefaultTreeModel createTreeModel(final File rootDirectory) {
        treeRootNode = new DefaultMutableTreeNode(new FileNode(rootDirectory));
        final DefaultTreeModel treeModel = new DefaultTreeModel(treeRootNode);
        return treeModel;
    }

}
