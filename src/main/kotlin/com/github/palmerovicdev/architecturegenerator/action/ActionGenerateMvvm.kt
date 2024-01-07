package com.github.palmerovicdev.architecturegenerator.action

import com.github.palmerovicdev.architecturegenerator.generator.Generator
import com.github.palmerovicdev.architecturegenerator.ui.Hexagonal.FeatureDialog
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.command.WriteCommandAction

class ActionGenerateMvvm : AnAction() {
    override fun actionPerformed(actionEvent: AnActionEvent) {
        val dialog = FeatureDialog(actionEvent.project)
        dialog.setSize(100, 50)
        if (dialog.showAndGet()) {
            generate(actionEvent.dataContext, dialog.getName())
        }
    }

    private fun generate(dataContext: DataContext, root: String?) {
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
            Generator.createFolder(
                project, folder,
                "model",
                    "data", "interface", "repository"
            )
            Generator.createFolder(
                project, folder,
                "view",
                    "adapter"
            )
            Generator.createFolder(
                project, folder,
                "viewModel"
            )
        }
    }
}