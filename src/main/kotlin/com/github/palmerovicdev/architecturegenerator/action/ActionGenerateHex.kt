package com.github.palmerovicdev.architecturegenerator.action

import com.github.palmerovicdev.architecturegenerator.generator.Generator
import com.github.palmerovicdev.architecturegenerator.ui.Flutter.FeatureDialog
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.command.WriteCommandAction

class ActionGenerateHex : AnAction() {
    override fun actionPerformed(actionEvent: AnActionEvent) {
        val dialog = FeatureDialog(actionEvent.project)
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
                "infrastructure",
                "adapter.input", "adapter.output", "repository", "entity", "mapper"
            )
            Generator.createFolder(
                project, folder,
                "application",
                "port.input", "port.output", "service"
            )
            Generator.createFolder(
                project, folder,
                "domain",
                "model"
            )
            Generator.createFolder(
                project, folder,
                "common",
                "enum", "interface"
            )
        }
    }
}