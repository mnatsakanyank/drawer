package com.springer.drawer

import java.util.Scanner

import com.springer.drawer.action.{Action, Help}
import com.springer.drawer.command.{Canvas, Command}
import com.springer.drawer.command.CommandFactory._

object Drawer {
  val scanner: Scanner = new java.util.Scanner(System.in).useDelimiter("[\\r\\n]+")


  def main(args: Array[String]): Unit = {

    val canvas: Canvas = Canvas(20 + 1, 4 + 1)
      canvas += parseInput("L 1 2 6 2 ").get
      canvas += parseInput("L 6 3 6 4").get
      canvas += parseInput("R 16 1 20 3").get
      canvas += parseInput("B 10 3 o ").get
//    canvas += Line(1, 2, 6, 2)
//    canvas += Line(6, 3, 6, 4)
//    canvas += Rectangle(16, 1, 20, 3)
//    canvas += BucketFill(10, 3, 'o')
//    canvas += BucketFill(1, 3, 'o')

    canvas.draw(canvas)

//    while (true) {
//      val command = scanner.next()
//
//      val maybeCommand = parseInput(command)
//      if (maybeCommand.isDefined) {
//        maybeCommand.get match {
//          case action: Action =>
//            action.executeAction()
//          case cmd: Command =>
//            canvas += cmd
//        }
//      } else {
//        Help().executeAction()
//      }
//
//      canvas.draw(canvas)
//    }

  }

  def askForCanvasCommand(): Canvas = {
    println("Please insert Canvas command:")
    while (true) {
      val command = scanner.next()
      val maybeCanvasCommand = parseInput(command)
      if (maybeCanvasCommand.isDefined) {
        maybeCanvasCommand.get match {
          case action: Action =>
            action.executeAction()
          case canvas: Canvas =>
            return canvas
          case _ =>
        }
      } else {
        Help().executeAction()
      }
    }
    null
  }

}
