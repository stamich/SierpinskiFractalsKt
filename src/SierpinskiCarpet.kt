import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints

/**
 * Created by michal on 02.06.17.
 */

class SierpinskiCarpet : SierpinskiFractals()
{
    private fun drawCarpet(g: Graphics2D, x: Int, y: Int, s: Int) {
        var size = s
        if (s < limit) return
        size /= 3
        for (i in 0 until 9) {
            if (i == 4) {
                g.fillRect(x + size, y + size, size, size)
            }
            else {
                drawCarpet(g, x + (i % 3) * size, y + (i / 3) * size, size)
            }
        }
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g1 = g as Graphics2D
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g1.translate(margin, margin)
        drawCarpet(g1, 0, 0, dimension)
    }
}