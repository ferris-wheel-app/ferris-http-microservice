package com.ferris.microservice.resource

case class UpdateResult(
 updated: Boolean
)

object UpdateResult {
  val updated = UpdateResult(true)
  val notUpdated = UpdateResult(false)
}

