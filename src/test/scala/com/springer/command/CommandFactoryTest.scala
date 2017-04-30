package com.springer.command

import com.springer.drawer.action.{Help, Quit}
import com.springer.drawer.command._

class CommandFactoryTest extends org.scalatest.FunSuite {

  test("Valid Line command L 1 2 6 2 ") {
    val maybeCommand = CommandFactory.parseInput("L 1 2 6 2 ")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Line])
    val line: Line = maybeCommand.get.asInstanceOf[Line]
    assert(line.x1 == 1 && line.y1 == 2 && line.x2 == 6 && line.y2 == 2)
  }

  test("Valid Line command L 1 2 6 2 without space at the end") {
    val maybeCommand = CommandFactory.parseInput("L 1 2 6 2")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Line])
    val line: Line = maybeCommand.get.asInstanceOf[Line]
    assert(line.x1 == 1 && line.y1 == 2 && line.x2 == 6 && line.y2 == 2)
  }

  test("Invalid Line command L 1 2 6") {
    val maybeCommand = CommandFactory.parseInput("L 1 2 6")
    assert(maybeCommand.isEmpty)
  }

  test("Valid Rectangle command R 16 1 20 3") {
    val maybeCommand = CommandFactory.parseInput("R 16 1 20 3 ")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Rectangle])
    val line: Rectangle = maybeCommand.get.asInstanceOf[Rectangle]
    assert(line.x1 == 16 && line.y1 == 1 && line.x2 == 20 && line.y2 == 3)
  }

  test("Valid Rectangle command R 16 1 20 3 without space at the end") {
    val maybeCommand = CommandFactory.parseInput("R 16 1 20 3")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Rectangle])
    val line: Rectangle = maybeCommand.get.asInstanceOf[Rectangle]
    assert(line.x1 == 16 && line.y1 == 1 && line.x2 == 20 && line.y2 == 3)
  }

  test("Invalid Rectangle command R 16 1 20") {
    val maybeCommand = CommandFactory.parseInput("R 16 1 20")
    assert(maybeCommand.isEmpty)
  }

  test("Invalid Command UglyCommand") {
    val maybeCommand = CommandFactory.parseInput("UglyCommand")
    assert(maybeCommand.isEmpty)
  }

  test("Valid Canvas command C 20 4 ") {
    val maybeCommand = CommandFactory.parseInput("C 20 4 ")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Canvas])
    val line: Canvas = maybeCommand.get.asInstanceOf[Canvas]
    assert(line.height == 4 && line.width == 20)
  }

  test("Valid Canvas command C 20 4 without space at the end") {
    val maybeCommand = CommandFactory.parseInput("C 4 20")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Canvas])
    val line: Canvas = maybeCommand.get.asInstanceOf[Canvas]
    assert(line.height == 20 && line.width == 4)
  }

  test("Invalid Canvas command C 1") {
    val maybeCommand = CommandFactory.parseInput("C 1")
    assert(maybeCommand.isEmpty)
  }

  test("Valid BucketFill command B 10 3 o ") {
    val maybeCommand = CommandFactory.parseInput("B 10 3 o ")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[BucketFill])
    val line: BucketFill = maybeCommand.get.asInstanceOf[BucketFill]
    assert(line.x == 10 && line.y == 3 && line.c == 'o')
  }

  test("Valid BucketFill command with special symbol as color B 10 3 ! ") {
    val maybeCommand = CommandFactory.parseInput("B 10 3 ! ")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[BucketFill])
    val line: BucketFill = maybeCommand.get.asInstanceOf[BucketFill]
    assert(line.x == 10 && line.y == 3 && line.c == '!')
  }

  test("Valid BucketFill command C 20 4 without space at the end") {
    val maybeCommand = CommandFactory.parseInput("B 10 3 o")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[BucketFill])
    val line: BucketFill = maybeCommand.get.asInstanceOf[BucketFill]
    assert(line.x == 10 && line.y == 3 && line.c == 'o')
  }

  test("Invalid BucketFill command B 10 3") {
    val maybeCommand = CommandFactory.parseInput("B 10 3")
    assert(maybeCommand.isEmpty)
  }

  test("Valid Quit command") {
    val maybeCommand = CommandFactory.parseInput("Q")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Quit])
  }

  test("Valid Help command") {
    val maybeCommand = CommandFactory.parseInput("H")
    assert(maybeCommand.isDefined)
    assert(maybeCommand.get.isInstanceOf[Help])
  }
}
