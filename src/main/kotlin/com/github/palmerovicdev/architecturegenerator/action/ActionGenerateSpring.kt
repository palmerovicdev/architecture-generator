package com.github.palmerovicdev.architecturegenerator.action

import com.github.palmerovicdev.architecturegenerator.generator.Generator
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.command.WriteCommandAction

class ActionGenerateSpring : AnAction() {
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
                "config",
            )
            Generator.createFolder(
                project, folder,
                "middelware",
            )
            Generator.createFolder(
                project, folder,
                "controller",
            )
            Generator.createFolder(
                project, folder,
                "repository",
            )
            Generator.createFolder(
                project, folder,
                "model",
                "entity", "request", "response"
            )
            Generator.createFolder(
                project, folder,
                "service",
            )
            Generator.createFolder(
                project, folder,
                "util",
            )
            Generator.createFolder(
                project, folder,
                "core",
                "enum", "common"
            )
        }
    }
}