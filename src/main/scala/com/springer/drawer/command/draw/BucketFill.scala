package com.springer.drawer.command.draw

case class BucketFill(x: Int,
                      y: Int,
                      color: Char) extends DrawCommand {

  override def draw(canvas: Canvas): Unit = {
    fill(x, y, canvas, color)
  }

  private def renderIfValid(x: Int, y: Int, canvas: Canvas, oldColor: Char)(thunk: => Unit): Unit = {
    if (!isInvalid(x, y, canvas, oldColor)) {
      thunk
    }
  }

  private def isInvalid(x: Int, y: Int, canvas: Canvas, oldColor: Char) = {
    x < 0 ||
      y < 0 ||
      x >= canvas.canvas.length ||
      y >= canvas.canvas(x).length ||
      oldColor != canvas.canvas(x)(y)
  }

  private def fill(x: Int, y: Int, canvas: Canvas, newColor: Char, oldColor: Char = 0) {
    renderIfValid(x, y, canvas, oldColor) {
      canvas.canvas(x)(y) = newColor

      fill(x + 1, y, canvas, newColor, oldColor)
      fill(x - 1, y, canvas, newColor, oldColor)
      fill(x, y + 1, canvas, newColor, oldColor)
      fill(x, y - 1, canvas, newColor, oldColor)
    }
  }

  override def isValidForCanvas(canvas: Canvas): Boolean = {
    x < canvas.width &&
      y < canvas.height
  }
}
