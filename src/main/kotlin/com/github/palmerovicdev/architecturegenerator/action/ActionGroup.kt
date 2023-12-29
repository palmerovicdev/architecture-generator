package com.github.palmerovicdev.architecturegenerator.action
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DefaultActionGroup


class ActionGroup : DefaultActionGroup() {
    override fun update(event: AnActionEvent) {
        val psi = event.getData(CommonDataKeys.PSI_ELEMENT)
        event.presentation.isVisible = psi != null
        event.presentation.icon = AllIcons.Actions.NewFolder
    }
}