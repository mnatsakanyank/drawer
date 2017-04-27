package com.springer.drawer.command

case class Line(x1: Int,
                y1: Int,
                x2: Int,
                y2: Int,
                clr: Char = 'x') extends Command {

  override def draw(canvas: Canvas): Unit = {
    for (y <- 0 to canvas.canvas(0).length) {
      for (x <- canvas.canvas.indices) {
        if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
          canvas.canvas(x)(y) = clr
      }
    }
  }
}