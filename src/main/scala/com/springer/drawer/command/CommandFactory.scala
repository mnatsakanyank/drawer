package com.springer.drawer.command

import com.springer.drawer.action.{Help, Quit}


object CommandFactory {

  val canvasRegexp= "[C](\\s+\\d+){2}\\s*"
  val bucketFillRegexp= "[B](\\s+\\d+){2}\\s+[a-z]\\s*"
  val rectangleRegexp= "[R](\\s+\\d+){4}\\s*"
  val lineRegexp= "[L](\\s+\\d+){4}\\s*"
  val validCommandRegexp= "([A-Z](\\s+\\d+){1,4})\\s*[a-z]*\\s*|(Q|H)\\s*"
  val digits= "\\D+"

  def createCanvas(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(digits)
    Option(Canvas(spl(1).toInt,
      spl(2).toInt))
  }

  def buildBucketFill(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(digits)
    Option(BucketFill(spl(1).toInt,
      spl(2).toInt, maybeCommand.trim.last))
  }

  def buildRectangle(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(digits)
    Option(Rectangle(spl(1).toInt,
      spl(2).toInt,
      spl(3).toInt,
      spl(4).toInt))
  }

  def buildLine(maybeCommand: String): Option[Command] = {
    val spl: Array[String] = maybeCommand.split(digits)
    Option(Line(spl(1).toInt,
      spl(2).toInt,
      spl(3).toInt,
      spl(4).toInt))
  }

  def buildCommand(maybeCommand: String, builder: Option[Command] , regex: String): Option[Command] = {
    if (!maybeCommand.matches(regex))
      Option.empty
    else {
      builder
    }
  }

  def parseInput(maybeCommand: String): Option[Command] = {
    val maybeCommandTrim = maybeCommand.trim
    if (!maybeCommandTrim.matches(validCommandRegexp)) {
      return Option.empty
    }

    val command: Option[Command] = maybeCommandTrim(0) match {
      case 'C' => buildCommand(maybeCommand, createCanvas(maybeCommand),canvasRegexp)
      case 'B' => buildCommand(maybeCommand, buildBucketFill(maybeCommand), bucketFillRegexp)
      case 'R' => buildCommand(maybeCommand, buildRectangle(maybeCommand), rectangleRegexp)
      case 'L' => buildCommand(maybeCommand, buildLine(maybeCommand), lineRegexp)
      case 'Q' => Option(Quit())
      case 'H' => Option(Help())
      case _ => Option.empty
    }

    command
  }
}
