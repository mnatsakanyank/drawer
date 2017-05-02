package com.springer.drawer.command

import com.springer.drawer.command.draw.{BucketFill, Canvas, Line, Rectangle}
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class CanvasTest extends FunSuite with Matchers with BeforeAndAfter {

  var canvas: Canvas = _

  before {
    canvas = Canvas(21, 5)
  }

  test("Canvas with horizontal Line") {
    val line: Line = Line(1, 2, 6, 2)
    canvas += line
    exactly(1, canvas.commands)
    canvas.commands should contain only line
    canvas.draw(canvas)
    assertLine(canvas.canvas, line)
  }

  test("Canvas with vertical Line") {
    val line: Line = Line(6, 3, 6, 4)
    canvas += line
    exactly(1, canvas.commands)
    canvas.commands should contain only line
    canvas.draw(canvas)
    assertLine(canvas.canvas, line)
  }

  test("Canvas with BucketFill") {
    val bucketFill: BucketFill = BucketFill(10, 3, 'o')
    canvas += bucketFill
    exactly(1, canvas.commands)
    canvas.commands should contain only bucketFill
    canvas.draw(canvas)
    assertBucketFill(canvas.canvas, bucketFill)
  }

  test("Canvas with Rectangle") {
    val bucketFill: Rectangle = Rectangle(16, 1, 20, 3)
    canvas += bucketFill
    exactly(1, canvas.commands)
    canvas.commands should contain only bucketFill
    canvas.draw(canvas)
    assertRectangle(canvas.canvas, bucketFill)
  }


  def assertLine(canvas: Array[Array[Char]], line: Line): Unit = {
    for (y <- canvas(0).indices) {
      for (x <- canvas.indices) {
        if (x >= line.x1 && x <= line.x2 && y >= line.y1 && y <= line.y2) {
          assert(canvas(x)(y) == line.color)
        } else {
          assert(canvas(x)(y) != line.color)
        }
      }
    }
  }

  def assertBucketFill(canvas: Array[Array[Char]], bucketFill: BucketFill): Unit = {
    for (y <- 1 until canvas(0).length - 2) {
      for (x <- 1 until (canvas.length - 2)) {
        assert(canvas(x)(y) == bucketFill.color)
      }
    }
  }

  def assertRectangle(canvas: Array[Array[Char]], rectangle: Rectangle): Unit = {
    for (y <- canvas(0).indices) {
      for (x <- canvas.indices) {
        if ((x == rectangle.x1 || x == rectangle.x2) && rectangle.y1 <= y && y <= rectangle.y2)
          assert(canvas(x)(y) == rectangle.color)
        else if ((y == rectangle.y1 || y == rectangle.y2) && rectangle.x1 <= x && x <= rectangle.x2)
          assert(canvas(x)(y) == rectangle.color)
        else {
          assert(canvas(x)(y) != rectangle.color)
        }
      }
    }
  }
}
