package com.ferris.microservice.route

import akka.http.scaladsl.model.{StatusCode, StatusCodes}
import akka.http.scaladsl.model.StatusCodes.Success
import com.ferris.microservice.resource.DeletionResult

trait FerrisResponseMappings {

  def mapDeletion(deleted: Boolean): (Success, DeletionResult) =
    if (deleted) (StatusCodes.OK, DeletionResult.successful)
    else (StatusCodes.OK, DeletionResult.unsuccessful)

  def mapUpdate(updated: Boolean): (StatusCode, String) =
    if (updated) (StatusCodes.OK, "updated")
    else (StatusCodes.NotModified, "not updated")

}
