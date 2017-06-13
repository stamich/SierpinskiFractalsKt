import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.Timer

/**
 * Created by michal on 29.05.17.
 */

open class SierpinskiFractals : JPanel()
{
    protected val dimension = 600
    protected val margin = 20
    protected var limit = dimension

    init
    {
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
    val input = Scanner(System.`in`)

    println("If you want to see Sierpinski's Triangle choice: 1.")
    println("If you want to see Sierpinski's Carpet choice: 2.")
    println("If you want to see both of Sierpinski's fractals choice: 3.")

    val choice = input.nextInt()

    when(choice)
    {
        1 -> SwingUtilities.invokeLater {
            val fr = JFrame()
            fr.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            fr.title = "Sierpinski's triangle"
            fr.isResizable = false
            fr.add(SierpinskiTriangle(), BorderLayout.CENTER)
            fr.pack()
            fr.setLocationRelativeTo(null)
            fr.isVisible = true
        }

        2 -> SwingUtilities.invokeLater {
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
}