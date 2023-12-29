package com.github.palmerovicdev.architecturegenerator.action

import com.github.palmerovicdev.architecturegenerator.generator.Generator
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.command.WriteCommandAction

class ActionGenerateOnion : AnAction() {
    override fun actionPerformed(actionEvent: AnActionEvent) {
            generate(actionEvent.dataContext)
    }

    private fun generate(dataContext: DataContext) {
        val project = CommonDataKeys.PROJECT.getData(dataContext) ?: return
        val selected = PlatformDataKeys.VIRTUAL_FILE.getData(dataContext) ?: return

        val folder = if (selected.isDirectory) selected else selected.parent
        WriteCommandAction.runWriteCommandAction(project) {
            Generator.createFolder(
                project, folder,
                "presentation",
            )
            Generator.createFolder(
                project, folder,
                "persistence",
            )
            Generator.createFolder(
                project, folder,
                "infrastructure",
            )
            Generator.createFolder(
                project, folder,
                "application-services",
                "domain-services", "domain-models"
            )
        }
    }
}