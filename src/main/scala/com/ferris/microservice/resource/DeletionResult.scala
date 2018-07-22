package com.ferris.microservice.resource

case class DeletionResult(
  isSuccessful: Boolean
)

object DeletionResult {
  val successful = DeletionResult(true)
  val unsuccessful = DeletionResult(false)
}
