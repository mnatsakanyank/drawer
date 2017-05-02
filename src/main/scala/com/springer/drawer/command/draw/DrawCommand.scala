package com.springer.drawer.command.draw

import com.springer.drawer.command.Command

trait DrawCommand extends Command {
  def draw(canvas: Canvas): Unit
}
