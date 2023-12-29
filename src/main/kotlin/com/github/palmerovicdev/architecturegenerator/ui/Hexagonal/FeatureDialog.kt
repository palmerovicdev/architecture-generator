package com.github.palmerovicdev.architecturegenerator.ui.Hexagonal
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.VerticalFlowLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class FeatureDialog(project: Project?) :
    DialogWrapper(project) {
    private var contentPanel: JPanel? = null
    private var feature: JTextField? = null

    fun getName(): String? = feature?.text

    override fun createCenterPanel(): JComponent? {
        if (contentPanel == null) {
            // Initialize contentPanel
            contentPanel = JPanel()
            contentPanel?.setSize(100, 150)
            contentPanel?.layout = VerticalFlowLayout()
            contentPanel?.add(JLabel("Feature Name:"))
            feature = JTextField()
            contentPanel?.add(feature)
        }
        return contentPanel
    }


    override fun getPreferredFocusedComponent(): JComponent? {
        return feature
    }

    init {
        init()
        title = "Clean-Architecture Generator"
    }
}