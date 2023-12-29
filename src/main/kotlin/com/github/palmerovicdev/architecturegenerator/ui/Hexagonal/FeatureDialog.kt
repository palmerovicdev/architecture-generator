package com.github.palmerovicdev.architecturegenerator.ui.Hexagonal
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class FeatureDialog(project: Project?) :
    DialogWrapper(project) {
    private var contentPanel: JPanel? = null
    private var nameTextField: JTextField? = null
    private var splitDataSource: JCheckBox? = null

    fun getName(): String? = nameTextField?.text
    fun splitSource(): Boolean? = splitDataSource?.isSelected

    override fun createCenterPanel(): JComponent? {
        return contentPanel
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return nameTextField
    }

    init {
        init()
        title = "Clean-Architecture Generator"
    }
}