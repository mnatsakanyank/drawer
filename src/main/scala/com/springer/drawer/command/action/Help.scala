package com.springer.drawer.command.action

object Help extends Action {

  override def execute(): Unit = {
    println(
      """Available commands are:
        |C w h (Canvas)
        |L x1 y1 x2 y2 (Line)
        |R x1 y1 x2 y2 (Rectangle)
        |B x y c (BucketFill)
        |Q (Quit)
        |H (Help)
      """.stripMargin)
  }
}
