package com.springer.drawer.command

trait Command {
  def draw(canvas: Canvas): Unit = {}
}
