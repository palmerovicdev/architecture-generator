package com.github.palmerovicdev.architecturegenerator.ui
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project

interface Notifier {
    companion object {
        fun warning(project: Project?, content: String) =
            Notifications.Bus.notify(
                Notification(
                    "CleanArchitectureGenerator",
                    "Architecture Generator Warning",
                    content,
                    NotificationType.WARNING
                ), project
            )

        fun error(project: Project?, content: String) =
            Notifications.Bus.notify(
                Notification(
                    "CleanArchitectureGenerator",
                    "Architecture Generator Error",
                    content,
                    NotificationType.ERROR
                ), project
            )
    }
}