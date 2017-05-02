package com.springer.drawer.command.draw

import scala.collection.mutable.ListBuffer

case class Canvas(width: Int,
                  height: Int,
                  commands: ListBuffer[DrawCommand],
                  c1: Char = '-',
                  c2: Char = '|',
                  emptyChar: Char = ' ') extends DrawCommand {

  val canvas: Array[Array[Char]] = Array.ofDim[Char](width + 2, height + 2)

  override def draw(canvas: Canvas): Unit = {
    drawCanvas(canvas)
    drawCommands(canvas)
    printCanvas(canvas)
  }

  private def drawCommands(canvas: Canvas) = {
    for (cmd <- commands) {
      cmd.draw(canvas)
    }
  }

  private def drawCanvas(canvas: Canvas) = {
    for (y <- 0 to canvas.canvas(0).length;
         x <- canvas.canvas.indices) {
      if ((y == 0 || y == height) && x <= width) {
        canvas.canvas(x)(y) = c1
      }
      else if ((x == 0 || x == width) && y <= height) {
        canvas.canvas(x)(y) = c2
      }
    }
  }

  private def printCanvas(canvas: Canvas) = {
    for (y <- 0 to canvas.height) {
      println()
      for (x <- 0 to canvas.width) {
        if (canvas.canvas(x)(y) == 0) {
          print(emptyChar)
        } else {
          print(canvas.canvas(x)(y))
        }
      }
    }
  }

  def +=(c: DrawCommand): Canvas = {
    copy(commands = commands += c)
  }

  override def isValidForCanvas(canvas: Canvas): Boolean = {
    width < canvas.width &&
      height < canvas.height
  }
}
