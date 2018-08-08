package ch.tamedia.gatling

import io.gatling.commons.validation.Success
import io.gatling.core.check.{Check, Extender, Preparer}
import scalapb.GeneratedMessage

object grpc {
  type GrpcCheck = Check[GeneratedMessage]

  val GrpcStringExtender: Extender[GrpcCheck, GeneratedMessage] = (check: GrpcCheck) => check

  val GrpcStringPreparer: Preparer[String, String] = (result: String) => Success(result)
}
