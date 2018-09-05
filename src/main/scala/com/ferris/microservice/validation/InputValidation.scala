package com.ferris.microservice.validation

import com.ferris.microservice.exceptions.ApiExceptions.{InvalidFieldException, InvalidFieldPayload}

trait InputValidation {

  protected def checkMaxSize[T](list: Seq[T], name: String, max: Int): Unit = {
    checkField(list.size <= max, name, s"${camelCaseToSpaced(name)} must be a maximum of $max items")
  }

  protected def checkMinSize[T](list: Seq[T], name: String, min: Int): Unit = {
    checkField(list.size >= min, name, s"${camelCaseToSpaced(name)} must be a minimum of $min items")
  }

  protected def checkForDuplication[A](ls: Seq[A], name: String): Unit = {
    checkField(ls.toSet.size == ls.size, name, s"${camelCaseToSpaced(name)} cannot contain duplicate entries")
  }

  protected def checkField(cond: Boolean, name: String): Unit = {
    val displayedName: String = camelCaseToSpaced(name)
    if (!cond) throw InvalidFieldException("InvalidField", s"Invalid $displayedName", Some(InvalidFieldPayload(name)))
  }

  protected def checkField(cond: Boolean, name: String, msg: String): Unit = {
    if (!cond) throw InvalidFieldException("InvalidField", msg, Some(InvalidFieldPayload(name)))
  }

  protected def camelCaseToSpaced(s: String): String = {
    require(s.length > 0)
    val tail = s.substring(1).foldRight(List.empty[Char]){ (char, arr) =>
      if (char.isUpper) ' ' :: char :: arr
      else char :: arr
    }
    s.charAt(0).toUpper :: tail mkString ""
  }
}
