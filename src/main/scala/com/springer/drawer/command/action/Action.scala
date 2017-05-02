package com.springer.drawer.command.action

import com.springer.drawer.command.Command

trait Action extends Command {
  def execute()
}
