package com.github.palmerovicdev.architecturegenerator.generator
import com.github.palmerovicdev.architecturegenerator.ui.Notifier
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import java.io.IOException
interface Generator {
    companion object {
        fun createFolder(
            project: Project,
            folder: VirtualFile,
            parent: String,
            vararg children: String
        ): Map<String, VirtualFile>? {
            try {
                for (child in folder.children) {
                    if (child.name == parent) {
                        Notifier.warning(project, "Directory [$parent] already exists")
                        return null
                    }
                }
                val mapOfFolder = mutableMapOf<String, VirtualFile>()
                mapOfFolder[parent] = folder.createChildDirectory(folder, parent)
                for (child in children) {
                    mapOfFolder[child] =
                        mapOfFolder[parent]?.createChildDirectory(mapOfFolder[parent], child) ?: throw IOException()
                }
                return mapOfFolder
            } catch (e: IOException) {
                Notifier.warning(project, "Couldn't create $parent directory")
                e.printStackTrace()
                return null
            }
        }
    }
}