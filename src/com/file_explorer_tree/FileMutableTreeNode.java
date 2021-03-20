/**
 *
 */
package com.file_explorer_tree;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Eno Gerguri <enogerguri@outlook.com>
 *
 */
public class FileMutableTreeNode extends DefaultMutableTreeNode {

    /**
     *
     */
    private static final long serialVersionUID = 7727746466788778904L;

    /**
     * @param fileForNode The file used for the file tree node.
     */
    public FileMutableTreeNode(final File fileForNode) {
        super(getFileMutableTreeNodeArgs(fileForNode));
    }

    /**
     * @param fileForNode The file used for the file tree node.
     *
     * @return The arguments for the file tree node
     *         in the form of <File fileNode, boolean allowsChildren>
     *
     * @Since 1.0
     */
    public static Object[]
            getFileMutableTreeNodeArgs(final File fileForNode) {
        final FileNode fileNode = new FileNode(fileForNode);
        final boolean allowsChildren = fileForNode.isDirectory();
        final Object[] fileArgs = {fileNode, Boolean.valueOf(allowsChildren)};
        return fileArgs;
    }

}
