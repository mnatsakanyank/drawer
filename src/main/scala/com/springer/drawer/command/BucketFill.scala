package com.springer.drawer.command

case class BucketFill(x: Int,
                      y: Int,
                      color: Char) extends Command {

  override def draw(canvas: Canvas): Unit = {
    fill(x, y, canvas, color)
  }

  def fill(x: Int, y: Int, canvas: Canvas, newColor: Char, oldColor: Char = 0) {
    if (x < 0) return
    if (y < 0) return
    if (x >= canvas.canvas.length) return
    if (y >= canvas.canvas(x).length) return
    if (oldColor != canvas.canvas(x)(y)) return

    canvas.canvas(x)(y) = newColor

    fill(x + 1, y, canvas, newColor, oldColor)
    fill(x - 1, y, canvas, newColor, oldColor)
    fill(x, y + 1, canvas, newColor, oldColor)
    fill(x, y - 1, canvas, newColor, oldColor)
  }
}
