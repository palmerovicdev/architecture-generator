package com.github.palmerovicdev.architecturegenerator.action

import com.github.palmerovicdev.architecturegenerator.generator.Generator
import com.github.palmerovicdev.architecturegenerator.ui.Flutter.FeatureDialog
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.vfs.VirtualFile

class ActionGenerateFlutter : AnAction() {
    override fun actionPerformed(actionEvent: AnActionEvent) {
        val dialog = FeatureDialog(actionEvent.project)
        if (dialog.showAndGet()) {
            generate(actionEvent.dataContext, dialog.getName(), dialog.splitSource())
        }
    }

    private fun generate(dataContext: DataContext, root: String?, splitSource: Boolean?) {
        val project = CommonDataKeys.PROJECT.getData(dataContext) ?: return
        val selected = PlatformDataKeys.VIRTUAL_FILE.getData(dataContext) ?: return

        var folder = if (selected.isDirectory) selected else selected.parent
        WriteCommandAction.runWriteCommandAction(project) {
            if (!root.isNullOrBlank()) {
                val result = Generator.createFolder(
                    project, folder, root
                ) ?: return@runWriteCommandAction
                folder = result[root]
            }
            if (splitSource != null && splitSource) {
                val mapOrFalse = Generator.createFolder(
                    project, folder,
                    "data",
                    "repositories"
                ) ?: return@runWriteCommandAction
                mapOrFalse["data"]?.let { data: VirtualFile ->
                    Generator.createFolder(
                        project, data,
                        "local",
                        "models", "data_sources"
                    )
                    Generator.createFolder(
                        project, data,
                        "remote",
                        "models", "data_sources"
                    )
                }
            } else {
                Generator.createFolder(
                    project, folder,
                    "data",
                    "repositories", "data_sources", "models"
                )
            }
            Generator.createFolder(
                project, folder,
                "domain",
                "repositories", "use_cases", "entities"
            )
            Generator.createFolder(
                project, folder,
                "presentation",
                "manager", "pages", "widgets"
            )
        }
    }
}