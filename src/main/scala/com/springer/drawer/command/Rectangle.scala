package com.springer.drawer.command

case class Rectangle(x1: Int,
                     y1: Int,
                     x2: Int,
                     y2: Int,
                     color: Char ='x') extends Command {

  override def draw(canvas: Canvas): Unit = {
    for (y <- y1 to y2) {
      for (x <- x1 to x2) {
        if ((x == x1 || x == x2) && y1 <= y && y <= y2)
          canvas.canvas(x)(y) = color
        if ((y == y1 || y == y2) && x1 <= x && x <= x2)
          canvas.canvas(x)(y) = color
      }
    }
  }
}
