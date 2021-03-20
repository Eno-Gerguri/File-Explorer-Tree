/**
 *
 */
package com.file_explorer_tree;

import java.io.File;

/**
 * @author Eno Gerguri <enogerguri@outlook.com>
 *
 */
public class FileNode {

    /**
     * The file of the node
     */
    private final File file;

    /**
     * @param file The file of the node to store
     */
    public FileNode(final File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        final String name = this.file.getName();
        if (name.equals("")) { //$NON-NLS-1$
            return this.file.getAbsolutePath();
        }

        return name;
    }

    /**
     * @return The file
     *
     * @Since 1.0
     */
    public File getFile() {
        return this.file;
    }

}
