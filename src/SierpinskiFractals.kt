import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.Timer

/**
 * Created by michal on 10.06.17.
 */

open class SierpinskiFractals : JPanel()
{
    protected val dimension = 600
    protected val margin = 20
    protected var limit = dimension

    init {
        val size = dimension + 2 * margin
        preferredSize = Dimension(size, size)
        background = Color.black
        foreground = Color.orange
        Timer(1000) {
            limit /= 3
            if (limit <= 3) limit = dimension
            repaint()
        }.start()
    }
}

fun main(args: Array<String>)
{
    SwingUtilities.invokeLater {
        val fr = JFrame()
        fr.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        fr.title = "Sierpinski's Fractals"
        fr.isResizable = false
        fr.add(SierpinskiCarpet(), BorderLayout.CENTER)
        fr.pack()
        fr.setLocationRelativeTo(null)
        fr.isVisible = true
    }
}