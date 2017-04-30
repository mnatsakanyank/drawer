package com.springer.drawer.command

import com.springer.drawer.action.{Help, Quit}


object CommandFactory {

  val CanvasRegexp= "[C](\\s+\\d+){2}\\s*"
  val BucketFillRegexp= "[B](\\s+\\d+){2}\\s+.\\s*"
  val RectangleRegexp= "[R](\\s+\\d+){4}\\s*"
  val LineRegexp= "[L](\\s+\\d+){4}\\s*"
  val ValidCommandRegexp= "([A-Z](\\s+\\d+){1,4})\\s*.*\\s*|(Q|H)\\s*"
  val DigitsRegexp= "\\D+"

  def buildCanvas(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(DigitsRegexp)
    Option(Canvas(spl(1).toInt + 1,
      spl(2).toInt + 1))
  }

  def buildBucketFill(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(DigitsRegexp)
    Option(BucketFill(spl(1).toInt,
      spl(2).toInt, maybeCommand.trim.last))
  }

  def buildRectangle(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(DigitsRegexp)
    Option(Rectangle(spl(1).toInt,
      spl(2).toInt,
      spl(3).toInt,
      spl(4).toInt))
  }

  def buildLine(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(DigitsRegexp)
    Option(Line(spl(1).toInt,
      spl(2).toInt,
      spl(3).toInt,
      spl(4).toInt))
  }

  def buildCommand(maybeCommand: String, builder: () => Option[Command], regex: String): Option[Command] = {
    if (!maybeCommand.matches(regex))
      Option.empty
    else {
      builder.apply()
    }
  }

  def parseInput(maybeCommand: String): Option[Command] = {
    val maybeCommandTrim = maybeCommand.trim
    if (!maybeCommandTrim.matches(ValidCommandRegexp)) {
      return Option.empty
    }

    val command: Option[Command] = maybeCommandTrim(0) match {
      case 'C' => buildCommand(maybeCommand,() => buildCanvas(maybeCommand),CanvasRegexp)
      case 'B' => buildCommand(maybeCommand,() => buildBucketFill(maybeCommand), BucketFillRegexp)
      case 'R' => buildCommand(maybeCommand,() => buildRectangle(maybeCommand), RectangleRegexp)
      case 'L' => buildCommand(maybeCommand,() => buildLine(maybeCommand), LineRegexp)
      case 'Q' => Option(Quit())
      case 'H' => Option(Help())
      case _ => Option.empty
    }

    command
  }
}
