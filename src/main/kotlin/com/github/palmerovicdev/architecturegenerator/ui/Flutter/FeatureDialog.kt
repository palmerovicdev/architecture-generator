package com.github.palmerovicdev.architecturegenerator.ui.Flutter
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.VerticalFlowLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JLabel
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
        if (contentPanel == null) {
            // Initialize contentPanel
            contentPanel = JPanel()
            contentPanel?.setSize(100, 150)
            contentPanel?.layout = VerticalFlowLayout()
            contentPanel?.add(JLabel("Feature Name:"))
            nameTextField = JTextField()
            contentPanel?.add(nameTextField)
            splitDataSource = JCheckBox("Split data source?")
            contentPanel?.add(splitDataSource)
        }

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