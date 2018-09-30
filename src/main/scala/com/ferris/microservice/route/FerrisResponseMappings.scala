package com.ferris.microservice.route

import akka.http.scaladsl.model.{StatusCode, StatusCodes}
import akka.http.scaladsl.model.StatusCodes.Success
import com.ferris.microservice.resource._

trait FerrisResponseMappings {

  def mapDeletion(deleted: Boolean): (Success, DeletionResult) =
    if (deleted) (StatusCodes.OK, DeletionResult.successful)
    else (StatusCodes.OK, DeletionResult.unsuccessful)

  def mapUpdate(updated: Boolean): (StatusCode, UpdateResult) =
    if (updated) (StatusCodes.OK, UpdateResult.updated)
    else (StatusCodes.NotModified, UpdateResult.notUpdated)

}
