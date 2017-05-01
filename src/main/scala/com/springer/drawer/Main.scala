package com.springer.drawer

import java.util.Scanner

import com.springer.drawer.action.{Action, Help}
import com.springer.drawer.command.{Canvas, Command}
import com.springer.drawer.command.CommandFactory._

object Main extends App {

  val scanner: Scanner = new java.util.Scanner(System.in).useDelimiter("[\\r\\n]+")


  var canvas: Canvas = _
  while (canvas == null) {
    println("Please insert Canvas command")
    val command = askForCommand()
    if (command.isDefined && command.get.isInstanceOf[Canvas]) {
      canvas = command.get.asInstanceOf[Canvas]
    }
  }

  while (true) {
    println("Please insert command")
    val command = askForCommand()
    if (command.isDefined) {
      canvas += command.get
      canvas.draw(canvas)
      println()
    }
  }

  def askForCommand(): Option[Command] = {
    val command = scanner.next()
    val maybeCanvasCommand = parseInput(command)
    if (maybeCanvasCommand.isDefined) {
      maybeCanvasCommand.get match {
        case action: Action =>
          action.execute()
        case cmd: Command =>
          return Option(cmd)
      }
    } else {
      Help().execute()
    }
    Option.empty
  }

}
