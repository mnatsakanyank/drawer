package com.springer.drawer.command.draw

case class Line(x1: Int,
                y1: Int,
                x2: Int,
                y2: Int,
                color: Char = 'x') extends DrawCommand {

  override def draw(canvas: Canvas): Unit = {
    for (y <- y1 to y2;
         x <- x1 to x2
         if x >= x1 && x <= x2 && y >= y1 && y <= y2)
      yield canvas.canvas(x)(y) = color
  }
}
