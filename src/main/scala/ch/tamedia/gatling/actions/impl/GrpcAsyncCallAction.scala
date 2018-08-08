package ch.tamedia.gatling.actions.impl

import ch.tamedia.gatling.actions.GrpcExecutableAsyncAction
import ch.tamedia.gatling.log.LogEndpointGrpc.LogEndpointStub
import ch.tamedia.gatling.log.{LogEndpointGrpc, LogRequest}
import io.grpc.ManagedChannelBuilder
import scalapb.GeneratedMessage

import scala.concurrent.Future

/**
  * Async call action
  */
object GrpcAsyncCallAction {
  /**
    * Constructor that needs couple of params in order to create valid gRPC connection
    * @param name           - function name
    * @param host           - server host
    * @param port           - server port
    * @param requestMessage - message to be send as request
    * @return               - GrpcAsyncCallAction
    */
  def apply(name: String, host: String, port: Int, requestMessage: String): GrpcAsyncCallAction = new GrpcAsyncCallAction(name, host, port, requestMessage)
}

class GrpcAsyncCallAction(val name: String, host: String, port: Int, requestMessage: String) extends GrpcExecutableAsyncAction{

  var channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext.build
  val asyncCall: LogEndpointStub = LogEndpointGrpc.stub(channel)

  /**
    * Send async call to the server
    * @return Future[GeneratedMessage]
    */
  override def executeAsync: Future[GeneratedMessage] = asyncCall.send(new LogRequest(requestMessage))
}
