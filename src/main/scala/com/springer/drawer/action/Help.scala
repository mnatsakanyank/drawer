package com.springer.drawer.action

import com.springer.drawer.command.Command

case class Help() extends Command with Action {

  override def executeAction(): Unit = {
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
