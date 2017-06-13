import java.awt.*
import java.awt.geom.Path2D

/**
 * Created by michal on 04.06.17.
 */

class SierpinskiTriangle : SierpinskiFractals()
{
    private fun drawTriangle(g: Graphics2D, x: Int, y: Int, s: Int)
    {
        var size = s
        var x1 = x
        var y1 = y
        if (s <= limit)
        {
            val p = Path2D.Double()

            p.moveTo(x1 * 1.0, y1 * 1.0)
            p.lineTo(x1 + size / 2.0, y1 + size * 1.0)
            p.lineTo(x1- size / 2.0, y1 + size * 1.0)
            g.fill(p)

        }else{

            size /= 2
            drawTriangle(g, x1, y1, size)
            drawTriangle(g, x1 + size / 2, y1 + size, size)
            drawTriangle(g, x1 - size / 2, y1 + size, size)
        }
    }

    override fun paintComponent(g: Graphics)
    {
        super.paintComponent(g)
        val g1 = g as Graphics2D
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g1.translate(margin, margin)
        drawTriangle(g1, dimension / 2, 0, dimension)
    }
}
