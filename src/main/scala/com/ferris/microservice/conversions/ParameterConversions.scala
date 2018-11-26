package com.ferris.microservice.conversions

import java.time.{LocalDate, LocalDateTime}
import java.time.format.DateTimeFormatter
import java.util.UUID

import akka.http.scaladsl.unmarshalling.{FromStringUnmarshaller, Unmarshaller}

import scala.concurrent.Future

trait ParameterConversions {
  implicit val uuidUnmarshaller: FromStringUnmarshaller[UUID] =
    Unmarshaller(_ => uuid => Future.successful(UUID.fromString(uuid)))

  implicit val csvUuidUnmarshaller: FromStringUnmarshaller[Seq[UUID]] =
    Unmarshaller(_ => uuids => Future.successful(ParamUtils.parseUUIDList(uuids)))

  implicit val dateTimeUnmarshaller: FromStringUnmarshaller[LocalDateTime] =
    Unmarshaller(_ => dateTime => Future.successful(ParamUtils.parseDateTime(dateTime)))

  implicit val dateUnmarshaller: FromStringUnmarshaller[LocalDate] =
    Unmarshaller(_ => dateTime => Future.successful(ParamUtils.parseDate(dateTime)))

  object ParamUtils {
    def parseUUIDList(commaSeparated: String): List[UUID] = {
      parseStrings(commaSeparated).map(UUID.fromString)
    }

    def parseStrings(commaSeparated: String): List[String] = {
      commaSeparated.split(',').filter(_ != "").toList
    }

    def parseDateTime(dateTime: String): LocalDateTime = {
      LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME)
    }

    def parseDate(date: String): LocalDate = {
      LocalDate.parse(date, DateTimeFormatter.ISO_DATE)
    }
  }
}

object ParameterConversions extends ParameterConversions
